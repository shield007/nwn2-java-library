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
	
	@Override
	public Height getHeight() {
		return null;
	}
	
	@Override
	public Width getWidth() {
		return null;
	}

	
}
