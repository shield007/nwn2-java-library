package org.stanwood.nwn2.gui.model;

import java.util.ArrayList;
import java.util.List;

public class NWN2GUIObject {
	
	private List<NWN2GUIObject>children = new ArrayList<NWN2GUIObject>();
	private NWN2GUIObject parent;
	
	public NWN2GUIObject(NWN2GUIObject parent) {
		this.parent = parent;
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
}
