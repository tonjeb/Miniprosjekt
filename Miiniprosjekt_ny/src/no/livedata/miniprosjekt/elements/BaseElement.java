package no.livedata.miniprosjekt.elements;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import no.livedata.miniprosjekt.elements.BaseElement;
import no.livedata.miniprosjekt.model.TabModel;
import java.io.Serializable;

import no.livedata.miniprosjekt.GUI.Main;

/**
 * BaseElement
 * Basic element, for all commomn values
 */
public class BaseElement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name; 	// elementname
	private String text; 	// elementtext
	private int row;		// on row
	private int column;		// on columns
	private int rows;		// spend over rows
	private int columns;	// spend over columns
	private int fill;	// fil type
	private int anchor;	// anchor
	
	// arrays with fill and anchor options and images
	private static String[] fills = { "NONE", "HORIZONTAL", "VERTICAL", "BOTH" };
	public static String[] fillsImg = { "skaler_ingen.png", "skaler_horisontalt.png", "skaler_vertikalt.png", "skaler_begge.png" };
	
	private static String[] anchors = { "CENTER", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST", "NORTHWEST"  };
	public static String[] anchorsImg = { "anchor_center_shifted.png", "anchor_north_shifted.png", "anchor_northeast_shifted.png", "anchor_east_shifted.png", "anchor_southeast_shifted.png", "anchor_south_shifted.png", "anchor_southwest.png", "anchor_west.png", "anchor_northwest.png" };
	
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
		this.fill = 0;
		this.anchor = 0;
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
			int columns, int fill, int anchor) {
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
	 * Get all fill options
	 * @return String[] with fill options
	 */
	public static String[] getFills () {
	  return fills;
	}
	
	/**
	 * Get fill image
	 * @return String path to image
	 */
	public String getFillImg () {
		return fillsImg[fill];
	}
	
	/**
	 * Get all anchor options
	 * @return String[] with anchor options
	 */
	public static String[] getAnchors () {
	  return anchors;
	}
	
	/**
	 * Get anchor image
	 * @return String path to image
	 */
	public String getAnchorImg () {
		return anchorsImg[anchor];
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
	public int getFill() {
		return fill;
	}
	
	/**
	 * Get fill name
	 * @return the fill name
	 */
	public String getFillName() {
		return fills[fill];
	}

	/**
	 * Set fill
	 * @param aValue the fill to set
	 */
	public void setFill(String value) {
		for (int i=0; i<fills.length; i++)
		      if (value.equals (fills[i])) {
		        this.fill = i;
		        return;
		      }
	}

	/**
	 * Get anchor
	 * @return the anchor
	 */
	public int getAnchor() {
		return anchor;
	}
	
	/**
	 * Get anchor name
	 * @return the anchor name
	 */
	public String getAnchorName() {
		return anchors[anchor];
	}

	/**
	 * Set anchor
	 * @param anchor the anchor to set
	 */
	public void setAnchor(String value) {
		for (int i=0; i<anchors.length; i++)
		      if (value.equals (anchors[i])) {
		        this.anchor = i;
		        return;
		      }
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




