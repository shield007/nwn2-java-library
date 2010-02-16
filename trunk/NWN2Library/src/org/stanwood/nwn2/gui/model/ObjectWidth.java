package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the width of a {@link UIObject}
 */
public class ObjectWidth extends Width {
		
	private static final long serialVersionUID = -3199258510744880190L;
	
	public static final String PARENT_WIDTH = "PARENT_WIDTH";	
	private NWN2GUIObject obj;
	

	/**
	 * Used to create a instance of the object and parse the width
	 * @param value The width of the object, "SCREEN_WIDTH" to use the width of the screen,"PARENT_WIDTH"
	 * to use the width of the parent object
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public ObjectWidth(String value,UIObject obj) throws GUIParseException {
		super(value,new String[] {SCREEN_WIDTH,PARENT_WIDTH});
		this.obj = obj;
	}

	/**
	 * Used to get the object width as a integer. If "SCREEN_WIDTH" was given as the width value,
	 * then the screenDimension parameter is used to get the width of the scenes and return that.
	 * If "PARENT_WIDTH" was given as the width value, then the parent object's width will be used.
	 * @param screenDimension The dimensions of the screen
	 * @return The width of the scene
	 */
	public int getValue(Dimension screenDimension) {
		String value = getStringValue();
		if (value.equalsIgnoreCase(PARENT_WIDTH)) {		
			NWN2GUIObject parent = obj.getParent();
			if (parent instanceof UIScene) {
				return ((UIScene)parent).getWidth().getValue(screenDimension);
			}
			else {
				return ((UIObject)parent).getWidth().getValue(screenDimension);
			}			
		}
		else {
			return super.getValue(screenDimension);
		}
	}	
}
