package no.livedata.miniprosjekt.GUI;


import java.awt.BorderLayout;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

import no.livedata.miniprosjekt.elements.BaseElement;
import no.livedata.miniprosjekt.model.TabModel;


/**
 *	The main script for the editor
 */
public class Main extends JFrame {
	private TabModel dataModel = new TabModel (); // datamodel to store tabledata
	private JTable table = new JTable (dataModel); // table from tablemodel
	// element option elements
	private String elements[] = {"JLabel", "JTextField", "JTextArea", "JButton" };
	// selector for element type
	private JComboBox<String> elementTypeEditor = new JComboBox<String> (elements);
	JLabel status; // status label
	
	public static ResourceBundle messages; // used to get internationalicing
	/**
	 * Constructor
	 * setts all up
	 */
	public Main () {
		super(Main.messages.getString("title"));
		
		dataModel.setTableFrame(this); // set table frame
		// set elemet type editor
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(elementTypeEditor));
		
		// set right click menu
		table.setComponentPopupMenu(new PopUp(this, table, dataModel));
		// make headers not movable
        table.getTableHeader().setReorderingAllowed(false);
        
        // Set up drop down box as editor and use image as renderer for fill
        JComboBox fillTypes = new JComboBox (BaseElement.getFills());
        fillTypes.setRenderer (new FillDropDownRenderer ());
        TableColumn fillColumn = table.getColumnModel().getColumn (7);
        fillColumn.setCellEditor (new DefaultCellEditor(fillTypes));
        fillColumn.setCellRenderer (new FillTypeRenderer());
        
        // Set up drop down box as editor and use image as renderer for anchor
        JComboBox anchorTypes = new JComboBox (BaseElement.getAnchors());
        anchorTypes.setRenderer (new AnchorDropDownRenderer ());
        TableColumn anchorColumn = table.getColumnModel().getColumn (8);
        anchorColumn.setCellEditor (new DefaultCellEditor(anchorTypes));
        anchorColumn.setCellRenderer (new AnchorTypeRenderer());
        
        // Lock the with of the columns
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(70);
        table.getColumnModel().getColumn(6).setPreferredWidth(70);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(80);
    	// dont automatically resize table
        table.setAutoResizeMode (JTable.AUTO_RESIZE_OFF);
		
		status = new JLabel (" "); // initialice status
		// add menu and toolbar
		Toolbar tb = new Toolbar(dataModel, table, this, this);
		setJMenuBar (tb.menuBar);
		add (tb.toolBar, BorderLayout.NORTH);
		
		// add table to layout
		add (new JScrollPane(table), BorderLayout.CENTER);
		
		// add status
		add(status, BorderLayout.SOUTH);
		
		pack(); // makes window fit all components
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Set statustext
	 * @param stat statustext to set
	 */
	public void setStatus(String stat) {
		status.setText(stat);
	}
	

	public static void main(String[] args) {
		// add internationalicing
		Locale currentLocale;
		
		if (args.length==2) {
			currentLocale = new Locale (args[0], args[1]);	// Språk, land
		} else if (args.length==1) {
			currentLocale = new Locale (args[0]);	// språk
		} else
			currentLocale = Locale.getDefault();
		
		// set current language
		messages = ResourceBundle.getBundle ("I18N", currentLocale);
		
		// start the editor
		new Main();
	}

}
