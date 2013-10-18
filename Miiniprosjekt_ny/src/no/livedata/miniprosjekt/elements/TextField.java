package no.livedata.miniprosjekt.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import no.livedata.miniprosjekt.GUI.Main;

/**
 * TextField class
 * for saving text field elements
 * 
 */
public class TextField extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int inHeight = 0;
	private int inWidth = 0;
	
	/**
	 * Create textfield from another element
	 * @param element
	 */
	public TextField (BaseElement element) {
		super (element);
	}
	
	/**
	 * Get rows
	 * @return the inRows
	 */
	public int getInRows() {
		return inRows;
	}

	/**
	 * Set rows
	 * @param inRows the inRows to set
	 */
	public void setInRows(int inRows) {
		this.inRows = inRows;
	}

	/**
	 * Get height
	 * @return the height
	 */
	public int getInHeight() {
		return inHeight;
	}

	/**
	 * Set height
	 * @param height the height to set
	 */
	public void setInHeight(int height) {
		this.inHeight = height;
	}

	/**
	 * Get width
	 * @return the width
	 */
	public int getInWidth() {
		return inWidth;
	}

	/**
	 * Set width
	 * @param width the width to set
	 */
	public void setInWidth(int width) {
		this.inWidth = width;
	}
	
	/**
	 * To code
	 * Prints the elements code
	 * 
	 * @return a string with the code
	 */
	public String toCode() {
	    
		StringBuilder sb = new StringBuilder();
		sb.append("gbc.gridx = "); sb.append(getRow()); sb.append(";\r\n");
		sb.append("gbc.gridy = "); sb.append(getColumn()); sb.append(";\r\n");
		sb.append("gbc.gridwidth = "); sb.append(getRows()); sb.append(";\r\n");
		sb.append("gbc.gridheight = "); sb.append(getColumns()); sb.append(";\r\n");
		sb.append("gbc.anchor = java.awt.GridBagConstraints."); sb.append(getAnchorName()); sb.append(";\r\n");
		sb.append("gbc.fill = java.awt.GridBagConstraints."); sb.append(getFillName()); sb.append(";\r\n");
		if (getInWidth() != 0 && getInHeight() != 0) // if both width and height is set add them to the code
			sb.append(getName() + ".setPreferredSize (new java.awt.Dimension (" + getInWidth() + ", " + getInHeight() + "));\r\n");
		sb.append("layout.setConstraints ("); sb.append(getName()); sb.append(", gbc);\r\n");
		sb.append("add ("); sb.append(getName()); sb.append(");\r\n");
		
		return sb.toString();
	}
	
	/**
	 * Create me
	 * creates header for element
	 * 
	 * @return string with header
	 */
	public String createMe() {
		if (getInRows() == 0) // if rows is not set
			return "JTextField " + getName() + " = new JTextField (\"" + getText() + "\");";
		else // add rows if set
			return "JTextField " + getName() + " = new JTextField (\"" + getText() + "\", " + getInRows() + ");";
	}
	
	/**
	 * show properties frame
	 */
	public void showProp() {
		new Prop();
	}
	
	/**
	 * Class to show properties
	 *
	 */
	class Prop extends JFrame {
		/**
		 * Constructor
		 * creating the Frame
		 */
		public Prop () {
			super(Main.messages.getString("prop"));
			
			// numberspinner models
			SpinnerModel numMod1 = new SpinnerNumberModel(0,0,1000,1);
			SpinnerModel numMod2 = new SpinnerNumberModel(0,0,1000,1);
			SpinnerModel numMod3 = new SpinnerNumberModel(0,0,1000,1);
			
			// create new pane
			JPanel p = new JPanel();
			GridBagLayout layout = new GridBagLayout ();
		    p.setLayout (layout);
		    
		    // add border
		    p.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createTitledBorder(Main.messages.getString("prop")),
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		    GridBagConstraints gbc;
		    
		    // rows
		    gbc = createGbc(0, 0);
		    p.add(new JLabel(Main.messages.getString("rows"), JLabel.LEFT), gbc); // add label
		    gbc = createGbc(1, 0);
		    final JSpinner fInRows = new JSpinner(numMod1); // create spinner
		    fInRows.setValue(getInRows()); // set current value
		    p.add(fInRows,gbc); // add spinner
		    
		    // height
		    gbc = createGbc(0, 1);
		    p.add(new JLabel(Main.messages.getString("height"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 1);
		    final JSpinner fHeight = new JSpinner(numMod2);
		    fHeight.setValue(getInHeight());
		    p.add(fHeight,gbc);
		    
		    //  width
		    gbc = createGbc(0, 2);
		    p.add(new JLabel(Main.messages.getString("width"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 2);
		    final JSpinner fWidth = new JSpinner(numMod3);
		    fWidth.setValue(getInWidth());
		    p.add(fWidth,gbc);
		    
		    // buttons
		    gbc = createGbc(0, 3);
		    JButton save = new JButton(Main.messages.getString("csave")); // save
		    save.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	// save values
	            	setInRows((Integer)fInRows.getValue());
	            	setInHeight((Integer)fHeight.getValue());
	            	setInWidth((Integer)fWidth.getValue());
	            	Prop.this.dispose(); // close frame
	            }
	        });
		    p.add(save,gbc);
		    gbc = createGbc(1, 3);
		    JButton cancel = new JButton(Main.messages.getString("ccancel")); // cancel
		    cancel.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Prop.this.dispose(); // close frame
	            }
	        });
		    p.add(cancel,gbc);
		    
		    add(p); // add panel
			pack();
			setVisible(true);
		}
	}
	
	/**
	 * Creates grid bag contains by x and y
	 * @param x coordinate
	 * @param y coordinate
	 * @return gbc object
	 */
	 private GridBagConstraints createGbc(int x, int y) {
	      GridBagConstraints gbc = new GridBagConstraints();
	      // sets values based on input and defaults
	      gbc.gridx = x;
	      gbc.gridy = y;
	      gbc.gridwidth = 1;
	      gbc.gridheight = 1;
	      
	      // adds floating to labels(west) and inputs(east)
	      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
	      gbc.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;
	      
	      // add weight based on label or input
	      gbc.weightx = (x == 0) ? 0.1 : 1.0;
	      gbc.weighty = 1.0;
	      return gbc;
	   }

}
