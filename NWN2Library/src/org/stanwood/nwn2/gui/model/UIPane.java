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

public class UIPane extends UIObject {

	private static final long serialVersionUID = 7063557647738750321L;

	private Boolean hideOverride;
	private Boolean tupple;
	private Boolean useScalar;
	
	public UIPane(NWN2GUIObject parent) {
		super(parent);
	}

	public Boolean getHideOverride() {
		return hideOverride;
	}

	public void setHideOverride(Boolean hideOverride) {
		this.hideOverride = hideOverride;
	}

	public Boolean getTupple() {
		return tupple;
	}

	public void setTupple(Boolean tupple) {
		this.tupple = tupple;
	}

	public Boolean getUseScalar() {
		return useScalar;
	}

	public void setUseScalar(Boolean useScalar) {
		this.useScalar = useScalar;
	}
}
