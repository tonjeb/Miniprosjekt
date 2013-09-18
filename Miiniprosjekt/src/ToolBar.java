import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class ToolBar {
	
	
	public JMenuBar menuBar;
	public JToolBar toolBar;
	
	public ToolBar() {

		// FILE MENU
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction createNew = new AbstractAction (Main.messages.getString("new"),
														new ImageIcon (getClass().getResource("images/NEW.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				// addWindow();
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("newM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction open = new AbstractAction (Main.messages.getString("open"),
														new ImageIcon (getClass().getResource("images/OPENDOC.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				// addWindow();
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("openM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction save = new AbstractAction (Main.messages.getString("save"),
														new ImageIcon (getClass().getResource("images/SAVE.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				// addWindow();
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("saveM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction saveAs = new AbstractAction (Main.messages.getString("saveAs"),
														new ImageIcon (getClass().getResource("images/SAVE.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				// addWindow();
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("saveAsM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction saveJava = new AbstractAction (Main.messages.getString("saveJava"),
														new ImageIcon (getClass().getResource("images/SAVEJAVA.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				// addWindow();
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("saveJavaM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction exit = new AbstractAction (Main.messages.getString("exit")) {
			public void actionPerformed (ActionEvent ae) {
				System.exit (0);
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("exitM").toCharArray()[0]);
		
		// EDIT MENU
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction add = new AbstractAction (Main.messages.getString("add"),
													new ImageIcon (getClass().getResource("images/NEWROW.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("addM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction pref = new AbstractAction (Main.messages.getString("pref")) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("prefM").toCharArray()[0]);
		
		// HELP MENU
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction help = new AbstractAction (Main.messages.getString("help"),
													new ImageIcon (getClass().getResource("images/HELP.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("helpM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction about = new AbstractAction (Main.messages.getString("about")) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("aboutM").toCharArray()[0]);
		
		// TOOLBAR MENUS
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction up = new AbstractAction (Main.messages.getString("up"),
													new ImageIcon (getClass().getResource("images/MoveRowUp.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("upM").toCharArray()[0]);
		
		// AbstractAction contains information used in both the menu and in the toolbar
		// This one will create a new window
		AbstractAction down = new AbstractAction (Main.messages.getString("down"),
													new ImageIcon (getClass().getResource("images/MoveRowDown.gif"))) {
			public void actionPerformed (ActionEvent ae) {
				
			}
		};
		// Setting the mnemonic key used in menues
		createNew.putValue(AbstractAction.MNEMONIC_KEY, (int)Main.messages.getString("downM").toCharArray()[0]);

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
		// Accelerator keys enable advanced users to access meny items without navigating the menu
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
		
		JMenuItem prefItem = new JMenuItem (pref);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		prefItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("prefM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		// EDIT MENU
		JMenuItem helpItem = new JMenuItem (help);
		// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
		helpItem.setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("helpM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem aboutItem = new JMenuItem (pref);
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
		editMenu.add(prefItem);
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
		
}

