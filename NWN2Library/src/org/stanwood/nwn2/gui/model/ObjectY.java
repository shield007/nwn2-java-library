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
 * Used to store the Y position of a object
 */
public class ObjectY extends YPosition {	
		
	private static final long serialVersionUID = 3066895430215433086L;
	
	private static final String ALIGN_PARENT = "ALIGN_PARENT";
	private UIObject obj;
	
	/**
	 * Used to create a instance of the object and parse the Y position
	 * @param value The Y position of the screen
	 */
	public ObjectY(int value,UIObject obj) {
		super(value);
		setObject(obj);
	}

	void setObject(UIObject obj) {
		this.obj = obj;
	}
	
	/**
	 * Used to create a instance of the object and parse the Y position
	 * @param value The Y position of the screen or "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" to align to the dimensions of the screen
	 * "ALIGN_PARENT" to centre the object within the parent object 
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public ObjectY(String value,UIObject obj) throws GUIParseException {
		super(value,new String[] {ALIGN_PARENT,ALIGN_CENTER,ALIGN_TOP,ALIGN_BOTTOM},obj);		
		setObject(obj);
	}

	/**
	 * Used to get the object Y position as a integer. If "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" 
	 * was given as the Y position value, then the screenDimension parameter is used to get 
	 * the Y position of the object and return that. If "ALIGN_PARENT" is used, then it's centred
	 * within the parent object.
	 * @param screenDimension The dimensions of the screen
	 * @return The Y position of the object
	 */
	@Override
	public int getValue(Dimension screenDimension,UIScene scene) {
		String value = getStringValue();
		if (value.equalsIgnoreCase(ALIGN_PARENT)) {
			int parentHeight = 0;
			if (obj.getParent() instanceof UIScene) {
				parentHeight = ((UIScene)obj.getParent()).getHeight().getValue(screenDimension);				
			}
			else {
				parentHeight = ((UIObject)obj.getParent()).getHeight().getValue(screenDimension);
			}
			return (parentHeight /2) - (obj.getHeight().getValue(screenDimension) /2) ;
		}
		else {
			return super.getValue(screenDimension, scene);
		}
	}
	
}
