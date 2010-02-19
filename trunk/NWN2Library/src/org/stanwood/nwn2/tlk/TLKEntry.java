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
package org.stanwood.nwn2.tlk;

public class TLKEntry {

	private String text;
	private String soundResRef;
	private float soundLength;
	private int volumnVariance;
	private int pitchVariance;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSoundResRef() {
		return soundResRef;
	}
	public void setSoundResRef(String sound) {
		this.soundResRef = sound;
	}
	public float getSoundLength() {
		return soundLength;
	}
	public void setSoundLength(float soundLength) {
		this.soundLength = soundLength;
	}
	public int getVolumnVariance() {
		return volumnVariance;
	}
	public void setVolumnVariance(int volumnVariance) {
		this.volumnVariance = volumnVariance;
	}
	public int getPitchVariance() {
		return pitchVariance;
	}
	public void setPitchVariance(int pitchVariance) {
		this.pitchVariance = pitchVariance;
	}
}
