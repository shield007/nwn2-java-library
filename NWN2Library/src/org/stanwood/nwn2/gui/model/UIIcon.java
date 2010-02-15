package org.stanwood.nwn2.gui.model;

public class UIIcon extends UIObject {

	private String img;
	
	public UIIcon(NWN2GUIObject parent) {
		super(parent);
	}

	/**
	 * Used to get the name of the image used in the icon
	 * @return the name of the image used in the icon
	 */
	public String getImg() {
		return img;
	}

	/**
	 * Used to set the name of the image used in the icon
	 * @param img the name of the image used in the icon
	 */
	public void setImg(String img) {
		this.img = img;
	}

	

	
}
