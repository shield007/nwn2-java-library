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

	private Integer yPadding;
	private Boolean selectonleftclick;
	private Integer xPadding;
	private Boolean scrollbaronright;
	private Boolean unequalcontrols;
	private Boolean showpartialchild;
	private Integer scrollsegmentsize;
	
	public UIListBox(NWN2GUIObject parent) {
		super(parent);
	}

	public Integer getyPadding() {
		return yPadding;
	}

	public void setyPadding(Integer yPadding) {
		this.yPadding = yPadding;
	}

	public Boolean getSelectonleftclick() {
		return selectonleftclick;
	}

	public void setSelectonleftclick(Boolean selectonleftclick) {
		this.selectonleftclick = selectonleftclick;
	}

	public Integer getxPadding() {
		return xPadding;
	}

	public void setxPadding(Integer xPadding) {
		this.xPadding = xPadding;
	}

	public Boolean getScrollBarOnRight() {
		return scrollbaronright;
	}

	public void setScrollbaronright(Boolean scrollbaronright) {
		this.scrollbaronright = scrollbaronright;
	}

	public Boolean getUnequalcontrols() {
		return unequalcontrols;
	}

	public void setUnequalcontrols(Boolean unequalcontrols) {
		this.unequalcontrols = unequalcontrols;
	}

	public Boolean getShowpartialchild() {
		return showpartialchild;
	}

	public void setShowpartialchild(Boolean showpartialchild) {
		this.showpartialchild = showpartialchild;
	}

	public Integer getScrollsegmentsize() {
		return scrollsegmentsize;
	}

	public void setScrollsegmentsize(Integer scrollsegmentsize) {
		this.scrollsegmentsize = scrollsegmentsize;
	}
}
