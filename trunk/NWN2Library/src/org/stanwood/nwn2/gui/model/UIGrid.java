package org.stanwood.nwn2.gui.model;

public class UIGrid extends UIObject {

	private static final long serialVersionUID = -7779759025081098331L;

	private Integer rows;
	private Integer columns;
	private Integer yPadding = 0;
	private Integer xPadding= 0;
	
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

	public Integer getyPadding() {
		return yPadding;
	}

	public void setyPadding(Integer yPadding) {
		this.yPadding = yPadding;
	}

	public Integer getxPadding() {
		return xPadding;
	}

	public void setxPadding(Integer xPadding) {
		this.xPadding = xPadding;
	}

	
}
