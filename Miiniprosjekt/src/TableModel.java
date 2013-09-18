

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel	 {
	// Still needs to hold the column titles
	  private String columnNames[] = { "Type", "Variabelnavn", "Text" };
		// Using a vector to store the data, this can be anything really
	  private java.util.Vector<TableItem> data = new java.util.Vector<TableItem>();

		// Method used to add a row to the data model
	  public void addRow (TableItem wi) {
			// Adding the data to the vector
	    data.add (wi);
			// Let the table display know that the table needs to be redrawn
	    fireTableRowsInserted (data.size()-1, data.size()-1);
	  }

		// Get the number of columns in the model
	  public int getColumnCount() {
	    return columnNames.length;
	  }

		// Get the number of rows in the model
	  public int getRowCount() {
	    return data.size();
	  }

		// Get the name of a given column
	  public String getColumnName(int col) {
	    return columnNames[col];
	  }

		// Get the value for a given row/column
	  public Object getValueAt(int row, int col) {
			// Data is returned as object
	    switch (col) {
				// we need to wrap the int as an Integer
	      case 0 : return new Integer (((TableItem)data.elementAt (row)).itemType());
	      case 1 : return ((TableItem)data.elementAt (row)).getVariableName(); 
	      case 2 : return ((TableItem)data.elementAt(row)).getText();
	      
	    }
	    
	    return null;
	  }

		// Get the class for a given column, this is used to determine how to render the data
	  public Class getColumnClass(int c) {
	    return getValueAt(0, c).getClass();
	  }

	  /*
	   * Don't need to implement this method unless your table's
	   * editable.
	   */
	  public boolean isCellEditable(int row, int col) {
	    //Note that the data/cell address is constant,
	    //no matter where the cell appears onscreen.
	    if (col < 2) {
	      return true;
	    } else {
	      return false;
	    }
	  }

	  /*
	   * Don't need to implement this method unless your table's
	   * data can change.
	   */
	  public void setValueAt(Object value, int row, int col) {
			// Fetch the element to be changed
	    TableItem wi = (TableItem)data.elementAt (row);
			// Change the weather type or description
	    /*
	    switch (col) {
				// The weather type can be an Integer or a String
	      case 0 : if (value instanceof Integer)
									 wi.setSETINNType (((Integer)value).intValue());
								 else
									 wi.setSETTINNType (((String)value));
	               break;
	      case 1 : wi.setTableDescription ((String)value);
	               break;
	    }
	    */
			// Let the model display know it needs to redraw the table
	    fireTableCellUpdated(row, col);
	  }
	  

}
