package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the height of a scene
 */
public class Height extends DimensionInteger {	

	private static final long serialVersionUID = 1237094455723208351L;
	
	public static final String SCREEN_HEIGHT = "SCREEN_HEIGHT";

	/**
	 * Used to create a instance of the object and parse the height
	 * @param value The height of the scene or "SCREEN_HEIGHT" to use the height of the screen
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public Height(String value) throws GUIParseException {
		this(value,new String[] {SCREEN_HEIGHT});				
	}
	
	protected Height(String value, String[] specialValues) throws GUIParseException {
		super(value,specialValues);
	}

	/**
	 * Used to get the scene height as a integer. If "SCREEN_HEIGHT" was given as the height value,
	 * then the screenDimension parameter is used to get the height of the scene and return that.
	 * @param screenDimension The dimensions of the screen
	 * @return The height of the scene
	 */
	public int getValue(Dimension screenDimension) {
		String value = getStringValue();
		if (value.equalsIgnoreCase(SCREEN_HEIGHT)) {
			return screenDimension.height;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
}
