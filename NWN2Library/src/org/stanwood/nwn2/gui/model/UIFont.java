package org.stanwood.nwn2.gui.model;

public class UIFont extends NWN2GUIObject {

	private static final long serialVersionUID = 5783362793644855647L;
	
	private String font;
	private Integer pointSize;
	private Boolean dropShadows;
	private Boolean outline;
	
	public UIFont(NWN2GUIObject parent) {
		super(parent);
	}

	@Override
	public XPosition getX() {
		return null;
	}

	@Override
	public YPosition getY() {
		return null;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public Integer getPointSize() {
		return pointSize;
	}

	public void setPointSize(Integer pointSize) {
		this.pointSize = pointSize;
	}

	public Boolean getDropShadows() {
		return dropShadows;
	}

	public void setDropShadows(Boolean dropShadows) {
		this.dropShadows = dropShadows;
	}

	public Boolean getOutline() {
		return outline;
	}

	public void setOutline(Boolean outline) {
		this.outline = outline;
	}

	
}
