package org.stanwood.nwn2.gui.parser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.stanwood.nwn2.gui.model.NWN2GUIObject;
import org.stanwood.nwn2.gui.model.Height;
import org.stanwood.nwn2.gui.model.Width;
import org.stanwood.nwn2.gui.model.UIScene;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUIAntlrParser;
import org.stanwood.nwn2.gui.parser.antlr.NWN2GUILexer;

/**
 * Used to parse a Neverwinter Nights 2 GUI XML file and return a UIScene that contains
 * objects representing the GUI.
 */
public class NWN2GUIParser {

	private final static Log log = LogFactory.getLog(NWN2GUIParser.class);
	
	private static final String OBJECT_PACKAGE = "org.stanwood.nwn2.gui.model.";
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
	        
	        addObjectsToScene(tree,scene);	        
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
	
	private void addObjectsToScene(CommonTree tree,NWN2GUIObject parent) throws GUIParseException {		
		for (int i=0;i<tree.getChildCount();i++) {
			CommonTree child = (CommonTree) tree.getChild(i);
			switch (child.getType()) {									
				case NWN2GUIAntlrParser.TAG_CONTENTS:
					String name = getGUIObjectName(child);
					if (!name.equalsIgnoreCase("uiscene")) {						
						NWN2GUIObject obj = createGUIObject(child,parent);
						for (int j=0;j<child.getChildCount();j++) {
							CommonTree child2 = (CommonTree) child.getChild(j);
							if (child2.getType() == NWN2GUIAntlrParser.TAG_CONTENTS) {
								addObjectsToScene(child2,obj);
							}
						}
						parent.addChildObject(obj);
					}																			
					break;
				default:
					// Do nothing
			}
		}
	}

	private NWN2GUIObject createGUIObject(CommonTree node,NWN2GUIObject parent) throws GUIParseException {
		String name = getGUIObjectName(node);
		Map<String,String> attributes = getGUIObjectAttributes(node);
		
		String className  = getObjectClassName(name);
		try {
			Class<?> c = Class.forName(className);
			Class<? extends NWN2GUIObject> guiObjectClass = c.asSubclass(NWN2GUIObject.class);
			Constructor<? extends NWN2GUIObject> constructor = guiObjectClass.getConstructor(NWN2GUIObject.class);
			NWN2GUIObject guiObject = constructor.newInstance(parent);
			setAttributes(guiObject,attributes);
			return guiObject;
		}
		catch (NoClassDefFoundError e) {
			throw new GUIParseException("Unable to find UIObject class : " + className,e);
		} catch (ClassNotFoundException e) {
			throw new GUIParseException("Unable to find UIObject class : " + className,e);			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private String getObjectClassName(String name) {
		if (name.equalsIgnoreCase("uilistbox")) {
			name = "UIListBox";
		}
		return OBJECT_PACKAGE+name;
	}

	private void setAttributes(NWN2GUIObject guiObject,Map<String, String> attributes) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, GUIParseException {
		for (Entry<String,String>entry : attributes.entrySet()) {
			String key = entry.getKey();
			if (key.toLowerCase().startsWith("on")) {
				// TODO set callbacks
			}
			else {
				boolean found = false;
				for (Method m : guiObject.getClass().getMethods()) {										
					if (m.getName().equalsIgnoreCase("set"+key)) {
						found = true;
						Class<?>[] types = m.getParameterTypes();
						
						Object value = AttributeValueFactory.getAttributeValue(guiObject,entry.getValue(),types[0]);
						m.invoke(guiObject, value);
						break;
					}
				}
				if (!found) {
					log.error("Unable to find attribute '"+key+"' in object '"+guiObject.getClass()+"'");
				}
			}
		}
	}
	

	private CommonTree findGUIObjectByName(Tree parent,String name) {		
		for (int i=0;i<parent.getChildCount();i++) {
			CommonTree child = (CommonTree) parent.getChild(i);
			if (child.getType()==NWN2GUIAntlrParser.TAG_CONTENTS ) {
				if (getGUIObjectName(child).equalsIgnoreCase(name)) {
					return child;
				}
				else {
					CommonTree found = findGUIObjectByName(child,name);
					if (found!=null) {
						return found;
					}
				}
			}			
		}
		return null;
	}

	private Map<String, String> getGUIObjectAttributes(CommonTree child) {
		Map<String, String> attributes = new HashMap<String,String>();
		Tree attributesNode = child.getFirstChildWithType(NWN2GUIAntlrParser.ATTRIBUTES);
		for (int i=0;i<attributesNode.getChildCount();i++) {
			Tree attributeNode = attributesNode.getChild(i);
			String value = attributeNode.getChild(1).getText();
			if (value.startsWith("'") && value.endsWith("'") || 
				value.startsWith("\"") && value.endsWith("\"")) {
				value = value.substring(1,value.length()-1);
			}
			attributes.put(attributeNode.getChild(0).getText(),value); 
		}
		return attributes;
	}

	private String getGUIObjectName(CommonTree child) {
		CommonTree guiElement = (CommonTree) child.getFirstChildWithType(NWN2GUIAntlrParser.GENERIC_ID);
		String guiObjectName = guiElement.getText();
		return guiObjectName;
	}
	
	/**
	 * Once the scene has been parsed, this will return the scene.
	 * @return Null if no scene parsed, otherwise the scene.
	 */
	public UIScene getGUI() {		
		return scene;
	}
}
