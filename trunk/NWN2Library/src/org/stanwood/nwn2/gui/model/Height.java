/*
 *  Copyright (C) 2008  John-Paul.Stanford <dev@stanwood.org.uk>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
