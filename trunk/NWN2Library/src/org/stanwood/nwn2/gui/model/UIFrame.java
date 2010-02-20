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

public class UIFrame extends UIObject {

	private static final long serialVersionUID = 6138259845982821848L;

	/**
	 * This tells the engine to fill in the center space of the frame with the
	 * fill texture using different algorithms. This attribute takes the
	 * following string arguments: center - Center the 'fill' texture. stretch -
	 * Stretch the 'fill' texture to take up the full center. tile - Repeat the
	 * 'fill' texture to fill up the center.
	 */
	private String fillstyle;
	
	private String color;
	private Integer border = 0;
	private String topleft;
	private String topright;
	private String bottomleft;
	private String bottomright;
	private String top;
	private String bottom;
	private String left;
	private String right;
	private String fill;
	private Boolean maside = false;
	private Boolean mvside = false;
	private Boolean mhside = false;
	private Boolean mvright = false;
	private Boolean mvleft = false;
	private Boolean mhbottom = false;
	private Boolean mhtop = false;
	private String state;
	
	public UIFrame(NWN2GUIObject parent) {
		super(parent);
	}

	public String getTopleft() {
		return topleft;
	}

	public void setTopleft(String topleft) {
		this.topleft = topleft;
	}

	public String getTopright() {
		return topright;
	}

	public void setTopright(String topright) {
		this.topright = topright;
	}

	public String getBottomleft() {
		return bottomleft;
	}

	public void setBottomleft(String bottomleft) {
		this.bottomleft = bottomleft;
	}

	public String getBottomright() {
		return bottomright;
	}

	public void setBottomright(String bottomright) {
		this.bottomright = bottomright;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getBottom() {
		return bottom;
	}

	public void setBottom(String bottom) {
		this.bottom = bottom;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	/**
	 * Used to get the thickness of the border pieces in pixels. Note that it defaults to 0. If no border thickness is set, then all the textures besides 'fill' won't show up when the UIFrame gets rendered.
	 * @return The border thickness
	 */
	public Integer getBorder() {
		return border;
	}

	/**
	 * Used to set the thickness of the border pieces in pixels. Note that it defaults to 0. If no border thickness is set, then all the textures besides 'fill' won't show up when the UIFrame gets rendered.
	 * @param border The border thickness
	 */
	public void setBorder(Integer border) {
		this.border = border;
	}

	/**
	 * Used to get the color string that should be blended with the frame textures.
	 * @return the color string that should be blended with the frame textures.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Used to set the color string that should be blended with the frame textures.
	 * @param color the color string that should be blended with the frame textures.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	public String getFillstyle() {
		return fillstyle;
	}

	public void setFillstyle(String fillstyle) {
		this.fillstyle = fillstyle;
	}

	public Boolean getMaside() {
		return maside;
	}

	public void setMaside(Boolean maside) {
		this.maside = maside;
	}

	public Boolean getMvside() {
		return mvside;
	}

	public void setMvside(Boolean mvside) {
		this.mvside = mvside;
	}

	public Boolean getMhside() {
		return mhside;
	}

	public void setMhside(Boolean mhside) {
		this.mhside = mhside;
	}

	public Boolean getMvright() {
		return mvright;
	}

	public void setMvright(Boolean mvright) {
		this.mvright = mvright;
	}

	public Boolean getMvleft() {
		return mvleft;
	}

	public void setMvleft(Boolean mvleft) {
		this.mvleft = mvleft;
	}

	public Boolean getMhbottom() {
		return mhbottom;
	}

	public void setMhbottom(Boolean mhbottom) {
		this.mhbottom = mhbottom;
	}

	public Boolean getMhtop() {
		return mhtop;
	}

	public void setMhtop(Boolean mhtop) {
		this.mhtop = mhtop;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	@Override
	public Height getHeight() {
		if (super.getHeight()==null) {
			if (getParent() instanceof UIScene) {
				return ((UIScene)getParent()).getHeight();
			}
			return ((UIObject)getParent()).getHeight();
		}
		else {
			return super.getHeight();
		}
	}

	@Override
	public Width getWidth() {
		if (super.getWidth()==null) {
			if (getParent() instanceof UIScene) {
				return ((UIScene)getParent()).getWidth();
			}
			return ((UIObject)getParent()).getWidth();
		}
		else {
			return super.getWidth();
		}
	}

	@Override
	public XPosition getX() {
		if (super.getX()==null) {
			if (getParent() instanceof UIScene) {
				return new XPosition(0 );
				//return ((UIScene)getParent()).getX();
			}
			else {
				return ((UIObject)getParent()).getX();
			}	
		}
		else {
			return super.getX();
		}
	}

	@Override
	public YPosition getY() {
		if (super.getY()==null) {
			if (getParent() instanceof UIScene) {
				return new YPosition(0 );
			}
			else {
				return ((UIObject)getParent()).getY();
			}
		}
		else {
			return super.getY();
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}		

	
}
