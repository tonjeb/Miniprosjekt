package no.livedata.miniprosjekt.model;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import no.livedata.miniprosjekt.GUI.Main;
import no.livedata.miniprosjekt.elements.*;

@SuppressWarnings("serial")
public class TabModel extends AbstractTableModel {
	Vector<BaseElement> data = new Vector<BaseElement>();
	String titles[] = {
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
	JFrame mainFrame;
	
	/*
	 * Sets the frame that contains the table for this table model
	 */
	public void setTableFrame (JFrame f) {
		mainFrame = f;
	}

	@Override
	public String getColumnName(int column) {
		return titles[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

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
	
	public void moveRow(int from, int to) {
		BaseElement temp1 = data.get(from);
		BaseElement temp2 = data.get(to);
		data.set(to, temp1);
		data.set(from, temp2);
		fireTableDataChanged();
	}
	
	public void addElement (int num) {
		BaseElement label = new Label(num);
		data.add (label);
		fireTableRowsInserted(data.size(), data.size());
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
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
				element.setName ((String)aValue);
			case 2:
				element.setText ((String)aValue);
			case 3:
				element.setRow ((Integer)aValue);
			case 4:
				element.setColumn ((Integer)aValue);
			case 5:
				element.setRows ((Integer)aValue);
			case 6:
				element.setColumns ((Integer)aValue);
			
			// TODO: add for fill and anchor
		
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	public void clear() {
		data.clear();
		fireTableDataChanged();
	}
	
	public void save (ObjectOutputStream oos) {
		try {
			for (int i=0; i<data.size(); i++)
				oos.writeObject(data.get(i));
		} catch (IOException ioe) {
			System.err.println (Main.messages.getString("failWrite"));
		}
	}
	
	public void load (ObjectInputStream ois) {
		data.clear();
		try {
			while (true) {
				BaseElement animal = (BaseElement)ois.readObject();
				data.add(animal);
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
			fireTableDataChanged();
		}
	}
	
	public Vector<BaseElement> getData () {
		return data;
	}
	
	public BaseElement getRow(int row) {
		return data.get(row);
	}
}