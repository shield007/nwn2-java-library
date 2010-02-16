package org.stanwood.nwn2.gui.model;

import java.awt.Dimension;

import org.stanwood.nwn2.gui.parser.GUIParseException;

/**
 * Used to store the X position of a object
 */
public class ObjectX extends XPosition {	
	
	private static final long serialVersionUID = -8644730274117399390L;
	
	public static final String ALIGN_PARENT = "ALIGN_PARENT";
	private UIObject obj;
	

	/**
	 * Used to create a instance of the object and parse the X position
	 * @param value The X position of the screen
	 */
	public ObjectX(int value,UIObject obj) {
		super(value);
		this.obj = obj;
	}
	
	/**
	 * Used to create a instance of the object and parse the X position
	 * @param value The X position of the screen or "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" to align to the dimensions of the screen.
	 * "ALIGN_PARENT" to centre the object within the parent object 
	 * @throws GUIParseException Thrown if their is a problem parsing the value
	 */
	public ObjectX(String value,UIObject obj) throws GUIParseException {
		super(value,new String[] {ALIGN_PARENT,ALIGN_CENTER,ALIGN_LEFT,ALIGN_RIGHT});		
		this.obj = obj;
	}

	/**
	 * Used to get the object X position as a integer. If "ALIGN_CENTER","ALIGN_LEFT","ALIGN_RIGHT" 
	 * was given as the X position value, then the screenDimension parameter is used to get 
	 * the X position of the object and return that. If "ALIGN_PARENT" is used, then it's centred
	 * within the parent object.
	 * @param screenDimension The dimensions of the screen
	 * @return The X position of the object
	 */
	@Override
	public int getValue(Dimension screenDimension,UIScene scene) {
		String value = getStringValue();		
		if (value.equalsIgnoreCase(ALIGN_PARENT)) {
			int parentWidth = 0;
			if (obj.getParent() instanceof UIScene) {
				parentWidth = ((UIScene)obj.getParent()).getWidth().getValue(screenDimension);				
			}
			else {
				parentWidth = ((UIObject)obj.getParent()).getWidth().getValue(screenDimension);
			}
			return (parentWidth /2) - (obj.getWidth().getValue(screenDimension) /2) ;
		}
		else {
			return super.getValue(screenDimension,scene);
		}
	}
	
}
