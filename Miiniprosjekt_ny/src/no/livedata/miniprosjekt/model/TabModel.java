package no.livedata.miniprosjekt.model;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import no.livedata.miniprosjekt.GUI.Main;
import no.livedata.miniprosjekt.elements.*;

/**
 * Model for holding tabledata
 *
 */
@SuppressWarnings("serial")
public class TabModel extends AbstractTableModel {
	Vector<BaseElement> data = new Vector<BaseElement>();	// vector to hold all data
	String titles[] = {										// column titles
							Main.messages.getString("type"), 
							Main.messages.getString("name"), 
							Main.messages.getString("text"), 
							Main.messages.getString("row"), 
							Main.messages.getString("col"), 
							Main.messages.getString("rows"),
							Main.messages.getString("cols"), 
							Main.messages.getString("fill"),
							Main.messages.getString("anchor")
					   };
	JFrame mainFrame; // frame for table
	
	/**
	 * Sets the frame that contains the table for this table model
	 */
	public void setTableFrame (JFrame f) {
		mainFrame = f;
	}
	
	/**
	 * get column name
	 * @return String column name
	 */
	@Override
	public String getColumnName(int column) {
		return titles[column];
	}
	
	/**
	 * get column class
	 * @return Class class of column
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	/**
	 * get number of columns
	 * @return int number of columns
	 */
	@Override
	public int getColumnCount() {
		return titles.length;
	}
	
	/**
	 * get row count
	 * @return int number of rows
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	/**
	 * get value in cell
	 * @return Object the value of the field
	 */
	@Override
	public Object getValueAt(int row, int col) {
		BaseElement element = data.get(row);
		if (col>0) {
			switch (col) {
				case 1 : return element.getName();
				case 2 : return element.getText();
				case 3 : return element.getRow();
				case 4 : return element.getColumn();
				case 5 : return element.getRows();
				case 6 : return element.getColumns();
				case 7 : return element.getFill();
				case 8 : return element.getAnchor();
			}
		} else {
			if (element instanceof Label)
				return "JLabel";
			else if (element instanceof TextField)
				return "JTextField";
			else if (element instanceof TextArea)
				return "JTextArea";
			else if (element instanceof Button)
				return "JButton";
		}
		return null;
	}
	
	/**
	 * Move row
	 * @param from the row to be moved
	 * @param to the row to move to
	 */
	public void moveRow(int from, int to) {
		// switches columns
		BaseElement temp1 = data.get(from);
		BaseElement temp2 = data.get(to);
		data.set(to, temp1);
		data.set(from, temp2);
		// updates data
		fireTableDataChanged();
	}
	
	/**
	 * add new row
	 * @param num the element number
	 */
	public void addElement (int num) {
		BaseElement label = new Label(num);
		data.add (label); // add row
		// insert to table
		fireTableRowsInserted(data.size(), data.size());
	}
	
	/**
	 * all cells are editable
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	/**
	 * set value at
	 * sets the value in a cell
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		BaseElement element = data.get(rowIndex);
		switch (columnIndex) {
			case 0:
				BaseElement newElement = null;
				if (((String)aValue).equals("JLabel")) {
					newElement = new Label (element);
				} else if (((String)aValue).equals("JTextField")) {
					newElement = new TextField (element);
				} else if (((String)aValue).equals("JTextArea")) {
					newElement = new TextArea (element);
				} else if (((String)aValue).equals("JButton")) {
					newElement = new Button (element);
				}
				data.set(rowIndex, newElement);
				break;
			case 1:
				element.setName ((String)aValue); break;
			case 2:
				element.setText ((String)aValue); break;
			case 3:
				element.setRow ((Integer)aValue); break;
			case 4:
				element.setColumn ((Integer)aValue); break;
			case 5:
				element.setRows ((Integer)aValue); break;
			case 6:
				element.setColumns ((Integer)aValue); break;
			case 7:
				element.setFill ((String)aValue); break;
			case 8:
				element.setAnchor ((String)aValue); break;
		
		}
		// update cell
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	/**
	 * Clear all data
	 */
	public void clear() {
		data.clear();
		fireTableDataChanged();
	}
	
	/**
	 * delete row
	 * @param del row to delete
	 */
	public void delete(int del) {
		data.remove(del);
		fireTableDataChanged();
	}
	
	/**
	 * Save object to file
	 * @param oos objectoutputstream
	 */
	public void save (ObjectOutputStream oos) {
		try {
			for (int i=0; i<data.size(); i++) // write all objects in data to file
				oos.writeObject(data.get(i));
		} catch (IOException ioe) {
			System.err.println (Main.messages.getString("failWrite"));
		}
	}
	
	/**
	 * Read objects from file
	 * @param ois objectinputstream
	 */
	public void load (ObjectInputStream ois) {
		data.clear(); // cvlear existing data
		try {
			while (true) { // read all elements from file
				BaseElement animal = (BaseElement)ois.readObject();
				data.add(animal); // add element
			}
		} catch (EOFException eofe) {
			// End of file
		} catch (ClassCastException cce) {
			System.err.println (Main.messages.getString("failFormat"));
		} catch (ClassNotFoundException cnfe) {
			System.err.println (Main.messages.getString("failFile"));
		} catch (IOException ioe) {
			System.err.println (Main.messages.getString("failRead"));
		} finally {
			// update data
			fireTableDataChanged();
		}
		
	}
	
	/**
	 * Get all data
	 * @return Vector<BaseElement> with all data
	 */
	public Vector<BaseElement> getData () {
		return data;
	}
	
	/**
	 * Get element at row
	 * @param row of element to get
	 * @return BaseElement in row
	 */
	public BaseElement getRow(int row) {
		return data.get(row);
	}
}