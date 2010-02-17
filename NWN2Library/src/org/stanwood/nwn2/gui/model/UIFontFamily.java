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
			if (style.equalsIgnoreCase("normal") && child instanceof UIFontNormal) {
				return (UIFont) child;
			}
			else if (style.equalsIgnoreCase("bold") && child instanceof UIFontBold) {
				return (UIFont) child;
			}
			else if (style.equalsIgnoreCase("italic") && child instanceof UIFontItalic) {
				return (UIFont) child;
			}
			else if (style.equalsIgnoreCase("bolditalic") && child instanceof UIFontBoldItalic) {
				return (UIFont) child;
			}
		}
		return null;
	}
}
