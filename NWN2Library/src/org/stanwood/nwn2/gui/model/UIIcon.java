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

public class UIIcon extends UIObject {

	private static final long serialVersionUID = -5660641001073877647L;
	
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
