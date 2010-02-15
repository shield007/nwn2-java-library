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
