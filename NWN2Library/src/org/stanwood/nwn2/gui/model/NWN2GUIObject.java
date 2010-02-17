package org.stanwood.nwn2.gui.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class NWN2GUIObject implements Cloneable,Serializable {

	private static final long serialVersionUID = 698866204835685927L;

	private final static Log log = LogFactory.getLog(NWN2GUIObject.class);
	
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
	
	 public Object clone() throws CloneNotSupportedException {
		 NWN2GUIObject obj = (NWN2GUIObject) super.clone();
		Object object = null;
		try {

			object = getDeepCloning(obj);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return object;
	}
	
	private Object getDeepCloning(Object obj) throws IOException,
			ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}

	public void setParent(NWN2GUIObject uiObject) {
		parent = uiObject;
	}
	
	public abstract XPosition getX();
	
	public abstract YPosition getY();
}
