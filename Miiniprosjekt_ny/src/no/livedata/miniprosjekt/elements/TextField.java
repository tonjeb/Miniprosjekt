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

// Class to save textfields
public class TextField extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int inHeight = 0;
	private int inWidth = 0;
	
	// create textfield from another element
	public TextField (BaseElement element) {
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
	 * @return the height
	 */
	public int getInHeight() {
		return inHeight;
	}

	/**
	 * @param height the height to set
	 */
	public void setInHeight(int height) {
		this.inHeight = height;
	}

	/**
	 * @return the width
	 */
	public int getInWidth() {
		return inWidth;
	}

	/**
	 * @param width the width to set
	 */
	public void setInWidth(int width) {
		this.inWidth = width;
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
		if (getInWidth() != 0 && getInHeight() != 0)
			sb.append(getName() + ".setPreferredSize (new java.awt.Dimension (" + getInWidth() + ", " + getInHeight() + "));\r\n");
		sb.append("layout.setConstraints ("); sb.append(getName()); sb.append(", gbc);\r\n");
		sb.append("add ("); sb.append(getName()); sb.append(");\r\n");
		
		return sb.toString();
	}
	
	public String createMe() {
		if (getInRows() == 0)
			return "JTextField " + getName() + " = new JTextField (\"" + getText() + "\");";
		else
			return "JTextField " + getName() + " = new JTextField (\"" + getText() + "\", " + getInRows() + ");";
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
			
			JPanel p = new JPanel();
			GridBagLayout layout = new GridBagLayout ();
		    //GridBagConstraints gbc = new GridBagConstraints();
		    p.setLayout (layout);
		    
		    p.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createTitledBorder("Properties"),
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		    GridBagConstraints gbc;
		    gbc = createGbc(0, 0);
		    p.add(new JLabel("Rows", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 0);
		    final JSpinner fInRows = new JSpinner(numMod1);
		    fInRows.setValue(getInRows());
		    p.add(fInRows,gbc);
		    
		    gbc = createGbc(0, 1);
		    p.add(new JLabel("Height", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 1);
		    final JSpinner fHeight = new JSpinner(numMod2);
		    fHeight.setValue(getInHeight());
		    p.add(fHeight,gbc);
		    
		    gbc = createGbc(0, 2);
		    p.add(new JLabel("Width", JLabel.LEFT), gbc);
		    gbc = createGbc(1, 2);
		    final JSpinner fWidth = new JSpinner(numMod3);
		    fWidth.setValue(getInWidth());
		    p.add(fWidth,gbc);
		    
		    gbc = createGbc(0, 3);
		    JButton save = new JButton("Save");
		    save.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	setInRows((Integer)fInRows.getValue());
	            	setInHeight((Integer)fHeight.getValue());
	            	setInWidth((Integer)fWidth.getValue());
	            	Prop.this.dispose();
	            }
	        });
		    p.add(save,gbc);
		    gbc = createGbc(1, 3);
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
