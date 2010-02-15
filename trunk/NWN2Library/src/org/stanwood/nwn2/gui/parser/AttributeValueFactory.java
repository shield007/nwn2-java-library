package org.stanwood.nwn2.gui.parser;

import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.ObjectHeight;
import org.stanwood.nwn2.gui.model.ObjectWidth;
import org.stanwood.nwn2.gui.model.ObjectX;
import org.stanwood.nwn2.gui.model.ObjectY;
import org.stanwood.nwn2.gui.model.Height;
import org.stanwood.nwn2.gui.model.Width;
import org.stanwood.nwn2.gui.model.SceneX;
import org.stanwood.nwn2.gui.model.SceneY;
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
		else if (type == SceneX.class ) {
			return new SceneX(value);
		}
		else if (type == SceneY.class ) {
			return new SceneY(value);
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
		throw new GUIParseException("Unkown attribute type '" + type.getName()+"'");
	}
}
