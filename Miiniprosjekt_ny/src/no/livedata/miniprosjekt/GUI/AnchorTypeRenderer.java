package no.livedata.miniprosjekt.GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import no.livedata.miniprosjekt.elements.BaseElement;

/**
 * Class from weather example
 * by Øivind Kolloen
 *
 */
// Use a label as a starting point, must implement TableCellRenderer to be used as 
// a renderer of table cells
@SuppressWarnings("serial")
public class AnchorTypeRenderer extends JLabel implements TableCellRenderer {
	
	String imageBase = "../../../../";
	
  public AnchorTypeRenderer () {
    setOpaque(true); //MUST do this for background to show up.
    setHorizontalAlignment(CENTER); // Center the contents of the label
    setVerticalAlignment(CENTER);
  }

	// This is the method that is called to get the label to be drawn in the cell
	// Contains reference to the actual table, the value to be drawn, 
	// baseelement the element is selected and focused and the row and column of the element
  public Component getTableCellRendererComponent(
                          JTable table, Object value,
                          boolean isSelected, boolean hasFocus,
                          int row, int column) {
		// Setting the background of the label to the table background
		// depending on selection status
    if (isSelected) {
      setBackground (table.getSelectionBackground ());
    } else {
      setBackground (table.getBackground ());
    }
		// No text on the label, only an icon
    setText ("");
		// If value "", that means no anchor (shold never happen)
    if (((Integer)value).toString().equals(""))
      setIcon (null);
    else
			// Get image from the id
      setIcon (new ImageIcon (getClass().getResource(imageBase + "images/" + BaseElement.anchorsImg[(Integer)value])));
		// Return the label used to draw the table cell
    return this;
  }
}