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
 *
 */
public class Main extends JFrame {
	private TabModel dataModel = new TabModel ();
	private JTable table = new JTable (dataModel);
	private String elements[] = {"JLabel", "JTextField", "JTextArea", "JButton" };
	private JComboBox<String> elementTypeEditor = new JComboBox<String> (elements);
	
	public static ResourceBundle messages;
	public Main () {
		super("GridBagLayoutEditor");
		dataModel.setTableFrame(this);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(elementTypeEditor));
		
		Toolbar tb = new Toolbar(dataModel, table, this);
		setJMenuBar (tb.menuBar);
		add (tb.toolBar, BorderLayout.NORTH);
		add (new JScrollPane(table), BorderLayout.CENTER);
		JLabel status = new JLabel ("Status");
		add(status, BorderLayout.SOUTH);
		
        table.setComponentPopupMenu(new PopUp(this, table, dataModel));
        table.getTableHeader().setReorderingAllowed(false);
		
		pack(); // makes window fit all components
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		Locale currentLocale;
		
		if (args.length==2) {
			currentLocale = new Locale (args[0], args[1]);	// Språk, land
		} else if (args.length==1) {
			currentLocale = new Locale (args[0]);	// språk
		} else
			currentLocale = Locale.getDefault();
			
		messages = ResourceBundle.getBundle ("I18N", currentLocale);
		
		new Main();
	}

}
