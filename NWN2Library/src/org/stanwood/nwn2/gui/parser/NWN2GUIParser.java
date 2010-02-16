package org.stanwood.nwn2.gui.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.UIScene;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParser;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUILexer;

/**
 * Used to parse a Neverwinter Nights 2 GUI XML file and return a UIScene that contains
 * objects representing the GUI.
 */
public class NWN2GUIParser extends BasicNWN2GUIParser {

	private final static Log log = LogFactory.getLog(NWN2GUIParser.class);
		
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
