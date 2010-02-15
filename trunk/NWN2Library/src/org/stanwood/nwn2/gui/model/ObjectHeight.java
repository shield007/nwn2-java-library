package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the height of a {@link UIObject}
 */
public class ObjectHeight extends Height {
		
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
		this.obj = obj;
	}

	/**
	 * Used to get the object height as a integer. If "SCREEN_HEIGHT" was given as the height value,
	 * then the screenDimension parameter is used to get the height of the scenes and return that.
	 * If "PARENT_HEIGHT" was given as the height value, then the parent object's height will be used.
	 * @param screenDimension The dimensions of the screen
	 * @return The height of the scene
	 */
	public int getValue(Dimension screenDimension) {
		String value = getStringValue();
		if (value.equalsIgnoreCase(PARENT_HEIGHT)) {		
			NWN2GUIObject parent = obj.getParent();
			if (parent instanceof UIScene) {
				return ((UIScene)parent).getHeight().getValue(screenDimension);
			}
			else {
				return ((UIObject)parent).getHeight().getValue(screenDimension);
			}			
		}
		else {
			return super.getValue(screenDimension);
		}
	}	
}
