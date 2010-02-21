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

public class UIPortrait extends UIObject {

	private static final long serialVersionUID = -9184077890577678549L;

	private Float diffuseColorR;
	private Float diffuseColorG;
	private Float diffuseColorB;
	private Float ambSkyColorR;
	private Float ambSkyColorG;
	private Float ambSkyColorB;
	private Float ambSkyIntens;
	private Float lightIntens;
	private String texture;
	private Float ambGroundColorR;
	private Float ambGroundColorG;
	private Float ambGroundColorB;
	private Float ambGroundIntens;
	
	public UIPortrait(NWN2GUIObject parent) {
		super(parent);
	}

	public Float getDiffuseColorR() {
		return diffuseColorR;
	}

	public void setDiffuseColorR(Float diffuseColorR) {
		this.diffuseColorR = diffuseColorR;
	}

	public Float getDiffuseColorG() {
		return diffuseColorG;
	}

	public void setDiffuseColorG(Float diffuseColorG) {
		this.diffuseColorG = diffuseColorG;
	}

	public Float getDiffuseColorB() {
		return diffuseColorB;
	}

	public void setDiffuseColorB(Float diffuseColorB) {
		this.diffuseColorB = diffuseColorB;
	}

	public Float getAmbSkyColorR() {
		return ambSkyColorR;
	}

	public void setAmbSkyColorR(Float ambSkyColorR) {
		this.ambSkyColorR = ambSkyColorR;
	}

	public Float getAmbSkyColorG() {
		return ambSkyColorG;
	}

	public void setAmbSkyColorG(Float ambSkyColorG) {
		this.ambSkyColorG = ambSkyColorG;
	}

	public Float getAmbSkyColorB() {
		return ambSkyColorB;
	}

	public void setAmbSkyColorB(Float ambSkyColorB) {
		this.ambSkyColorB = ambSkyColorB;
	}

	public Float getAmbSkyIntens() {
		return ambSkyIntens;
	}

	public void setAmbSkyIntens(Float ambSkyIntens) {
		this.ambSkyIntens = ambSkyIntens;
	}

	public Float getLightIntens() {
		return lightIntens;
	}

	public void setLightIntens(Float lightIntens) {
		this.lightIntens = lightIntens;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public Float getAmbGroundColorR() {
		return ambGroundColorR;
	}

	public void setAmbGroundColorR(Float ambGroundColorR) {
		this.ambGroundColorR = ambGroundColorR;
	}

	public Float getAmbGroundColorG() {
		return ambGroundColorG;
	}

	public void setAmbGroundColorG(Float ambGroundColorG) {
		this.ambGroundColorG = ambGroundColorG;
	}

	public Float getAmbGroundColorB() {
		return ambGroundColorB;
	}

	public void setAmbGroundColorB(Float ambGroundColorB) {
		this.ambGroundColorB = ambGroundColorB;
	}

	public Float getAmbGroundIntens() {
		return ambGroundIntens;
	}

	public void setAmbGroundIntens(Float ambGroundIntens) {
		this.ambGroundIntens = ambGroundIntens;
	}
}
