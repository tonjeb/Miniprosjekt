package no.livedata.miniprosjekt.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;

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
