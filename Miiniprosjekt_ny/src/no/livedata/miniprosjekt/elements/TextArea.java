package no.livedata.miniprosjekt.elements;

// Class to save textarea
public class TextArea extends BaseElement {
	private static final long serialVersionUID = 1L;
	
	// spesific values
	private int inRows = 0;
	private int inCols = 0;
	private int height = 0;
	private int width = 0;
	private boolean scroll = false;
	private boolean wrap = false;
	
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


	/**
	 * @return the scroll
	 */
	public boolean isScroll() {
		return scroll;
	}


	/**
	 * @param scroll the scroll to set
	 */
	public void setScroll(boolean scroll) {
		this.scroll = scroll;
	}


	/**
	 * @return the wrap
	 */
	public boolean isWrap() {
		return wrap;
	}


	/**
	 * @param wrap the wrap to set
	 */
	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}


	// converts element to code
	public String toCode() {
		return "";
	}

}
