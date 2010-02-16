package org.stanwood.nwn2.gui.model;

import java.util.ArrayList;
import java.util.List;

public class NWN2GUIObject {
	
	private List<NWN2GUIObject>children = new ArrayList<NWN2GUIObject>();
	private NWN2GUIObject parent;
	private String name;	
	
	public NWN2GUIObject(NWN2GUIObject parent) {
		this.parent = parent;
	}
	
	/**
	 * Used to get the name of the UIObject. This is used internally and
	 * will be necessary for scripting to interact with this object in the
	 * future.
	 * @return The name of the UIObject 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Used to set the name of the UIObject. This is used internally and
	 * will be necessary for scripting to interact with this object in the
	 * future.
	 * @param name The name of the UIObject 
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	public void addChildObject(NWN2GUIObject child) {
		children.add(child);
	}
	
	public List<NWN2GUIObject>getChildren() {
		return children;
	}

	public NWN2GUIObject getParent() {
		return parent;
	}
	
	@Override
	public String toString() {
		if (getName()!=null) {
			String c =  getClass().getName(); 
			return c.substring(c.lastIndexOf('.')+1)+":"+getName();
		}
		else {
			return super.toString();
		}
	}
}
