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

public class UI3DScene extends UIObject {

	private static final long serialVersionUID = -5745899316675665484L;

	private Float ambSkyIntens;
	private Float ambSkyColorR;
	private Float ambSkyColorG;
	private Float ambSkyColorB;
	private Float ambGroundIntens;
	private Float cameraPosZ;
	private Float cameraPosX;
	private Float cameraPosY;
	private Float ambGroundColorR;	
	private Float ambGroundColorG;
	private Float ambGroundColorB;
	private Float cameraLookX;
	private Float cameraLookY;
	private Float cameraLookZ;
	private Float diffuseColorR;
	private Float diffuseColorG;
	private Float diffuseColorB;	
	private String texture;
	private Float lightIntens;	
	private Float lightDirX;
	private Float lightDirY;
	private Float lightDirZ;
	
	
	public UI3DScene(NWN2GUIObject parent) {
		super(parent);
	}


	public Float getAmbSkyIntens() {
		return ambSkyIntens;
	}


	public void setAmbSkyIntens(Float ambSkyIntens) {
		this.ambSkyIntens = ambSkyIntens;
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


	public Float getAmbGroundIntens() {
		return ambGroundIntens;
	}


	public void setAmbGroundIntens(Float ambGroundIntens) {
		this.ambGroundIntens = ambGroundIntens;
	}


	public Float getCameraPosZ() {
		return cameraPosZ;
	}


	public void setCameraPosZ(Float cameraPosZ) {
		this.cameraPosZ = cameraPosZ;
	}


	public Float getCameraPosX() {
		return cameraPosX;
	}


	public void setCameraPosX(Float cameraPosX) {
		this.cameraPosX = cameraPosX;
	}


	public Float getCameraPosY() {
		return cameraPosY;
	}


	public void setCameraPosY(Float cameraPosY) {
		this.cameraPosY = cameraPosY;
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


	public Float getCameraLookX() {
		return cameraLookX;
	}


	public void setCameraLookX(Float cameraLookX) {
		this.cameraLookX = cameraLookX;
	}


	public Float getCameraLookY() {
		return cameraLookY;
	}


	public void setCameraLookY(Float cameraLookY) {
		this.cameraLookY = cameraLookY;
	}


	public Float getCameraLookZ() {
		return cameraLookZ;
	}


	public void setCameraLookZ(Float cameraLookZ) {
		this.cameraLookZ = cameraLookZ;
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


	public String getTexture() {
		return texture;
	}


	public void setTexture(String texture) {
		this.texture = texture;
	}


	public Float getLightIntens() {
		return lightIntens;
	}


	public void setLightIntens(Float lightIntens) {
		this.lightIntens = lightIntens;
	}


	public Float getLightDirX() {
		return lightDirX;
	}


	public void setLightDirX(Float lightDirX) {
		this.lightDirX = lightDirX;
	}


	public Float getLightDirY() {
		return lightDirY;
	}


	public void setLightDirY(Float lightDirY) {
		this.lightDirY = lightDirY;
	}


	public Float getLightDirZ() {
		return lightDirZ;
	}


	public void setLightDirZ(Float lightDirZ) {
		this.lightDirZ = lightDirZ;
	}

	
}
