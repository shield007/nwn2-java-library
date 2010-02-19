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
package org.stanwood.nwn2.twoda;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class is used to represent a row within a Neverwinter Nights 2 database base (2da)
 */
public class Row2DA {
	private List<String> values = new ArrayList<String>();	
	
	/**
	 * Called by the parser to parse the contents of the row
	 * @param line The 2da line to parse
	 */
	void parseValues(String line) {
		StringTokenizer tok = new StringTokenizer(line, " \t");		
		
		while (tok.hasMoreTokens()) {
			String value = tok.nextToken();
			if (value.equals("****")) {
				value = null;
			}
			values.add(value);			
		}
	}
	
	/**
	 * Used to get the value of a field with within the row
	 * @param columnIndex The column index of the field within the row
	 * @return The value of the field
	 */
	public String getField(int columnIndex) {
		if (columnIndex >= values.size()) {
			return null;
		}
		return values.get(columnIndex);
	}
	
	/**
	 * Used to get the number of fields within the row
	 * @return The number of fields within the row
	 */
	public int getFieldCount() {
		return values.size();
	}
}
