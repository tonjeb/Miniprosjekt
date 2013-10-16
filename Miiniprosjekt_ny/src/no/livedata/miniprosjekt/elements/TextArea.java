package no.livedata.miniprosjekt.elements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import no.livedata.miniprosjekt.GUI.Main;
import no.livedata.miniprosjekt.elements.TextField.Prop;

/**
 * TextArea class
 * for saving text area elements
 * 
 */
public class TextArea extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int inCols = 0;
	private int inHeight = 0;
	private int inWidth = 0;
	private boolean inScroll = false;
	private boolean inWrap = false;
	
	/**
	 * Create textarea from another element
	 * @param element
	 */
	public TextArea (BaseElement element) {
		super (element);
	}
	
	/**
	 * Get inRows
	 * @return the inRows
	 */
	public int getInRows() {
		return inRows;
	}


	/**
	 * Set inRows
	 * @param inRows the inRows to set
	 */
	public void setInRows(int inRows) {
		this.inRows = inRows;
	}


	/**
	 * Get cols
	 * @return the inCols
	 */
	public int getInCols() {
		return inCols;
	}


	/**
	 * Set cols
	 * @param inCols the inCols to set
	 */
	public void setInCols(int inCols) {
		this.inCols = inCols;
	}


	/**
	 * Get height
	 * @return the inHeight
	 */
	public int getInHeight() {
		return inHeight;
	}


	/**
	 * Set height
	 * @param inHeight the inHeight to set
	 */
	public void setInHeight(int height) {
		this.inHeight = height;
	}


	/**
	 * Get width
	 * @return the inWidth
	 */
	public int getInWidth() {
		return inWidth;
	}


	/**
	 * Set width
	 * @param width the inWidth to set
	 */
	public void setInWidth(int width) {
		this.inWidth = width;
	}


	/**
	 * If it is scrollable
	 * @return the inScroll
	 */
	public boolean isScroll() {
		return inScroll;
	}


	/**
	 * Set scrollable
	 * @param scroll the inScroll to set
	 */
	public void setInScroll(boolean scroll) {
		this.inScroll = scroll;
	}


	/**
	 * If it should wrap text
	 * @return the inWrap
	 */
	public boolean isWrap() {
		return inWrap;
	}


	/**
	 * Get wrap
	 * @param wrap the inWrap to set
	 */
	public void setInWrap(boolean wrap) {
		this.inWrap = wrap;
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
		sb.append("gbc.anchor = java.awt.GridBagConstraints."); sb.append(getAnchor()); sb.append(";\r\n");
		sb.append("gbc.fill = java.awt.GridBagConstraints."); sb.append(getFill()); sb.append(";\r\n");
		String sName = getName(); // temp variable for storing scrollname
		if (isScroll()) { // add scroll if set
			sName = getName() + "ScrollPane";
			sb.append("JScrollPane " + sName + " = new JScrollPane (" + getName() + ");\r\n");
		}
		if (getInWidth() != 0 && getInHeight() != 0) // add width/height if both set
			sb.append(sName + ".setPreferredSize (new java.awt.Dimension (" + getInWidth() + ", " + getInHeight() + "));\r\n");
		sb.append("layout.setConstraints ("); sb.append(sName); sb.append(", gbc);\r\n");
		sb.append("add ("); sb.append(sName); sb.append(");\r\n");
		if (isWrap()) { // add wrap if set
			sb.append(getName() + ".setLineWrap (true);\r\n");
			sb.append(getName() + ".setWrapStyleWord (true);\r\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Create me
	 * creates header for element
	 * 
	 * @return string with header
	 */
	public String createMe() {
		if (getInRows() == 0 || getInCols() == 0) // if header should contains rows/cols
			return "JTextArea " + getName() + " = new JTextArea (\"" + getText() + "\");";
		else
			return "JTextArea " + getName() + " = new JTextArea (\"" + getText() + "\", " + getInRows() + ", " + getInCols() + ");";
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
			SpinnerModel numMod4 = new SpinnerNumberModel(0,0,1000,1);
			
			// create new pane
			JPanel p = new JPanel();
			GridBagLayout layout = new GridBagLayout ();
		    p.setLayout (layout);
		    // add border
		    p.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createTitledBorder(Main.messages.getString("prop")),
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		    GridBagConstraints gbc;
		    
		    // columns
		    gbc = createGbc(0, 0);
		    p.add(new JLabel(Main.messages.getString("columns"), JLabel.LEFT), gbc); // add label
		    gbc = createGbc(1, 0);
		    final JSpinner fCols = new JSpinner(numMod1); // create spinner
		    fCols.setValue(getInCols()); // set current value
		    p.add(fCols,gbc); // add spinner
		    
		    // rows
		    gbc = createGbc(0, 1);
		    p.add(new JLabel(Main.messages.getString("rows"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 1);
		    final JSpinner fRows = new JSpinner(numMod2);
		    fRows.setValue(getInRows());
		    p.add(fRows,gbc);
		    
		    // height
		    gbc = createGbc(0, 2);
		    p.add(new JLabel(Main.messages.getString("height"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 2);
		    final JSpinner fHeight = new JSpinner(numMod3);
		    fHeight.setValue(getInHeight());
		    p.add(fHeight,gbc);
		    
		    // width
		    gbc = createGbc(0, 3);
		    p.add(new JLabel(Main.messages.getString("width"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 3);
		    final JSpinner fWidth = new JSpinner(numMod4);
		    fWidth.setValue(getInWidth());
		    p.add(fWidth,gbc);
		    
		    // scroll
		    gbc = createGbc(0, 4);
		    p.add(new JLabel(Main.messages.getString("scroll"), JLabel.LEFT), gbc); // add label
		    gbc = createGbc(1, 4);
		    final JCheckBox fScroll = new JCheckBox(); // create checkbox
		    fScroll.setSelected(isScroll()); // set current value
		    p.add(fScroll,gbc); // add checkbox
		    
		    // wrap
		    gbc = createGbc(0, 5);
		    p.add(new JLabel(Main.messages.getString("wrap"), JLabel.LEFT), gbc);
		    gbc = createGbc(1, 5);
		    final JCheckBox fWrap = new JCheckBox();
		    fWrap.setSelected(isWrap());
		    p.add(fWrap,gbc);
		    
		    // buttons
		    gbc = createGbc(0, 6);
		    JButton save = new JButton(Main.messages.getString("csave")); // save
		    save.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	// save all values
	            	setInCols((Integer)fCols.getValue());
	            	setInRows((Integer)fRows.getValue());
	            	setInHeight((Integer)fHeight.getValue());
	            	setInWidth((Integer)fWidth.getValue());
	            	setInScroll((boolean)fScroll.isSelected());
	            	setInWrap((boolean)fWrap.isSelected());
	            	Prop.this.dispose(); // close frame
	            }
	        });
		    p.add(save,gbc);
		    gbc = createGbc(1, 6);
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
