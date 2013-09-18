


import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Table extends JPanel {

	  JTable itemTable = null;
	  TableModel tm = new TableModel ();

	  public Table () {
	    super ();
	    tm.addRow (new TableItem (1, "A bright sunny day", "text"));
	    tm.addRow (new TableItem (2, "Evening rainstorm", "text"));

	    itemTable = new JTable (tm);

			// Set up drop down box as editor and use image as renderer
	    //JComboBox itemTypes = new JComboBox (TableItem.getDescriptions());
	    //itemTypes.setRenderer (new TypeDropDownRenderer ());
	   // TableColumn typeColumn = itemTable.getColumnModel().getColumn (0);
	    //typeColumn.setCellEditor (new DefaultCellEditor(itemTypes));
	    //typeColumn.setCellRenderer (new itemTypeRenderer());
			
			// Lock the with of the columns
	    itemTable.getColumnModel().getColumn(0).setPreferredWidth(70);
	    itemTable.getColumnModel().getColumn(1).setPreferredWidth(250);
	    itemTable.getColumnModel().getColumn(2).setPreferredWidth(100);
			// And the above is useless unless we tell the table to not automatically resize
	    itemTable.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);

	    add (new JScrollPane (itemTable));
	  }

	  public static void main (String args[]) {
	    new Table ();
	 
	  }
}
