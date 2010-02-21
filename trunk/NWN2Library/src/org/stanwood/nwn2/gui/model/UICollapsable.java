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


public class UICollapsable extends UIObject {

	private static final long serialVersionUID = 8286944259009793580L;
	
	private Integer indent;
	private Integer YPadding;
	private Integer XPadding;
	private Boolean collapseLock;
	private Boolean isExpanded;	
	
	public UICollapsable(NWN2GUIObject parent) {
		super(parent);		
	}

	public Integer getIndent() {
		return indent;
	}

	public void setIndent(Integer indent) {
		this.indent = indent;
	}

	public Integer getYPadding() {
		return YPadding;
	}

	public void setYPadding(Integer yPadding) {
		YPadding = yPadding;
	}

	public Integer getXPadding() {
		return XPadding;
	}

	public void setXPadding(Integer xPadding) {
		XPadding = xPadding;
	}

	public Boolean getCollapseLock() {
		return collapseLock;
	}

	public void setCollapseLock(Boolean collapseLock) {
		this.collapseLock = collapseLock;
	}

	public Boolean getIsExpanded() {
		return isExpanded;
	}

	public void setIsExpanded(Boolean isExpanded) {
		this.isExpanded = isExpanded;
	}
}
