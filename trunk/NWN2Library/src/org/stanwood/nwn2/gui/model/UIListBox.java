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

public class UIListBox extends UIObject {

	private static final long serialVersionUID = -4585373770701355889L;

	private Integer YPadding;
	private Boolean selectonLeftClick;
	private Integer XPadding;
	private Boolean scrollBarOnRight;
	private Boolean unequalControls;
	private Boolean showPartialChild;
	private Integer scrollSegmentSize;
	private Boolean hideScrollBarWhenNotNeeded;
	
	public UIListBox(NWN2GUIObject parent) {
		super(parent);
	}

	public Integer getYPadding() {
		return YPadding;
	}

	public void setYPadding(Integer yPadding) {
		YPadding = yPadding;
	}

	public Boolean getSelectonLeftClick() {
		return selectonLeftClick;
	}

	public void setSelectonLeftClick(Boolean selectonLeftClick) {
		this.selectonLeftClick = selectonLeftClick;
	}

	public Integer getXPadding() {
		return XPadding;
	}

	public void setXPadding(Integer xPadding) {
		XPadding = xPadding;
	}

	public Boolean getScrollBarOnRight() {
		return scrollBarOnRight;
	}

	public void setScrollBarOnRight(Boolean scrollBarOnRight) {
		this.scrollBarOnRight = scrollBarOnRight;
	}

	public Boolean getUnequalControls() {
		return unequalControls;
	}

	public void setUnequalControls(Boolean unequalControls) {
		this.unequalControls = unequalControls;
	}

	public Boolean getShowPartialChild() {
		return showPartialChild;
	}

	public void setShowPartialChild(Boolean showPartialChild) {
		this.showPartialChild = showPartialChild;
	}

	public Integer getScrollSegmentSize() {
		return scrollSegmentSize;
	}

	public void setScrollSegmentSize(Integer scrollSegmentSize) {
		this.scrollSegmentSize = scrollSegmentSize;
	}

	public Boolean getHideScrollBarWhenNotNeeded() {
		return hideScrollBarWhenNotNeeded;
	}

	public void setHideScrollBarWhenNotNeeded(Boolean hideScrollBarWhenNotNeeded) {
		this.hideScrollBarWhenNotNeeded = hideScrollBarWhenNotNeeded;
	}

	
}
