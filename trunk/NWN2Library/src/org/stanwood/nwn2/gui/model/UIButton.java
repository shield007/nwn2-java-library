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
	private Integer strRef;
	private String text;
	
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

	public Integer getStrRef() {
		return strRef;
	}

	public void setStrRef(Integer strRef) {
		this.strRef = strRef;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	

	
}
