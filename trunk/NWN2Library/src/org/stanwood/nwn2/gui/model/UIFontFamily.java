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
