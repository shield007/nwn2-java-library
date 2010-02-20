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
 * Used to store the height of a {@link UIObject}
 */
public class ObjectHeight extends Height {
		
	private static final long serialVersionUID = 6853470584181383233L;
	
	public static final String PARENT_HEIGHT = "PARENT_HEIGHT";	
	private NWN2GUIObject obj;
	

	/**
	 * Used to create a instance of the object and parse the height
	 * @param value The height of the object, "SCREEN_HEIGHT" to use the height of the screen,"PARENT_HEIGHT"
	 * to use the height of the parent object
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public ObjectHeight(String value,UIObject obj) throws GUIParseException {
		super(value,new String[] {SCREEN_HEIGHT,PARENT_HEIGHT});
		setObject(obj);
	}

	void setObject(UIObject obj) {
		this.obj = obj;		
	}

	/**
	 * Used to get the object height as a integer. If "SCREEN_HEIGHT" was given as the height value,
	 * then the screenDimension parameter is used to get the height of the scenes and return that.
	 * If "PARENT_HEIGHT" was given as the height value, then the parent object's height will be used.
	 * @param screenDimension The dimensions of the screen
	 * @return The height of the scene
	 */
	@Override
	public int getValue(Dimension screenDimension) {
		String value = getStringValue();
//		System.out.println(obj.getName() + " : " + value);
		if (value.equalsIgnoreCase(PARENT_HEIGHT)) {		
			NWN2GUIObject parent = obj.getParent();						
			if (parent instanceof UIScene) {
				return ((UIScene)parent).getHeight().getValue(screenDimension);
			}
			else {
				if (parent==null) {
					System.out.println("Object has no parent: " + obj.getName() +" : " + obj.getClass());
					throw new RuntimeException("Object has no parent: " + obj.getName() +" : " + obj.getClass());					
				}				
				return ((UIObject)parent).getHeight().getValue(screenDimension);
			}			
		}
		else {
			return super.getValue(screenDimension);
		}
	}	
}
