package no.livedata.miniprosjekt.GUI;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import no.livedata.miniprosjekt.model.TabModel;

/**
 * Right click menu
 * the menu to be displayed on right click in table
 *
 */
public class PopUp extends JPopupMenu {
	static JTable table; // the table
	TabModel dataModel; // the datamodel
	Point openAt; // the point where menu is opened
	
	/**
	 * Constructor
	 * creates the menu
	 * 
	 * @param com the component to run on
	 * @param table the table to use
	 * @param dataModel the datamodel to use
	 */
	public PopUp (final Component com, JTable table, final TabModel dataModel) {
		// set values passed
		this.table = table;
		this.dataModel = dataModel;
		
		// create properties option
		JMenuItem optItem = new JMenuItem(Main.messages.getString("prop"));
        optItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataModel.getRow(getRow()).showProp(); // show elements properties
            }
        });
        add(optItem);
        
        // create delete option
        JMenuItem deleteItem = new JMenuItem(Main.messages.getString("cdel"));
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dataModel.delete(getRow()); // delete element
            }
        });
        add(deleteItem);
	}
	
	/**
	 * show
	 * is called on menucreation
	 * gets startpoint and pass it to super
	 */
	@Override
    public void show(Component c, int x, int y) {
		openAt = new Point(x,y); // save point
        super.show(c, x, y);
    }
	
	/**
	 * get the row right clicked on
	 * @return int rownumber
	 */
	public int getRow() {
		return table.rowAtPoint(openAt);
	}
}
