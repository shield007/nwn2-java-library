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
package org.stanwood.nwn2.gui.parser;

import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.ObjectHeight;
import org.stanwood.nwn2.gui.model.ObjectWidth;
import org.stanwood.nwn2.gui.model.ObjectX;
import org.stanwood.nwn2.gui.model.ObjectY;
import org.stanwood.nwn2.gui.model.Height;
import org.stanwood.nwn2.gui.model.Width;
import org.stanwood.nwn2.gui.model.XPosition;
import org.stanwood.nwn2.gui.model.YPosition;
import org.stanwood.nwn2.gui.model.UIObject;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * This class is used to get the value of a attribute that has been read from the GUI XML file. 
 */
public class AttributeValueFactory {

	/**
	 * This will return a parsed value of the given type
	 * @param value The value to parse
	 * @param type The type it should be
	 * @return The parsed value of the given type
	 * @throws GUIParseException Thrown if their is a problem parsing it.
	 */
	@NonNull
	public static Object getAttributeValue(NWN2GUIObject obj,String value, Class<?> type) throws GUIParseException {
		if (type == String.class){
			return value;
		}
		else if (type == Boolean.class) {
			return Boolean.parseBoolean(value);
		}
		else if (type == Integer.class ) {
			return Integer.parseInt(value);
		}
		else if (type == Float.class ) {
			return Float.parseFloat(value);
		}
		else if (type == Width.class ) {
			return new Width(value);
		}
		else if (type == Height.class ) {
			return new Height(value);
		}
		else if (type == XPosition.class ) {
			return new XPosition(value,obj);
		}
		else if (type == YPosition.class ) {
			return new YPosition(value,obj);
		}
		else if (type == ObjectWidth.class ) {
			if (!(obj instanceof UIObject)) {
				throw new GUIParseException(type.getName()+" can't be used with " + obj.getClass().getName());
			}
			return new ObjectWidth(value,(UIObject)obj);
		}
		else if (type == ObjectHeight.class ) {
			if (!(obj instanceof UIObject)) {
				throw new GUIParseException(type.getName()+" can't be used with " + obj.getClass().getName());
			}
			return new ObjectHeight(value,(UIObject)obj);
		}
		else if (type == ObjectX.class ) {
			if (!(obj instanceof UIObject)) {
				throw new GUIParseException(type.getName()+" can't be used with " + obj.getClass().getName());
			}
			return new ObjectX(value,(UIObject)obj);
		}
		else if (type == ObjectY.class ) {
			if (!(obj instanceof UIObject)) {
				throw new GUIParseException(type.getName()+" can't be used with " + obj.getClass().getName());
			}
			return new ObjectY(value,(UIObject)obj);
		}
		throw new GUIParseException("Unkown attribute type '" + type.getName()+"' for class '" + obj.getClass().getName()+"'");
	}
}
