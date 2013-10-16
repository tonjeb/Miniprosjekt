package no.livedata.miniprosjekt.elements;

// Class to save labels
public class Label extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// create label from another element
	public Label (BaseElement element) {
		super (element);
	}
	
	public Label (int num) {
		setName("new"+num);
	}
	
	// converts element to code
	public String toCode() {
		return "";
	}

}
