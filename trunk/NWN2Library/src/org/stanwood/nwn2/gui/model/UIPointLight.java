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

public class UIPointLight extends UIObject {

	private static final long serialVersionUID = 6985053710498421748L;

	private Float colorR;
	private Float colorG;
	private Float colorB;
	private Float specColorR;
	private Float specColorG;
	private Float specColorB;
	private Float intensity;
	private Float posX;
	private Float posY;
	private Float posZ;
	private Boolean active;
	private Float radius;
	
	public UIPointLight(NWN2GUIObject parent) {
		super(parent);
	}

	public Float getColorR() {
		return colorR;
	}

	public void setColorR(Float colorR) {
		this.colorR = colorR;
	}


	public Float getColorG() {
		return colorG;
	}


	public void setColorG(Float colorG) {
		this.colorG = colorG;
	}


	public Float getColorB() {
		return colorB;
	}


	public void setColorB(Float colorB) {
		this.colorB = colorB;
	}

	public Float getSpecColorR() {
		return specColorR;
	}

	public void setSpecColorR(Float specColorR) {
		this.specColorR = specColorR;
	}

	public Float getSpecColorG() {
		return specColorG;
	}

	public void setSpecColorG(Float specColorG) {
		this.specColorG = specColorG;
	}

	public Float getSpecColorB() {
		return specColorB;
	}

	public void setSpecColorB(Float specColorB) {
		this.specColorB = specColorB;
	}

	public Float getIntensity() {
		return intensity;
	}

	public void setIntensity(Float intensity) {
		this.intensity = intensity;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Float getPosX() {
		return posX;
	}

	public void setPosX(Float posX) {
		this.posX = posX;
	}

	public Float getPosY() {
		return posY;
	}

	public void setPosY(Float posY) {
		this.posY = posY;
	}

	public Float getPosZ() {
		return posZ;
	}

	public void setPosZ(Float posZ) {
		this.posZ = posZ;
	}

	public Float getRadius() {
		return radius;
	}

	public void setRadius(Float radius) {
		this.radius = radius;
	}

}
