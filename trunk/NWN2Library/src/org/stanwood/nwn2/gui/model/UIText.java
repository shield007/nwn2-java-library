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
	private Integer hangingIndent = 0;
	private String text;
	private Integer strRef;
	private String color;
	private Boolean multiLine = false;
	private Boolean upperCase;
	private Integer maxLines;
	private String halign;
	
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

	public Integer getHangingIndent() {
		return hangingIndent;
	}

	public void setHangingIndent(Integer hangingindent) {
		this.hangingIndent = hangingindent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStrRef() {
		return strRef;
	}

	public void setStrRef(Integer strref) {
		this.strRef = strref;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getMultiLine() {
		return multiLine;
	}

	public void setMultiLine(Boolean multiline) {
		this.multiLine = multiline;
	}

	public Boolean getUpperCase() {
		return upperCase;
	}

	public void setUpperCase(Boolean uppercase) {
		this.upperCase = uppercase;
	}

	public Integer getMaxLines() {
		return maxLines;
	}

	public void setMaxLines(Integer maxLines) {
		this.maxLines = maxLines;
	}

	public String getHalign() {
		return halign;
	}

	public void setHalign(String halign) {
		this.halign = halign;
	}

}
