package no.livedata.miniprosjekt.GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import no.livedata.miniprosjekt.elements.BaseElement;
import no.livedata.miniprosjekt.model.TabModel;



public class Toolbar {
	
	
	public JMenuBar menuBar;
	public JToolBar toolBar;
	
	private TabModel dataModel;
	private Component comp;
	private int num;
	private JTable table;
	private File curFile = null;
	
	public Toolbar(TabModel model, final JTable table, Component com) {
		
		// save datamodel to modify it
		dataModel = model;
		
		// save component to add gui
		comp = com;
		
		// element numbering
		num = 0;
		
		// element to save current table
		this.table = table;
		
		// where the images are located relative to the file
		String imageBase = "../../../../";
		
		// FILE MENU
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction createNew = new AbstractAction (Main.messages.getString("new"),
														new ImageIcon (getClass().getResource(imageBase + "images/NEW.GIF"))) {
			public void actionPerformed (ActionEvent ae) {
				dataModel.clear();
			}
		};
		// Setting the mnemonic key used in menus
		createNew.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("newM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction open = new AbstractAction (Main.messages.getString("open"),
														new ImageIcon (getClass().getResource(imageBase + "images/OPENDOC.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				load();
			}
		};
		// Setting the mnemonic key used in menues
		open.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("openM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction save = new AbstractAction (Main.messages.getString("save"),
														new ImageIcon (getClass().getResource(imageBase + "images/SAVE.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				save();
			}
		};
		// Setting the mnemonic key used in menues
		save.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("saveM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction saveAs = new AbstractAction (Main.messages.getString("saveAs"),
														new ImageIcon (getClass().getResource(imageBase + "images/SAVE.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				saveAs();
			}
		};
		// Setting the mnemonic key used in menues
		saveAs.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("saveAsM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction saveJava = new AbstractAction (Main.messages.getString("saveJava"),
														new ImageIcon (getClass().getResource(imageBase + "images/SAVEJAVA.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				saveCode();
			}
		};
		// Setting the mnemonic key used in menues
		saveJava.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("saveJavaM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction exit = new AbstractAction (Main.messages.getString("exit")) {
			public void actionPerformed (ActionEvent ae) {
				System.exit (0);
			}
		};
		// Setting the mnemonic key used in menues
		exit.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("exitM").toCharArray()[0]));
		
		// EDIT MENU
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction add = new AbstractAction (Main.messages.getString("add"),
													new ImageIcon (getClass().getResource(imageBase + "images/NEWROW.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				dataModel.addElement(num++);
			}
		};
		// Setting the mnemonic key used in menues
		add.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("addM").toCharArray()[0]));
		
		/*// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction pref = new AbstractAction (Main.messages.getString("pref")) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("prefM").toCharArray()[0]));
		*/
		
		// HELP MENU
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction help = new AbstractAction (Main.messages.getString("help"),
													new ImageIcon (getClass().getResource(imageBase + "images/HELP.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				JOptionPane.showMessageDialog (comp, "Find help here!", "Help", JOptionPane.PLAIN_MESSAGE);
			}
		};
		// Setting the mnemonic key used in menues
		help.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("helpM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction about = new AbstractAction (Main.messages.getString("about")) {
			public void actionPerformed (ActionEvent ae) {
				JOptionPane.showMessageDialog (comp, "This is all about the program!", "About", JOptionPane.PLAIN_MESSAGE);
			}
		};
		// Setting the mnemonic key used in menues
		about.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("aboutM").toCharArray()[0]));
		
		// TOOLBAR MENUS
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction up = new AbstractAction (Main.messages.getString("up"),
													new ImageIcon (getClass().getResource(imageBase + "images/MoveRowUp.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				try{
					int rowToMove = table.convertRowIndexToModel( table.getSelectedRow() );
					if (rowToMove != 0)
						dataModel.moveRow(rowToMove,rowToMove-1); 
				}catch (Exception e) {
					
				}
			}
		};
		// Setting the mnemonic key used in menues
		up.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("upM").toCharArray()[0]));
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction down = new AbstractAction (Main.messages.getString("down"),
													new ImageIcon (getClass().getResource(imageBase + "images/MoveRowDown.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				try{
					int rowToMove = table.convertRowIndexToModel( table.getSelectedRow() );
					if (rowToMove < dataModel.getData().size()-1)
						dataModel.moveRow(rowToMove, rowToMove+1);
				}catch (Exception e) {
					
				}
			}
		};
		// Setting the mnemonic key used in menues
		down.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("downM").toCharArray()[0]));

		// Create a new menu bar
		menuBar = new JMenuBar ();
		JMenu fileMenu = new JMenu (Main.messages.getString("file"));
		fileMenu.setMnemonic (Main.messages.getString("fileM").toCharArray()[0]);
		JMenu editMenu = new JMenu (Main.messages.getString("edit"));
		editMenu.setMnemonic (Main.messages.getString("editM").toCharArray()[0]);
		JMenu helpMenu = new JMenu (Main.messages.getString("help"));
		helpMenu.setMnemonic (Main.messages.getString("helpM").toCharArray()[0]);
			


		// FILE MENU
		// Adding the abstract action objects as menu items
		JMenuItem createNewItem = new JMenuItem (createNew);
		// Accelerator keys enable advanced users to access menu items without navigating the menu
		createNewItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("newM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem openItem = new JMenuItem (open);
		// The KeyEvent object defines all possible keystrokes, handy for function keys
		openItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("openM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem saveItem = new JMenuItem (save);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		saveItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("saveM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem saveAsItem = new JMenuItem (saveAs);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		saveAsItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("saveM").toCharArray()[0], InputEvent.SHIFT_DOWN_MASK));
		
		JMenuItem saveJavaItem = new JMenuItem (saveJava);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		saveJavaItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("saveJavaM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem exitItem = new JMenuItem (exit);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		exitItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("exitM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		// EDIT MENU
		JMenuItem addItem = new JMenuItem (add);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		addItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("addM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		/*JMenuItem prefItem = new JMenuItem (pref);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		prefItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("prefM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		*/
		
		// EDIT MENU
		JMenuItem helpItem = new JMenuItem (help);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		helpItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("helpM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem aboutItem = new JMenuItem (about);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		aboutItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("aboutM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
				
		
		fileMenu.add (createNewItem);
		fileMenu.add (openItem);
		fileMenu.add (saveItem);
		fileMenu.add (saveAsItem);
		fileMenu.addSeparator();
		fileMenu.add (saveJavaItem);
		fileMenu.addSeparator();
		fileMenu.add (exitItem);
		//
		editMenu.add (addItem);
		editMenu.addSeparator();
		//editMenu.add(prefItem);
		//
		helpMenu.add (helpItem);
		helpMenu.add (aboutItem);
		menuBar.add (fileMenu);
		menuBar.add (editMenu);
		// Adding some glue, this puts the remaining menu items to the right
		//menuBar.add (Box.createHorizontalGlue());
		menuBar.add (helpMenu);


			
		toolBar = new JToolBar ();
		toolBar.add (createNew);
		toolBar.add (open);
		toolBar.add (save);
		toolBar.addSeparator();
		toolBar.add (saveJava);
		toolBar.addSeparator();
		toolBar.add (add);
		toolBar.add (up);
		toolBar.add (down);
		toolBar.addSeparator();
		toolBar.add (help);
			
	}
	
	public int CharToKey(char character) {
		int ret = 0;
        switch (Character.toLowerCase(character)) {
	        case 'a': ret = KeyEvent.VK_A; break;
	        case 'b': ret = KeyEvent.VK_B; break;
	        case 'c': ret = KeyEvent.VK_C; break;
	        case 'd': ret = KeyEvent.VK_D; break;
	        case 'e': ret = KeyEvent.VK_E; break;
	        case 'f': ret = KeyEvent.VK_F; break;
	        case 'g': ret = KeyEvent.VK_G; break;
	        case 'h': ret = KeyEvent.VK_H; break;
	        case 'i': ret = KeyEvent.VK_I; break;
	        case 'j': ret = KeyEvent.VK_J; break;
	        case 'k': ret = KeyEvent.VK_K; break;
	        case 'l': ret = KeyEvent.VK_L; break;
	        case 'm': ret = KeyEvent.VK_M; break;
	        case 'n': ret = KeyEvent.VK_N; break;
	        case 'o': ret = KeyEvent.VK_O; break;
	        case 'p': ret = KeyEvent.VK_P; break;
	        case 'q': ret = KeyEvent.VK_Q; break;
	        case 'r': ret = KeyEvent.VK_R; break;
	        case 's': ret = KeyEvent.VK_S; break;
	        case 't': ret = KeyEvent.VK_T; break;
	        case 'u': ret = KeyEvent.VK_U; break;
	        case 'v': ret = KeyEvent.VK_V; break;
	        case 'w': ret = KeyEvent.VK_W; break;
	        case 'x': ret = KeyEvent.VK_X; break;
	        case 'y': ret = KeyEvent.VK_Y; break;
	        case 'z': ret = KeyEvent.VK_Z; break;
        }
        return ret;
	}
	
	public void load() {
		JFileChooser chooser = new JFileChooser(new File("."));
		chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
		if (chooser.showOpenDialog(comp)==JFileChooser.CANCEL_OPTION)
			return;
		File f = chooser.getSelectedFile();
		try {
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream(f));
			dataModel.load (ois);
			ois.close ();	
		} catch (IOException ioe) {
			System.err.println ("Feil på filhåndteringen.");
		}
	}
	
	public void save() {
		if (curFile != null) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(curFile));
				dataModel.save (oos);
				oos.close ();	
			} catch (IOException ioe) {
				System.err.println ("Feil på filhåndteringen.");
			}
		}else{
			saveAs();
		}
	}
	
	public void saveAs() {
		JFileChooser chooser = new JFileChooser(new File("."));
		chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
		if (chooser.showSaveDialog(comp)==JFileChooser.CANCEL_OPTION)
			return;
		File f = chooser.getSelectedFile();
		if (f.exists())
			if (JOptionPane.showConfirmDialog(comp, "Filen finnes, overskrive", "Bekreft", JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)
				return;
		curFile = f;
		try {
			ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(f));
			dataModel.save (oos);
			oos.close ();	
		} catch (IOException ioe) {
			System.err.println ("Feil på filhåndteringen.");
		}
		
	}

	public void saveCode() {
		JFileChooser chooser = new JFileChooser(new File("."));
		chooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
		if (chooser.showSaveDialog(comp)==JFileChooser.CANCEL_OPTION)
			return;
		File f = chooser.getSelectedFile();
		if (f.exists())
			if (JOptionPane.showConfirmDialog(comp, "Filen finnes, overskrive", "Bekreft", JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)
				return;
		try {
			BufferedWriter bw = new BufferedWriter (new FileWriter (f));
			String fn = f.getName().replaceAll("\\.[^.]*$", "");
			bw.write(	"import javax.swing.*;\r\n" + 
						"import java.awt.*;\r\n" + 
						"\r\n" + 
						"/**\r\n" + 
						" * Code generated from GridBagLayoutEditor v 0.1\r\n" + 
						" */\r\n" + 
						"public class " + fn + " extends JPanel {\r\n"
					);
			
			StringBuilder sb = new StringBuilder();
			Vector<BaseElement> elements = dataModel.getData(); 
			for (int i=0; i<elements.size(); i++) {
				bw.write(elements.get(i).createMe());
				bw.newLine();
				sb.append(elements.get(i).toCode());
			}
			bw.write("public " + fn + " () {\r\n" + 
					"    GridBagLayout layout = new GridBagLayout ();\r\n" + 
					"    GridBagConstraints gbc = new GridBagConstraints();\r\n" + 
					"    setLayout (layout);\r\n");
			bw.write(sb.toString());
			bw.write(	"}\r\n" +
						"}");
			bw.close();
		} catch (IOException ioe) {
			System.err.println ("Feil under skriving av rapporten.");
		}
	}
}

