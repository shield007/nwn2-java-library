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
