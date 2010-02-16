package org.stanwood.nwn2.gui.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.UIObject;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParser;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUILexer;

public class GUIStyleSheetParser extends BasicNWN2GUIParser{

	private InputStream guiFile;
	private List<NWN2GUIObject> uiObjects = new ArrayList<NWN2GUIObject>();
	
	/**
	 * Used to create a instance of the parse
	 * @param guiFile The input steam to the file been parsed.
	 */
	public GUIStyleSheetParser(InputStream guiFile) {
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
	        
	        for (int i=0;i<tree.getChildCount();i++) {
				CommonTree child = (CommonTree) tree.getChild(i);
				switch (child.getType()) {									
					case NWN2GUIAntlrParser.TAG_CONTENTS:
						String name = getGUIObjectName(child);
						if (!name.equalsIgnoreCase("uiscene")) {						
							NWN2GUIObject obj = createGUIObject(child,null);
							for (int j=0;j<child.getChildCount();j++) {
								CommonTree child2 = (CommonTree) child.getChild(j);
								if (child2.getType() == NWN2GUIAntlrParser.TAG_CONTENTS) {
									addObjectsToParent(child2,obj);
								}
							}
							uiObjects.add(obj);							
						}																			
						break;
					default:
						// Do nothing
				}
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
	
	public List<NWN2GUIObject>getUIObjects() {
		return uiObjects;
	}
}
