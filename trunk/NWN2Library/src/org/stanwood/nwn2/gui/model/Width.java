package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the width of a scene
 */
public class Width extends DimensionInteger  {	
	
	private static final long serialVersionUID = -7992031735594779636L;
	
	public static final String SCREEN_WIDTH = "SCREEN_WIDTH";	

	/**
	 * Used to create a instance of the object and parse the width
	 * @param value The width of the scene or "SCREEN_WIDTH" to use the width of the screen
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public Width(String value) throws GUIParseException {
		this(value,new String[] {SCREEN_WIDTH});
	}

	protected Width(String value, String[] specialValues) throws GUIParseException {
		super(value,specialValues);
	}

	/**
	 * Used to get the scene width as a integer. If "SCREEN_WIDTH" was given as the width value,
	 * then the screenDimension parameter is used to get the width of the scenes and return that.
	 * @param screenDimension The dimensions of the screen
	 * @return The width of the scene
	 */
	public int getValue(Dimension screenDimension) {
		String value = getStringValue();
		if (value.equalsIgnoreCase(SCREEN_WIDTH)) {
			return screenDimension.width;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
}
