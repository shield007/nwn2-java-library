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

public class UIGrid extends UIObject {

	private static final long serialVersionUID = -7779759025081098331L;

	private Integer rows;
	private Integer columns;
	private Integer YPadding = 0;
	private Integer XPadding= 0;
	private Boolean captureMouseEvents;
	
	public UIGrid(NWN2GUIObject parent) {
		super(parent);
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Integer getYPadding() {
		return YPadding;
	}

	public void setYPadding(Integer yPadding) {
		this.YPadding = yPadding;
	}

	public Integer getXPadding() {
		return XPadding;
	}

	public void setXPadding(Integer xPadding) {
		this.XPadding = xPadding;
	}

	public Boolean getCaptureMouseEvents() {
		return captureMouseEvents;
	}

	public void setCaptureMouseEvents(Boolean captureMouseEvents) {
		this.captureMouseEvents = captureMouseEvents;
	}

}
