package org.stanwood.nwn2.gui.model;

public class UIFrame extends UIObject {

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
				return ((UIScene)getParent()).getX();
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
				return ((UIScene)getParent()).getY();
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
