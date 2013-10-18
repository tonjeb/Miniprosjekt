package no.livedata.miniprosjekt.GUI;
import java.awt.*;
import javax.swing.*;

import no.livedata.miniprosjekt.elements.BaseElement;

/**
 * Class from Weather example
 * by Øivind Kolloen
 *
 */
// Using a label as a starting point, ListCellRenderer must be implementet to act
// as such
@SuppressWarnings("serial")
public class FillDropDownRenderer extends JLabel implements ListCellRenderer {
	// A baseelement item object, needed to convert between textual and nummeric representation
	// of the value
  BaseElement el = null;
  String imageBase = "../../../../";

  public FillDropDownRenderer () {
    setOpaque(true); //MUST do this for background to show up.
    setHorizontalAlignment(CENTER);	// The icon is to be centered in the label
    setVerticalAlignment(CENTER);
		// Just initialize the weatherItem object, will be changed as needed
    el = new BaseElement ();
  }

  // This method is called every time a cell in the drop down box is to be rendered
	// Receives a reference to the actual drop down box, the value to be rendered
	// the index in the table and baseelement the item is focused or not
	public Component getListCellRendererComponent(JList list, Object value,
                                                int index, boolean isSelected,
                                                boolean cellHasFocus) {
		// Set the background to the lists background depending on the selection status
    if (isSelected) {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());
    } else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

		// No text, just an image
    setText ("");
		// If unknown element type, then use no icon
    if (((String)value).equals(BaseElement.getFills()[0]))
      setIcon (null);
    else {
			// We only get the textual description so set that in the baseelement object
      el.setFill ((String)value);
			// Then we can get the number from the baseelement object
      setIcon (new ImageIcon (getClass().getResource(imageBase + "images/" + el.getFillImg())));
    }  
    return this;
  }
}