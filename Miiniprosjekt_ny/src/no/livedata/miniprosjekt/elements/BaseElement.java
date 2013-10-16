package no.livedata.miniprosjekt.elements;

import java.io.Serializable;

//Alle elementer bygger på dette
public class BaseElement implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String text;
	private int row;
	private int column;
	private int rows;
	private int columns;
	private String fill;
	private String anchor;
	
	/**
	 * 
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
	 * 
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * @return the fill
	 */
	public String getFill() {
		return fill;
	}

	/**
	 * @param fill the fill to set
	 */
	public void setFill(String fill) {
		this.fill = fill;
	}

	/**
	 * @return the anchor
	 */
	public String getAnchor() {
		return anchor;
	}

	/**
	 * @param anchor the anchor to set
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	public String toCode () {
		StringBuilder sb = new StringBuilder ();
		return sb.toString();
	}
	
	public String createMe () {
		StringBuilder sb = new StringBuilder ();
		return sb.toString();
	}

	public void showProp() {
		// empty if not implemented by subclass
	}
}
