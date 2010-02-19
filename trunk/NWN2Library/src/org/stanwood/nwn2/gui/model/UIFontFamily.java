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

public class UIFontFamily extends NWN2GUIObject {

	public UIFontFamily(NWN2GUIObject parent) {
		super(parent);
	}

	private static final long serialVersionUID = -75456136209033219L;

	@Override
	public XPosition getX() {
		return null;
	}

	@Override
	public YPosition getY() {
		return null;
	}

	public UIFont getFont(String style) {
		for (NWN2GUIObject child : getChildren()) {
			if ((style.equalsIgnoreCase("normal") || style.equals("1")) && child instanceof UIFontNormal) {
				return (UIFont) child;
			}
			else if ((style.equalsIgnoreCase("bold") || style.equals("2")) && child instanceof UIFontBold) {
				return (UIFont) child;
			}
			else if ((style.equalsIgnoreCase("italic") || style.equals("3")) && child instanceof UIFontItalic) {
				return (UIFont) child;
			}
			else if ((style.equalsIgnoreCase("bolditalic") || style.equals("4")) && child instanceof UIFontBoldItalic) {
				return (UIFont) child;
			}
		}
		return null;
	}
}
