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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class is used to parse the contents from a Neverwinter Nights 2 2DA file. The file
 * is a database file.
 */
public class Parser2DA {
	
	private List<Column2DA> columns = new ArrayList<Column2DA> ();
	private List<Row2DA> rows = new ArrayList<Row2DA>();
	
	/**
	 * The constructor used to create a instance of the class
	 */
	public Parser2DA() {		
	}

	/**
	 * This will parse the contents of the 2da file
	 * @param inputStream The input stream to the 2DA file's contents
	 * @throws IOException Throw if their is a problem reading the file contents
	 * @throws TwoDAParseException Throw if their is a problem parsing the contents
	 */
	public void parse2DA( InputStream inputStream) throws IOException, TwoDAParseException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		String line = in.readLine(); // read version
		line = in.readLine(); // blank line;
		line = in.readLine(); // Header
		columns = getColumnNames(line);	
		if (columns.size()==0) {
			throw new TwoDAParseException("Table has no columns");			
		}
		
		while ((line = in.readLine()) != null) {
			Row2DA row = new Row2DA();
			row.parseValues(line);
			
			for (int i=0;i<columns.size();i++) {				
				String value = row.getField(i);
				if (value==null) {
					columns.get(i).setNullable(true);
				}
				else if (!isInt(value)) {
					columns.get(i).setType(TwoDAColumnType.STRING);
				}				
			}
			
			rows.add(row);
		}
	}
	
	private boolean isInt(String value) {
		try
		{
			Integer.parseInt(value);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}		
	}	

	private List<Column2DA> getColumnNames(String line) {
		List<Column2DA> list = new ArrayList<Column2DA>();
		Column2DA idColumn = new Column2DA("rowId");
		idColumn.setType(TwoDAColumnType.INTEGER);
		list.add(idColumn);
		StringTokenizer tok = new StringTokenizer(line, " \t");		
		while (tok.hasMoreTokens()) {
			String token = tok.nextToken();			
			Column2DA column = new Column2DA(token);
			while (list.contains(column)) {
				column.setName(token);
			}
			list.add(column);
		}
		return list;
	}

	/**
	 * Get a list of the columns in the file
	 * @return The columns in the file
	 */
	public List<Column2DA> getColumns() {
		return columns;
	}
	
	/**
	 * Used to get a list of the rows in the file
	 * @return The rows in the file
	 */
	public List<Row2DA> getRows() {
		return rows;
	}
}
