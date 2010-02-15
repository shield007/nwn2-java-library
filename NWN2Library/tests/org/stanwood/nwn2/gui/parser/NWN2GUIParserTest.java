package org.stanwood.nwn2.gui.parser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.UIScene;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParserTest;

public class NWN2GUIParserTest {

	@Test
	public void testParser() throws Exception {
		NWN2GUIParser parser = new NWN2GUIParser(NWN2GUIAntlrParserTest.class.getResourceAsStream("ns5_store.XML"));
		parser.parse();
		
		UIScene scene = parser.getGUI();
		Assert.assertNotNull(scene);
		
		Assert.assertEquals("Check width", "359", scene.getWidth());
		Assert.assertEquals("Check height", "485", scene.getHeight());		
		Assert.assertEquals("Check x", "ALIGN_CENTER", scene.getX());
		Assert.assertEquals("Check y", "ALIGN_CENTER", scene.getY());
		Assert.assertTrue("Check backout", scene.getBackoutkey());		
		Assert.assertNull("Check fullscreen", scene.getFullscreen());
		
		List<NWN2GUIObject> children = scene.getChildren();
		Assert.assertEquals("Check number of children in scene",11,children.size());
		
		
	}
}
