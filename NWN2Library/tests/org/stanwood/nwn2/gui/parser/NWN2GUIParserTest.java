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
package org.stanwood.nwn2.gui.parser;

import java.awt.Dimension;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.UIButton;
import org.stanwood.nwn2.gui.model.UIGrid;
import org.stanwood.nwn2.gui.model.UIIcon;
import org.stanwood.nwn2.gui.model.UIScene;
import org.stanwood.nwn2.gui.model.UIText;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParserTest;

public class NWN2GUIParserTest {

	@Test
	public void testParser() throws Exception {
		NWN2GUIParser parser = new NWN2GUIParser(NWN2GUIAntlrParserTest.class.getResourceAsStream("ns5_store.XML"));
		parser.parse();
		
		UIScene scene = parser.getGUI();
		Assert.assertNotNull(scene);
		
		Dimension screenDimension = new Dimension(800, 600);
		Assert.assertEquals("Check width", 359, scene.getWidth().getValue(screenDimension));
		Assert.assertEquals("Check height", 485, scene.getHeight().getValue(screenDimension));		
		Assert.assertEquals("Check x", 221, scene.getX().getValue(screenDimension, scene));
		Assert.assertEquals("Check y",58, scene.getY().getValue(screenDimension, scene));
		Assert.assertTrue("Check backout", scene.getBackoutkey());		
		Assert.assertNull("Check fullscreen", scene.getFullscreen());
		
		List<NWN2GUIObject> children = scene.getChildren();
		Assert.assertEquals("Check number of children in scene",11,children.size());
		
		Assert.assertTrue(scene.getChildren().get(0) instanceof UIIcon);
		Assert.assertTrue(scene.getChildren().get(1) instanceof UIText);
		Assert.assertTrue(scene.getChildren().get(2) instanceof UIButton);
		
		UIButton button = (UIButton) scene.getChildren().get(2);
		Assert.assertEquals("Check the button name","CloseButton",button.getName());
		
		Assert.assertEquals("Check number of children in button",0,button.getChildren().size());
		
		Assert.assertTrue(scene.getChildren().get(3) instanceof UIGrid);
		UIGrid grid = (UIGrid) scene.getChildren().get(3);
		Assert.assertEquals("Check the button name","STORE_GRID",grid.getName());
					
		Assert.assertEquals("Check number of children in grid",5,grid.getChildren().size());
		
		
		button = (UIButton) grid.getChildren().get(0);
		Assert.assertEquals("Check name","STORE_ARMOR", button.getName());
		Assert.assertEquals("Check number of children in grid",6,button.getChildren().size());
		
		
	}
}
