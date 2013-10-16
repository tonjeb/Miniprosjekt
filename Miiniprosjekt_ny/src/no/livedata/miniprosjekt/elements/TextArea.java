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

import no.livedata.miniprosjekt.elements.TextField.Prop;

// Class to save textarea
public class TextArea extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int inCols = 0;
	private int inHeight = 0;
	private int inWidth = 0;
	private boolean inScroll = false;
	private boolean inWrap = false;
	
	// create textarea from another element
	public TextArea (BaseElement element) {
		super (element);
	}
	
	/**
	 * @return the inRows
	 */
	public int getInRows() {
		return inRows;
	}


	/**
	 * @param inRows the inRows to set
	 */
	public void setInRows(int inRows) {
		this.inRows = inRows;
	}


	/**
	 * @return the inCols
	 */
	public int getInCols() {
		return inCols;
	}


	/**
	 * @param inCols the inCols to set
	 */
	public void setInCols(int inCols) {
		this.inCols = inCols;
	}


	/**
	 * @return the inHeight
	 */
	public int getInHeight() {
		return inHeight;
	}


	/**
	 * @param inHeight the inHeight to set
	 */
	public void setInHeight(int height) {
		this.inHeight = height;
	}


	/**
	 * @return the inWidth
	 */
	public int getInWidth() {
		return inWidth;
	}


	/**
	 * @param width the inWidth to set
	 */
	public void setInWidth(int width) {
		this.inWidth = width;
	}


	/**
	 * @return the inScroll
	 */
	public boolean isScroll() {
		return inScroll;
	}


	/**
	 * @param scroll the inScroll to set
	 */
	public void setInScroll(boolean scroll) {
		this.inScroll = scroll;
	}


	/**
	 * @return the inWrap
	 */
	public boolean isWrap() {
		return inWrap;
	}


	/**
	 * @param wrap the inWrap to set
	 */
	public void setInWrap(boolean wrap) {
		this.inWrap = wrap;
	}


	// converts element to code
	public String toCode() {
	    
		StringBuilder sb = new StringBuilder();
		sb.append("gbc.gridx = "); sb.append(getRow()); sb.append(";\r\n");
		sb.append("gbc.gridy = "); sb.append(getColumn()); sb.append(";\r\n");
		sb.append("gbc.gridwidth = "); sb.append(getRows()); sb.append(";\r\n");
		sb.append("gbc.gridheight = "); sb.append(getColumns()); sb.append(";\r\n");
		sb.append("gbc.anchor = java.awt.GridBagConstraints."); sb.append(getAnchor()); sb.append(";\r\n");
		sb.append("gbc.fill = java.awt.GridBagConstraints."); sb.append(getFill()); sb.append(";\r\n");
		String sName = getName();
		if (isScroll()) {
			sName = getName() + "ScrollPane";
			sb.append("JScrollPane " + sName + " = new JScrollPane (" + getName() + ");\r\n");
		}
		if (getInWidth() != 0 && getInHeight() != 0)
			sb.append(sName + ".setPreferredSize (new java.awt.Dimension (" + getInWidth() + ", " + getInHeight() + "));\r\n");
		sb.append("layout.setConstraints ("); sb.append(sName); sb.append(", gbc);\r\n");
		sb.append("add ("); sb.append(sName); sb.append(");\r\n");
		if (isWrap()) {
			sb.append(getName() + ".setLineWrap (true);\r\n");
			sb.append(getName() + ".setWrapStyleWord (true);\r\n");
		}
		
		return sb.toString();
	}
	
	public String createMe() {
		if (getInRows() == 0 || getInCols() == 0)
			return "JTextArea " + getName() + " = new JTextArea (\"" + getText() + "\");";
		else
			return "JTextArea " + getName() + " = new JTextArea (\"" + getText() + "\", " + getInRows() + ", " + getInCols() + ");";
	}
	
	public void showProp() {
		new Prop();
	}
	
	class Prop extends JFrame {
		public Prop () {
			super("Properties");
			
			SpinnerModel numMod1 = new SpinnerNumberModel(0,0,1000,1);
			SpinnerModel numMod2 = new SpinnerNumberModel(0,0,1000,1);
			SpinnerModel numMod3 = new SpinnerNumberModel(0,0,1000,1);
			SpinnerModel numMod4 = new SpinnerNumberModel(0,0,1000,1);
			
			JPanel p = new JPanel();
			GridBagLayout layout = new GridBagLayout ();
		    //GridBagConstraints gbc = new GridBagConstraints();
		    p.setLayout (layout);
		    
		    p.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createTitledBorder("Properties"),
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		    GridBagConstraints gbc;
		    gbc = createGbc(0, 0);
		    p.add(new JLabel("Columns", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 0);
		    final JSpinner fCols = new JSpinner(numMod1);
		    fCols.setValue(getInCols());
		    p.add(fCols,gbc);
		    
		    gbc = createGbc(0, 1);
		    p.add(new JLabel("Rows", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 1);
		    final JSpinner fRows = new JSpinner(numMod2);
		    fRows.setValue(getInRows());
		    p.add(fRows,gbc);
		    
		    gbc = createGbc(0, 2);
		    p.add(new JLabel("Height", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 2);
		    final JSpinner fHeight = new JSpinner(numMod3);
		    fHeight.setValue(getInHeight());
		    p.add(fHeight,gbc);
		    
		    gbc = createGbc(0, 3);
		    p.add(new JLabel("Width", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 3);
		    final JSpinner fWidth = new JSpinner(numMod4);
		    fWidth.setValue(getInWidth());
		    p.add(fWidth,gbc);
		    
		    gbc = createGbc(0, 4);
		    p.add(new JLabel("Scroll", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 4);
		    final JCheckBox fScroll = new JCheckBox();
		    fScroll.setSelected(isScroll());
		    p.add(fScroll,gbc);
		    
		    gbc = createGbc(0, 5);
		    p.add(new JLabel("Wrap", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 5);
		    final JCheckBox fWrap = new JCheckBox();
		    fWrap.setSelected(isWrap());
		    p.add(fWrap,gbc);
		    
		    gbc = createGbc(0, 6);
		    JButton save = new JButton("Save");
		    save.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	setInCols((Integer)fCols.getValue());
	            	setInRows((Integer)fRows.getValue());
	            	setInHeight((Integer)fHeight.getValue());
	            	setInWidth((Integer)fWidth.getValue());
	            	setInScroll((boolean)fScroll.isSelected());
	            	setInWrap((boolean)fWrap.isSelected());
	            	Prop.this.dispose();
	            }
	        });
		    p.add(save,gbc);
		    gbc = createGbc(1, 6);
		    JButton cancel = new JButton("Cancel");
		    cancel.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	Prop.this.dispose();
	            }
	        });
		    p.add(cancel,gbc);
		    
		    add(p);
			pack();
			setVisible(true);
		}
	}
	
	 private GridBagConstraints createGbc(int x, int y) {
	      GridBagConstraints gbc = new GridBagConstraints();
	      gbc.gridx = x;
	      gbc.gridy = y;
	      gbc.gridwidth = 1;
	      gbc.gridheight = 1;

	      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
	      gbc.fill = (x == 0) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;

	      gbc.weightx = (x == 0) ? 0.1 : 1.0;
	      gbc.weighty = 1.0;
	      return gbc;
	   }

}
