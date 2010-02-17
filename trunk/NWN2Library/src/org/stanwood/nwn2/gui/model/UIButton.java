package org.stanwood.nwn2.gui.model;

import org.stanwood.nwn2.gui.parser.GUIParseException;

public class UIButton extends UIObject {

	private static final long serialVersionUID = -3285622105853548564L;
	
	private String style;
	private String buttonType;
	private String mouseUpSFX;
	private String mouseDropSFX;
	private String mouseDragSFX;	
	private String disabledColor;
	private Integer groupMemberId;
	private Integer groupId;
	
	public UIButton(NWN2GUIObject parent) throws GUIParseException {
		super(parent);
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getMouseUpSFX() {
		return mouseUpSFX;
	}

	public void setMouseUpSFX(String mouseUpSFX) {
		this.mouseUpSFX = mouseUpSFX;
	}

	public String getMouseDropSFX() {
		return mouseDropSFX;
	}

	public void setMouseDropSFX(String mouseDropSFX) {
		this.mouseDropSFX = mouseDropSFX;
	}

	public String getMouseDragSFX() {
		return mouseDragSFX;
	}

	public void setMouseDragSFX(String mouseDragSFX) {
		this.mouseDragSFX = mouseDragSFX;
	}

	public String getDisabledColor() {
		return disabledColor;
	}

	public void setDisabledColor(String disabledColor) {
		this.disabledColor = disabledColor;
	}

	public Integer getGroupMemberId() {
		return groupMemberId;
	}

	public void setGroupMemberId(Integer groupMemberId) {
		this.groupMemberId = groupMemberId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}	

	
}
