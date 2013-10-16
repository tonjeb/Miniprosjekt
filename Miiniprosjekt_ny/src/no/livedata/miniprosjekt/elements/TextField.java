package no.livedata.miniprosjekt.elements;

// Class to save textfields
public class TextField extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int height = 0;
	private int width = 0;
	
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
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	// converts element to code
	public String toCode() {
		return "";
	}

}
