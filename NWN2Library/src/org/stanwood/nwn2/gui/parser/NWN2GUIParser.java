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

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.stanwood.nwn2.gui.model.UIScene;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParser;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUILexer;

/**
 * Used to parse a Neverwinter Nights 2 GUI XML file and return a UIScene that contains
 * objects representing the GUI.
 */
public class NWN2GUIParser extends BasicNWN2GUIParser {

	private InputStream guiFile;
	private UIScene scene;
	
	/**
	 * Used to create a instance of the parse
	 * @param guiFile The input steam to the file been parsed.
	 */
	public NWN2GUIParser(InputStream guiFile) {
		this.guiFile = guiFile;
	}
	
	/**
	 * Called to parse the GUI
	 * @throws GUIParseException Thrown if their is a problem parsing the GUI file
	 * @throws IOException Thrown if their is a problem reading the file
	 */
	public void parse() throws GUIParseException, IOException {
		try {			
			CharStream input = new ANTLRInputStream(guiFile);
			NWN2GUILexer lexer = new NWN2GUILexer(input);
		    CommonTokenStream tokens = new  CommonTokenStream(lexer);

		    NWN2GUIAntlrParser parser = new NWN2GUIAntlrParser(tokens);
		 
		    		    		   		    
	        CommonTree tree = (CommonTree) parser.document().getTree();
	        CommonTree node = findGUIObjectByName(tree,"UIScene");	       	        
	        scene = (UIScene) createGUIObject(node,null);
	        
	    	for (int i=0;i<tree.getChildCount();i++) {
	    		CommonTree child = (CommonTree) tree.getChild(i);
	    		addObjectsToParent(child,scene);
	    	}
		}
		catch (RecognitionException e) {
			throw new GUIParseException("Unable to parse gui file",e);
		}
		finally {
			if (guiFile!=null) {				
				guiFile.close();
			}
		}
	}
	
	

	
	
	/**
	 * Once the scene has been parsed, this will return the scene.
	 * @return Null if no scene parsed, otherwise the scene.
	 */
	public UIScene getGUI() {		
		return scene;
	}
}
