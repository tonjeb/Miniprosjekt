package no.livedata.miniprosjekt.elements;

// Class to save buttons
public class Button extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	
	// create button from another element
	public Button (BaseElement element) {
		super (element);
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
		sb.append("layout.setConstraints ("); sb.append(getName()); sb.append(", gbc);\r\n");
		sb.append("add ("); sb.append(getName()); sb.append(");\r\n");
		
		return sb.toString();
	}
	
	public String createMe() {
		return "JButton " + getName() + " = new JButton (\"" + getText() + "\");";
	}

}
