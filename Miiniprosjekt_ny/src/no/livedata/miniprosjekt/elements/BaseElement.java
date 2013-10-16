package no.livedata.miniprosjekt.elements;

import java.io.Serializable;

/**
 * BaseElement
 * Basic element, for all commomn values
 */
public class BaseElement implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name; 	// elementname
	private String text; 	// elementtext
	private int row;		// on row
	private int column;		// on columns
	private int rows;		// spend over rows
	private int columns;	// spend over columns
	private String fill;	// fil type
	private String anchor;	// anchor
	
	/**
	 * Empty constructor for setting all values
	 */
	public BaseElement() {
		this.name = "";
		this.text = "";
		this.row = 1;
		this.column = 1;
		this.rows = 1;
		this.columns = 1;
		this.fill = "NONE";
		this.anchor = "CENTER";
	}
	
	/**
	 * Constructor for setting all values
	 * @param name
	 * @param text
	 * @param row
	 * @param column
	 * @param rows
	 * @param columns
	 * @param fill
	 * @param anchor
	 */
	public BaseElement(String name, String text, int row, int column, int rows,
			int columns, String fill, String anchor) {
		this.name = name;
		this.text = text;
		this.row = row;
		this.column = column;
		this.rows = rows;
		this.columns = columns;
		this.fill = fill;
		this.anchor = anchor;
	}
	
	/**
	 * Constructor for copying values from existing element
	 * @param element
	 */
	public BaseElement(BaseElement element) {
		this.name = element.name;
		this.text = element.text;
		this.row = element.row;
		this.column = element.column;
		this.rows = element.rows;
		this.columns = element.columns;
		this.fill = element.fill;
		this.anchor = element.anchor;
	}
	
	/**
	 * Get name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get text
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get row
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Set row
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Get column
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Set column
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * Get row
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Set row
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Get columns
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Set columns
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Get fill
	 * @return the fill
	 */
	public String getFill() {
		return fill;
	}

	/**
	 * Set fill
	 * @param fill the fill to set
	 */
	public void setFill(String fill) {
		this.fill = fill;
	}

	/**
	 * Get anchor
	 * @return the anchor
	 */
	public String getAnchor() {
		return anchor;
	}

	/**
	 * Set anchor
	 * @param anchor the anchor to set
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	/**
	 * To code
	 * to print out code for element
	 * should be implemented in subclass
	 * @return empty string
	 */
	public String toCode () {
		return "";
	}
	
	/**
	 * create me
	 * to print headers for element
	 * should be implemented by subclass
	 * @return empty sting
	 */
	public String createMe () {
		return "";
	}
	/**
	 * show prop
	 * function to show properties
	 * subclass implements this if it has properties
	 */
	public void showProp() {
		// empty if not implemented by subclass
	}
}
