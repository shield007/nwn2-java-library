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
