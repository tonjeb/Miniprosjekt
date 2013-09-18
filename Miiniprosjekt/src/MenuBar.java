import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ola
 *
 */
public class MenuBar extends JMenuBar {
	public MenuBar () {
		// Create the file menu
		JMenu fileMenu = new JMenu ("File");
		fileMenu.setMnemonic ('F');
		
		// Create the about menu item
		JMenuItem aboutItem = new JMenuItem ("About...");
		aboutItem.setMnemonic ('A');
		fileMenu.add (aboutItem);
		// Handle the action from the about menu item
		aboutItem.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				JOptionPane.showMessageDialog (MenuBar.this, "Et eksempel på\nbruk av menyer", "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// Create the exit menu item
		JMenuItem exitItem = new JMenuItem ("Exit");
		exitItem.setMnemonic ('X');
		// Add a separator in the file menu
		fileMenu.addSeparator ();
		fileMenu.add (exitItem);
		// Handle the Exit menu item
		exitItem.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae) {
				System.exit (0);
			}
		});
		
		add (fileMenu);
	}
}
