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

public class UIText extends UIObject {

	private static final long serialVersionUID = -3231042975740985128L;

	private String fontFamily;
	private String valign;
	private String align;
	private String style = "normal";
	private Integer indent = 0;
	private Integer hangingindent = 0;
	private String text;
	private Integer strref;
	private String color;
	private Boolean multiline = false;	
	
	public UIText(NWN2GUIObject parent) {
		super(parent);
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public String getValign() {
		return valign;
	}

	public void setValign(String valign) {
		this.valign = valign;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Integer getIndent() {
		return indent;
	}

	public void setIndent(Integer indent) {
		this.indent = indent;
	}

	public Integer getHangingindent() {
		return hangingindent;
	}

	public void setHangingindent(Integer hangingindent) {
		this.hangingindent = hangingindent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStrRef() {
		return strref;
	}

	public void setStrRef(Integer strref) {
		this.strref = strref;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getMultiline() {
		return multiline;
	}

	public void setMultiline(Boolean multiline) {
		this.multiline = multiline;
	}

	
}
