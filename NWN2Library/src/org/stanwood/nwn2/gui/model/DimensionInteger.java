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
