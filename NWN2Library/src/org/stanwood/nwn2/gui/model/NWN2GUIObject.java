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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class NWN2GUIObject implements Cloneable,Serializable {

	private static final long serialVersionUID = 698866204835685927L;

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
		if (child.getParent()==null) {
			throw new RuntimeException("Child has no parent: " + child);
		}
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
	
	 @Override
	public Object clone() throws CloneNotSupportedException {
		NWN2GUIObject obj = (NWN2GUIObject) super.clone();
		obj.setParent(getParent());
		obj.newlyCloned();
		return obj;
	}

	public void setParent(NWN2GUIObject uiObject) {
		parent = uiObject;		
	}
	
	public abstract XPosition getX();
	
	public abstract YPosition getY();

	protected void newlyCloned() {
		for (NWN2GUIObject child : getChildren()) {
			child.newlyCloned();
		}
	}
}
