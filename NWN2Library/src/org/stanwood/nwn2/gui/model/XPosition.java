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

	private NWN2GUIObject obj;	

	/**
	 * Used to create a instance of the object and parse the X position
	 * @param value The X position of the screen
	 */
	public XPosition(int value,NWN2GUIObject obj) {
		super(value);
		this.obj = obj;
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
		this.obj = obj;
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