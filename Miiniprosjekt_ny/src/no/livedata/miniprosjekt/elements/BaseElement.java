package no.livedata.miniprosjekt.elements;


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
import java.io.Serializable;

import no.livedata.miniprosjekt.GUI.Main;

/**
 * BaseElement
 * Basic element, for all commomn values
 */
public class BaseElement implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name; 	// elementname
	private String text; 	// elementtext
	private int row;		// on row
	private int column;		// on columns
	private int rows;		// spend over rows
	private int columns;	// spend over columns
	private String fill;	// fil type
	private String anchor;	// anchor
	
	/**
	 * Empty constructor for setting all values
	 */
	public BaseElement() {
		this.name = "";
		this.text = "";
		this.row = 1;
		this.column = 1;
		this.rows = 1;
		this.columns = 1;
		this.fill = "NONE";
		this.anchor = "CENTER";
	}
	
	/**
	 * Constructor for setting all values
	 * @param name
	 * @param text
	 * @param row
	 * @param column
	 * @param rows
	 * @param columns
	 * @param fill
	 * @param anchor
	 */
	public BaseElement(String name, String text, int row, int column, int rows,
			int columns, String fill, String anchor) {
		this.name = name;
		this.text = text;
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
		this.fill = fill;
		this.anchor = anchor;
	}
	
	/**
	 * Constructor for copying values from existing element
	 * @param element
	 */
	public BaseElement(BaseElement element) {
		this.name = element.name;
		this.text = element.text;
		this.row = element.row;
		this.column = element.column;
		this.rows = element.rows;
		this.columns = element.columns;
		this.fill = element.fill;
		this.anchor = element.anchor;
	}
	
	/**
	 * Get name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get text
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get row
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Set row
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Get column
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Set column
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * Get row
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Set row
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Get columns
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Set columns
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Get fill
	 * @return the fill
	 */
	public String getFill() {
		return fill;
	}

	/**
	 * Set fill
	 * @param fill the fill to set
	 */
	public void setFill(String fill) {
		this.fill = fill;
	}

	/**
	 * Get anchor
	 * @return the anchor
	 */
	public String getAnchor() {
		return anchor;
	}

	/**
	 * Set anchor
	 * @param anchor the anchor to set
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	/**
	 * To code
	 * to print out code for element
	 * should be implemented in subclass
	 * @return empty string
	 */
	public String toCode () {
		return "";
	}
	
	/**
	 * create me
	 * to print headers for element
	 * should be implemented by subclass
	 * @return empty sting
	 */
	public String createMe () {
		return "";
	}
	/**
	 * show prop
	 * function to show properties
	 * subclass implements this if it has properties
	 */
	
	public void showProp() {
		// empty if not implemented by subclass
	}
	
	
	// FILL MENU
	
	// AbstractAction contains information used in both the menu and in the toolbar
	// VERTICAL
	AbstractAction verticalFill = new AbstractAction (Main.messages.getString("vertical")) {
		public void actionPerformed (ActionEvent ae) {
			gbc.fill = GridBagConstraints.VERTICAL;
		}
	};
	// Setting the mnemonic key used in menus
	//verticalFill.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("verticalM").toCharArray()[0]));
	
	
	// AbstractAction contains information used in both the menu and in the toolbar
	// HORIZONTAL
	AbstractAction horizontalFill = new AbstractAction (Main.messages.getString("horizontal")) {
		public void actionPerformed (ActionEvent ae) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		}
	};
	// Setting the mnemonic key used in menues
	//horizontalFill.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("horizontalM").toCharArray()[0]));
	
	
	// AbstractAction contains information used in both the menu and in the toolbar
	// BOTH
	AbstractAction bothFill = new AbstractAction (Main.messages.getString("both")) {
		public void actionPerformed (ActionEvent ae) {
			gbc.fill = GridBagConstraints.BOTH;
		}
	};
	// Setting the mnemonic key used in menues
	//bothFill.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("bothM").toCharArray()[0]));
	
	// ANCHOR MENU
	
			// AbstractAction contains information used in both the menu and in the toolbar
			// NORTH EAST
			AbstractAction northEast = new AbstractAction (Main.messages.getString("northEast")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.NORTHEAST;
				}
			};
			// Setting the mnemonic key used in menus
			//northEast.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("northEastM").toCharArray()[0]));
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// EAST
			AbstractAction east = new AbstractAction (Main.messages.getString("east")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.EAST;
				}
			};
			// Setting the mnemonic key used in menues
			//east.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("eastM").toCharArray()[0]));
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// NORTH
			AbstractAction north = new AbstractAction (Main.messages.getString("north")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.NORTH;
				}
			};
			// Setting the mnemonic key used in menues
//			north.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("northM").toCharArray()[0]));
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// WEST
			AbstractAction west = new AbstractAction (Main.messages.getString("west")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.WEST;
				}
			};
			// Setting the mnemonic key used in menues
//						west.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("westM").toCharArray()[0]));
						
						
						
			// AbstractAction contains information used in both the menu and in the toolbar
			// SOUTH
			AbstractAction south = new AbstractAction (Main.messages.getString("south")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.SOUTH;
				}
			};
			// Setting the mnemonic key used in menues
	//		south.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("southM").toCharArray()[0]));
			
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// NORTH WEST
			AbstractAction northWest = new AbstractAction (Main.messages.getString("northWest")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.NORTHWEST;
				}
			};
			// Setting the mnemonic key used in menues
//			northWest.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("northWestM").toCharArray()[0]));
			
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// SOUTH EAST
			AbstractAction southEast = new AbstractAction (Main.messages.getString("southEast")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.SOUTHEAST;
				}
			};
			// Setting the mnemonic key used in menues
	//		southEast.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("southEastM").toCharArray()[0]));
			
			
			
			// AbstractAction contains information used in both the menu and in the toolbar
			// SOUT WEST
			AbstractAction southWest = new AbstractAction (Main.messages.getString("southWest")) {
				public void actionPerformed (ActionEvent ae) {
					gbc.anchor = GridBagConstraints.SOUTHWEST;
				}
			};
			
					
			// Setting the mnemonic key used in menues
			//southWest.putValue(AbstractAction.MNEMONIC_KEY, CharToKey(Main.messages.getString("southWestM").toCharArray()[0]));
			
					
	
	
// Menu bar
	menuBar = new JMenuBar ();
	JMenu fillMenu = new JMenu (Main.messages.getString("fill"));
	fillMenu.setMnemonic (Main.messages.getString("fillM").toCharArray()[0]);
	JMenu anchorMenu = new JMenu (Main.messages.getString("anchor"));
	anchorMenu.setMnemonic (Main.messages.getString("anchorM").toCharArray()[0]);

// Anchor dropdown
		// Adding the abstract action objects as menu items
		JMenuItem NORTH_EAST_LITERAL = new JMenuItem (northEast);
		// Accelerator keys enable advanced users to access menu items without navigating the menu
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("northEastM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem EAST_LITERAL = new JMenuItem (east);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("eastM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem NORTH_LITERAL = new JMenuItem (north);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("northM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem WEST_LITERAL = new JMenuItem (west);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("westM").toCharArray()[0], InputEvent.SHIFT_DOWN_MASK));
		
		JMenuItem SOUTH_LITERAL = new JMenuItem (south);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("southM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem NORTH_WEST_LITERAL = new JMenuItem (northWest);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("northWestM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem SOUTH_EAST_LITERAL = new JMenuItem (southEast);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("southEastM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
		
		JMenuItem SOUTH_WEST_LITERAL = new JMenuItem (southWest);
		//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("southWestM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));

		
		// Fill dropdown
				// Adding the abstract action objects as menu items
				JMenuItem  = new JMenuItem (vertical);
				// Accelerator keys enable advanced users to access menu items without navigating the menu
				//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("verticalM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
				
				JMenuItem  = new JMenuItem (horizontal);
				//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("horizontalM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));
				
				JMenuItem  = new JMenuItem (both);
				//?? .setAccelerator (KeyStroke.getKeyStroke (Main.messages.getString("bothM").toCharArray()[0], InputEvent.CTRL_DOWN_MASK));

				

//add all menu items

		fillMenu.add (vertical);
		fillMenu.add (horizontal);
		fillMenu.add (both);
		//
		anchorMenu.add (northEast);
		anchorMenu.add (east);
		anchorMenu.add (north);
		anchorMenu.add (west);
		anchorMenu.add (south);
		anchorMenu.add (northWest);
		anchorMenu.add (southEast);
		anchorMenu.add (southWest);
		
		}

};




