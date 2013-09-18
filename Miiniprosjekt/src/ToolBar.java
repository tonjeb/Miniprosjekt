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
	
	super ();
	// AbstractAction contains information used in both the menu and in the toolbar
	// This one will create a new window
	AbstractAction newWindow = new AbstractAction ("Add window") {
		public void actionPerformed (ActionEvent ae) {
			// addWindow();
		}
	};
	// Setting the mnemonic key used in menues
			newWindow.putValue(AbstractAction.MNEMONIC_KEY, (int)'A');
			// Same thing for the about item
			AbstractAction about = new AbstractAction ("About") {
				public void actionPerformed (ActionEvent ae) {
					// JOptionPane.showMessageDialog (ToolBar.this, "A great example of a MDI application", "About", JOptionPane.PLAIN_MESSAGE);
				}
			};
			about.putValue(AbstractAction.MNEMONIC_KEY, (int)'A');
			// And for the exit option
			AbstractAction exit = new AbstractAction ("Exit") {
				public void actionPerformed (ActionEvent ae) {
					System.exit (0);
				}
			};
			exit.putValue(AbstractAction.MNEMONIC_KEY, (int)'X');
			
			
			
				
			
			// Create a new menu bar
			menuBar = new JMenuBar ();
			JMenu fileMenu = new JMenu ("File");
			fileMenu.setMnemonic ('F');
			JMenu windowMenu = new JMenu ("Windows");
			windowMenu.setMnemonic ('W');
			JMenu helpMenu = new JMenu ("Help");
			helpMenu.setMnemonic ('H');
			



			// Adding the abstract action objects as menu items
			JMenuItem addWindowItem = new JMenuItem (newWindow);
			// Accelerator keys enable advanced users to access meny items without navigating the menu
			addWindowItem.setAccelerator (KeyStroke.getKeyStroke ('N', InputEvent.CTRL_DOWN_MASK));
			JMenuItem aboutItem = new JMenuItem (about);
			// The KeyEvent object defines all possible keystrokes, handy for function keys
			aboutItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_F1, 0));
			JMenuItem exitItem = new JMenuItem (exit);
			// Alt+F4 is close window on windows, but not on other OS's, probably shouldn't do this
			exitItem.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
			fileMenu.add (exitItem);
			addWindowItem.setIcon (null);
			windowMenu.add (addWindowItem);
			aboutItem.setIcon (null);
			helpMenu.add (aboutItem);
			menuBar.add (fileMenu);
			menuBar.add (windowMenu);
			// Adding some glue, this puts the remaining menu items to the right
			menuBar.add (Box.createHorizontalGlue());
			menuBar.add (helpMenu);


			
			toolBar = new JToolBar ();
			toolBar.add (newWindow);
			// Same thing with the glue in a toolbar, puts the help/about item to the right
			toolBar.add (Box.createHorizontalGlue());
			toolBar.add (about);
			toolBar.addSeparator();
			
		}
		
	}

