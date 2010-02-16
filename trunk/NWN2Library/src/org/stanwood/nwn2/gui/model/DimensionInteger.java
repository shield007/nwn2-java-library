package org.stanwood.nwn2.gui.model;

import java.io.Serializable;

import org.stanwood.nwn2.gui.parser.GUIParseException;

public class DimensionInteger implements Serializable {

	private static final long serialVersionUID = -5588361374969356550L;
	
	private String value;
	
	protected DimensionInteger(String value, String[] allowedSpecialValues) throws GUIParseException {	
		try {
			Integer.parseInt(value);
		}
		catch (NumberFormatException e) {
			boolean found = false;
			for (String specialValue : allowedSpecialValues ) {
				if (value.equalsIgnoreCase(specialValue)) {
					found = true;
					break;					
				}
			}
			
			if (!found) {
				StringBuilder errorMessage = new StringBuilder();
				for (String specialValue : allowedSpecialValues ) {
					if (errorMessage.length()>0) {
						errorMessage.append(",");
					}
					errorMessage.append("\""+specialValue+"\"");
				}				
				errorMessage.insert(0, "Invalid value of '"+value+"', must be a integer or ");				
				throw new GUIParseException(errorMessage.toString());
			}
		}
		this.value = value;
	}
	
	public DimensionInteger(int value) {
		this.value = String.valueOf(value);
	}

	protected String getStringValue() {
		return value;
	}

}
