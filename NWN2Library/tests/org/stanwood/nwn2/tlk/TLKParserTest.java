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
package org.stanwood.nwn2.tlk;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

import org.junit.Assert;
import org.junit.Test;

public class TLKParserTest {
	
	@Test
	public void testTLKParser() throws Exception{
		TLKParser parser = new TLKParser();		
		parser.open(getFile("example.tlk"));
		
		Assert.assertEquals("TLK ",parser.getFileType());
		Assert.assertEquals("V3.0",parser.getFileVersion());
		Assert.assertEquals(116,parser.getStringCount());
		Assert.assertEquals(0,parser.getLangId());
		
		TLKEntry entry; 
		entry = parser.readEntry(0);
		Assert.assertEquals("NS Bad StrRef",entry.getText());
		
		entry = parser.readEntry(1);
		Assert.assertEquals("NSArmor",entry.getText());
		
		entry = parser.readEntry(2);
		Assert.assertEquals("Light Armor",entry.getText());		
				
		entry = parser.readEntry(16777233 - 0x1000000);
		StringBuilder expected = new StringBuilder();
		expected.append("Armor Class: 6\n");
		expected.append("Maximum Dexterity Bonus: 4\n");
		expected.append("Armor Check Penalty: -4\n");
		expected.append("Arcane Spell Failure: 20%\n");
		expected.append("Feats Required: Heavy Armor");
		Assert.assertEquals(expected.toString(),entry.getText());
	}	
	
	private File getFile(String filename) throws IOException {
        URL url = TLKParserTest.class.getResource(filename);
        if (url == null) {
            throw new IOException("Unable to find test file: " + filename);
        }
        String fullPath = URLDecoder.decode(url.getFile(), "UTF8");
        return new File(fullPath);
    }
}
