package no.livedata.miniprosjekt.elements;

/**
 * Button class
 * for saving button elements
 * 
 */
public class Button extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create button from another element
	 * @param element
	 */
	public Button (BaseElement element) {
		super (element); // sends element to superclass
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
		return "JButton " + getName() + " = new JButton (\"" + getText() + "\");";
	}

}
