package no.livedata.miniprosjekt.elements;


/**
 * Label class
 * for saving label elements
 * 
 */
public class Label extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create label from another element
	 * @param element
	 */
	public Label (BaseElement element) {
		super (element); // send element to superclass
	}
	
	/**
	 * Constructor
	 * Create empty label
	 * @param num elementnumber
	 */
	public Label (int num) {
		setName("new"+num); // sets name
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
		return "JLabel " + getName() + " = new JLabel (\"" + getText() + "\");";
	}

}
