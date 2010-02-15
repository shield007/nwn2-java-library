package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the Y position of a scene
 */
public class SceneY extends DimensionInteger {	
	
	private static final String  ALIGN_CENTER = "ALIGN_CENTER";
	private static final String ALIGN_LEFT = "ALIGN_LEFT";
	private static final String ALIGN_RIGHT = "ALIGN_RIGHT";	

	/**
	 * Used to create a instance of the object and parse the Y position
	 * @param value The Y position of the screen
	 */
	public SceneY(int value) {
		super(value);
	}
	
	/**
	 * Used to create a instance of the object and parse the Y position
	 * @param value The Y position of the screen or "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" to align to the dimensions of the screen
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public SceneY(String value) throws GUIParseException {
		super(value,new String[] {ALIGN_CENTER,ALIGN_LEFT,ALIGN_RIGHT});				
	}

	/**
	 * Used to get the scene Y position as a integer. If "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" 
	 * was given as the Y position value, then the screenDimension parameter is used to get 
	 * the Y position of the scene and return that.
	 * @param screenDimension The dimensions of the screen
	 * @return The Y position of the scene
	 */
	public int getValue(Dimension screenDimension,UIScene scene) {
		String value = getStringValue();
		int sceneHeight = scene.getHeight().getValue(screenDimension);
		if (value.equalsIgnoreCase(ALIGN_CENTER)) {
			return (screenDimension.height / 2) - (sceneHeight / 2);
		}
		else if (value.equalsIgnoreCase(ALIGN_LEFT)) {
			return 0;
		}
		else if (value.equalsIgnoreCase(ALIGN_RIGHT)) {
			return screenDimension.height - sceneHeight;
		}
		else {
			return Integer.parseInt(value);
		}
	}
	
}
