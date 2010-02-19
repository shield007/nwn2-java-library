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
 * Used to store the X position of a scene
 */
public class XPosition extends DimensionInteger {	

	private static final long serialVersionUID = -1399324498834959044L;
	
	public static final String  ALIGN_CENTER = "ALIGN_CENTER";
	public static final String ALIGN_LEFT = "ALIGN_LEFT";
	public static final String ALIGN_RIGHT = "ALIGN_RIGHT";

	/**
	 * Used to create a instance of the object and parse the X position
	 * @param value The X position of the screen
	 */
	public XPosition(int value,NWN2GUIObject obj) {
		super(value);		
	}
	
	/**
	 * Used to create a instance of the object and parse the X position
	 * @param value The X position of the screen or "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" to align to the dimensions of the screen
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public XPosition(String value,NWN2GUIObject obj) throws GUIParseException {
		this(value,new String[] {ALIGN_CENTER,ALIGN_LEFT,ALIGN_RIGHT},obj);				
	}
	
	protected XPosition(String value, String[] allowedSpecialValues,NWN2GUIObject obj) throws GUIParseException {
		super(value,allowedSpecialValues);		
	}

	/**
	 * Used to get the scene X position as a integer. If "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" 
	 * was given as the X position value, then the screenDimension parameter is used to get 
	 * the X position of the scene and return that.
	 * @param screenDimension The dimensions of the screen
	 * @return The X position of the scene
	 */
	public int getValue(Dimension screenDimension,UIScene scene) {
		String value = getStringValue();
		int sceneWidth = scene.getWidth().getValue(screenDimension);
		if (value.equalsIgnoreCase(ALIGN_CENTER)) {
			return (screenDimension.width / 2) - (sceneWidth / 2);
		}
		else if (value.equalsIgnoreCase(ALIGN_LEFT)) {
			return 0;
		}
		else if (value.equalsIgnoreCase(ALIGN_RIGHT)) {
			return screenDimension.width - sceneWidth;
		}
		else {
			int i = Integer.parseInt(value);
//			if (obj.getParent()!=null) {
//				if (obj.getParent().getX()!=null) {					
//					return obj.getParent().getX().getValue(screenDimension, scene) + i;
//				}
//			}
			return i;			
		}
	}
	
}
