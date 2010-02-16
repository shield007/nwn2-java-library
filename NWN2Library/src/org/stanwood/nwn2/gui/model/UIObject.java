package org.stanwood.nwn2.gui.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.stanwood.nwn2.gui.parser.GUIParseException;

import edu.umd.cs.findbugs.annotations.Nullable;


/**
 * <p>
 * UIObject is the 'base' GUI object. You can't actually define it in XML, but it contains attributes that are common to many different UI Objects, so I'm starting here.
 * </p>
 * <p>More info can be found at: <a href="http://oeiprogrammer.blogspot.com/2007/01/uiobject.html">http://oeiprogrammer.blogspot.com/2007/01/uiobject.html</a>
 */
public class UIObject extends NWN2GUIObject {

	private static final long serialVersionUID = 1892922831893614644L;


	private final static Log log = LogFactory.getLog(UIObject.class);
	
	
	private Boolean scaleWithScene;
	
	private Boolean prototype;

	/**
	 * This tells the code to try and use some logic when this object gets
	 * resized in determining where its new X,Y origin should be. For example,
	 * if there is a lot of space to the right of the object, it will assume
	 * this object was left-anchored and keep the object to the left side with
	 * its new position. It's kind of a confusing attribute, all I can say is
	 * try it out and see if it does what you want, and don't use it if it
	 * doesn't. :)
	 */
	private Boolean useScaler;
	
	private ObjectWidth width;	
	private ObjectHeight height;
	private ObjectX x;
	private ObjectY y;

	/**
	 * In general, this means that the object can't be clicked on. For example,
	 * if it is an object in a UIGrid, it means that object in the grid can't be
	 * clicked on. This will keep the object of being the target of an
	 * actiontarget as well (When the mouse cursor changes to indicate the user
	 * can click somewhere to perform an action). Default value is true.
	 */
	private Boolean focusable = true;

	/**
	 * This is somewhat identical to setting focusable=false, but it also means
	 * that the UI Object will ignore objects being dragged on it, among some
	 * other UI events besides just mouse clicking. It defaults to false.
	 */
	private Boolean ignoreevents;

	/**
	 * Setting this to true means that action targets can be used on this GUI
	 * object. Action targets actions that need to be targeted on something,
	 * indicated by the mouse cursor changing appearance. For example, clicking
	 * on a spell button, then having the cursor change to indicate you need to
	 * click on what target you want the spell cast. If this attribute is true,
	 * then the GUI object will be treated as a valid target for actions to be
	 * performed on. It defaults to false.
	 */
	private Boolean handleactiontarget = false;

	/**
	 * This indicates that the UI Object can be dragged and dropped, such as
	 * hotbar buttons. Defaults to false.
	 */
	private Boolean draggable = false;

	/**
	 * Whether or not this object is visible. Defaults to true..
	 */
	private Boolean hidden = true;

	/**
	 * Whether or not this object is enabled. Applies mostly to buttons, but for
	 * the most part, no UI Object that is disabled will accept user input.
	 * Defaults to false.
	 */
	private Boolean disabled = false;

	/**
	 * If set to false, then mouse clicks should pass right through this object.
	 * Useful for semi-transparent overlays and other situations where it is
	 * expected that the user be able to click through the UI Object. This also
	 * applies to MouseEnter and MouseLeave. If an object is set to not capture
	 * mouse clicks, then objects underneath of it cannot be moused over.
	 */
	private Boolean capturemouseclicks;

	/**
	 * This determines if this UI object receives calls to an OnUpdate callback.
	 * Defaults to false. If set to true, then this UIObject will have its
	 * OnUpdate callback called on every frame, or slower if an updaterate is
	 * defined.
	 */
	private Boolean update;

	/**
	 * This is an advanced attribute that is used for determining how the hotbar
	 * should treat another UI Object being dragged onto it. The currently valid
	 * values for this attribute are: <br/>
	 * HOTBAR_NONE - The hotbar should ignore this.<br/>
	 * HOTBAR_ITEM - This is an item icon being dragged, such as from inventory.<br/>
	 * HOTBAR_KNOWNSPELL - This item being dragged is something from the
	 * spellbook.<br/>
	 * HOTBAR_SPELL - This item is a spell from somewhere else, such as another
	 * hotbar slot.<br/>
	 * HOTBAR_FEAT - This item is a feat from somewhere, such as the feat
	 * listing or another hotbar slot.<br/>
	 * HOTBAR_BUTTON - This is an empty hotbar button.<br/>
	 * HOTBAR_SKILL - This is an activateable skill, such as from the skills
	 * pane or another hotbar slot.<br/>
	 * HOTBAR_TOGGLEMODE_BUTTON - This is a button used to toggle some kind of
	 * mode.<br/>
	 * HOTBAR_BARTER - This is used to flag barter grid items as not being able
	 * to be dragged to the hotbar.<br/>
	 * HOTBAR_DM_COMMAND - The item being dragged is a DM Client command.<br/>
	 * HOTBAR_VM_COMMAND - The item being dragged is an emote command.<br/>
	 * HOTBAR_DM_CREATOR - The item being dragged is an entry from the DM Client
	 * Creator.<br/>
	 */
	private String hotbartype;

	/**
	 * The sound effect to play when this UI Object gets moused over.
	 */
	private String mouseOverSFX;

	/**
	 * This is a default tooltip STRREF that is used in case a custom tooltip
	 * callback is not really necessary.
	 */
	private String defaultTooltip;

	/**
	 * How transparent this object should be by default.
	 */
	private Integer alpha;

	/**
	 * 'Mouse Grab' means item being currently dragged. Normally the mouse grab
	 * is rendered last of all in order to keep it on top. There are situations
	 * where this behavior wasn't desired, though I can't remember what. When
	 * set to true, it means that this object needs to not get rendered last
	 * like normal dragged objects, but rather is rendered when it would
	 * normally be.
	 */
	private Boolean dontRenderMouseGrab;

	/**
	 * This attribute can be used to tune the update rate of a UI Object. If a
	 * particular object doesn't need to be updated every frame, then set an
	 * update rate here to slow it down. The number value is in seconds and
	 * floating points are okay (0.5 for half second, for example).
	 */
	private Float updateRate;

	private List<Callback> onMouseDropReceived = null;
	private List<Callback> onMouseDrop = null;
	private List<Callback> onMouseDropFailed = null;
	private List<Callback> onMouseEnter = null;
	private List<Callback> onMouseLeave = null;
	private List<Callback> onResize = null;
	private List<Callback> onTooltip = null;
	private List<Callback> onRadialRequest = null;
	private List<Callback> onGainedFocus = null;
	private List<Callback> onLostFocus = null;
	private List<Callback> onUpdate = null;

	public UIObject(NWN2GUIObject parent) {
		super(parent);
		try {
			setDefaults();
		} catch (GUIParseException e) {
			e.printStackTrace();
		}
	}

	
	private void setDefaults() throws GUIParseException {
		width =  new ObjectWidth(ObjectWidth.PARENT_WIDTH, this);
		height =  new ObjectHeight(ObjectHeight.PARENT_HEIGHT, this);
	}


	
	/**
	 * <p>
	 * Used to get the if the UI Object will have its dimensions
	 * scaled to match its parent's dimensions if the parent object gets
	 * resized. Handy for things like background images.
	 * </p>
	 * <p>
	 * This can return null if the GUI file did not specify the field for the object
	 * </p>
	 * @return True if the UI Object's dimensions scaled to match its parent's dimensions
	 */	
	@Nullable 
	public Boolean getScaleWithScene() {
		return scaleWithScene;
	}

	/**
	 * Used to set the if the UI Object will have its dimensions
	 * scaled to match its parent's dimensions if the parent object gets
	 * resized. Handy for things like background images.
	 * @param scaleWithScene True if the UI Object's dimensions scaled to match its parent's dimensions
	 */
	public void setScaleWithScene(Boolean scaleWithScene) {
		this.scaleWithScene = scaleWithScene;
	}

	public Boolean getUseScaler() {
		return useScaler;
	}

	public void setUseScaler(Boolean useScaler) {
		this.useScaler = useScaler;
	}

	/**
	 * Used to get the width of the object
	 * @return The width of the object
	 */
	public Width getWidth() {
		return width;
	}

	/**
	 * Used to set the width of the object. 
	 * @param width The width of the object
	 */
	public void setWidth(ObjectWidth width) {
		this.width = width;
	}

	/**
	 * Used to get the height of the object
	 * @return The height of the object
	 */
	public Height getHeight() {
		return height;
	}

	/**
	 * Used to set the height of the object
	 * @param height The height of the object
	 */
	public void setHeight(ObjectHeight height) {
		this.height = height;
	}

	/**
	 * Used to get the X position of the object
	 * @return The X position of the object
	 */
	public XPosition getX() {		
		return x;
	}

	/**
	 * Used to set the X position of the object
	 * @param x The X position of the object
	 */
	public void setX(ObjectX x) {
		this.x = x;
	}

	/**
	 * Used to get the Y position of the object
	 * @return The Y position of the object
	 */
	public YPosition getY() {
		return y;
	}

	/**
	 * Used to set the Y position of the object
	 * @param x The Y position of the object
	 */
	public void setY(ObjectY y) {
		this.y = y;
	}

	public Boolean getFocusable() {
		return focusable;
	}

	public void setFocusable(Boolean focusable) {
		this.focusable = focusable;
	}

	public Boolean getIgnoreevents() {
		return ignoreevents;
	}

	public void setIgnoreevents(Boolean ignoreevents) {
		this.ignoreevents = ignoreevents;
	}

	public Boolean getHandleactiontarget() {
		return handleactiontarget;
	}

	public void setHandleactiontarget(Boolean handleactiontarget) {
		this.handleactiontarget = handleactiontarget;
	}

	public Boolean getDraggable() {
		return draggable;
	}

	public void setDraggable(Boolean draggable) {
		this.draggable = draggable;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getCapturemouseclicks() {
		return capturemouseclicks;
	}

	public void setCapturemouseclicks(Boolean capturemouseclicks) {
		this.capturemouseclicks = capturemouseclicks;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public String getHotbartype() {
		return hotbartype;
	}

	public void setHotbartype(String hotbartype) {
		this.hotbartype = hotbartype;
	}

	public String getMouseOverSFX() {
		return mouseOverSFX;
	}

	public void setMouseOverSFX(String mouseOverSFX) {
		this.mouseOverSFX = mouseOverSFX;
	}

	public String getDefaultTooltip() {
		return defaultTooltip;
	}

	public void setDefaultTooltip(String defaultTooltip) {
		this.defaultTooltip = defaultTooltip;
	}

	public Integer getAlpha() {
		return alpha;
	}

	public void setAlpha(Integer alpha) {
		this.alpha = alpha;
	}

	public Boolean isDontRenderMouseGrab() {
		return dontRenderMouseGrab;
	}

	public void setDontRenderMouseGrab(Boolean dontRenderMouseGrab) {
		this.dontRenderMouseGrab = dontRenderMouseGrab;
	}

	public Float getUpdateRate() {
		return updateRate;
	}

	public void setUpdateRate(Float updateRate) {
		this.updateRate = updateRate;
	}
	
	public void addOnMouseDropReceived(Callback callback) {
		if (onMouseDropReceived==null) {
			onMouseDropReceived = new ArrayList<Callback>();			
		}
		onMouseDropReceived.add(callback);
	}
	
	public void addOnMouseDrop(Callback callback) {
		if (onMouseDrop==null) {
			onMouseDrop= new ArrayList<Callback>();			
		}
		onMouseDrop.add(callback);
	}
	
	public void addOnMouseDropFailed(Callback callback) {
		if (onMouseDropFailed==null) {
			onMouseDropFailed= new ArrayList<Callback>();			
		}
		onMouseDropFailed.add(callback);
	}
	
	public void addOnMouseEnter(Callback callback) {
		if (onMouseEnter==null) {
			onMouseEnter= new ArrayList<Callback>();			
		}
		onMouseEnter.add(callback);
	}
	
	public void addOnMouseLeave(Callback callback) {
		if (onMouseLeave==null) {
			onMouseLeave= new ArrayList<Callback>();			
		}
		onMouseLeave.add(callback);
	}
	
	public void addOnResize(Callback callback) {
		if (onResize==null) {
			onResize= new ArrayList<Callback>();			
		}
		onResize.add(callback);
	}

	public void addOnTooltip(Callback callback) {
		if (onTooltip==null) {
			onTooltip= new ArrayList<Callback>();			
		}
		onTooltip.add(callback);
	}
	public void addOnRadialRequest(Callback callback) {
		if (onRadialRequest==null) {
			onRadialRequest= new ArrayList<Callback>();			
		}
		onResize.add(callback);
	}
	public void addOnGainedFocus(Callback callback) {
		if (onGainedFocus==null) {
			onGainedFocus= new ArrayList<Callback>();			
		}
		onGainedFocus.add(callback);
	}
	public void addOnLostFocus(Callback callback) {
		if (onLostFocus==null) {
			onLostFocus= new ArrayList<Callback>();			
		}
		onLostFocus.add(callback);
	}
	
	public void addOnUpdate(Callback callback) {
		if (onUpdate==null) {
			onUpdate= new ArrayList<Callback>();			
		}
		onUpdate.add(callback);
	}

	public List<Callback> getOnMouseDropReceived() {
		return  onMouseDropReceived;
	}
	
	public List<Callback> getOnMouseDrop() {
		return  onMouseDrop;
	}
	
	public List<Callback> getOnMouseDropFailed() {
		return  onMouseDropFailed;
	}	
	
	public List<Callback> getOnMouseEnter() {
		return  onMouseEnter;
	}
	
	public List<Callback> getOnMouseLeave() {
		return  onMouseLeave;
	}
	
	public List<Callback> getOnResize() {
		return  onResize;
	}
	
	public List<Callback> getOnTooltip() {
		return  onTooltip;
	}
	
	public List<Callback> getOnRadialRequest() {
		return  onRadialRequest;
	}
	
	public List<Callback> getOnGainedFocus() {
		return  onGainedFocus;
	}
	
	public List<Callback> getOnLostFocus() {
		return  onLostFocus;
	}
	
	public List<Callback> getOnUpdate() {
		return  onUpdate;
	}

	public void applyStyle(UIObject styledObject) {
		if (styledObject.getClass() == this.getClass()) {
			for (Method m : styledObject.getClass().getMethods()) {
				if (m.getName().startsWith("get") && !m.getName().equalsIgnoreCase("getprototype") &&
					!m.getName().equalsIgnoreCase("getname") && !m.getName().equalsIgnoreCase("getclass") &&
					!m.getName().equalsIgnoreCase("getchildren") && !m.getName().equalsIgnoreCase("getparent") ) {
					try {
						Object value = m.invoke(styledObject);
						if (value!=null) {
							Method m2 = this.getClass().getMethod("set"+m.getName().substring(3),value.getClass());
						
							m2.invoke(this, value);
						}
					}
					catch (InvocationTargetException e) {
						log.error(e.getMessage(),e);
					} catch (SecurityException e) {
						log.error(e.getMessage(),e);
					} catch (NoSuchMethodException e) {
						log.error(e.getMessage(),e);
					} catch (IllegalArgumentException e) {
						log.error(e.getMessage(),e);
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);	
					}
				}
			}
			for (NWN2GUIObject child : styledObject.getChildren()) {
				NWN2GUIObject newChild;
				try {
					newChild = (NWN2GUIObject) child.clone();
					newChild.setParent(this);
					addChildObject(newChild);
				} catch (CloneNotSupportedException e) {
					log.error(e.getMessage(),e);
				}
				
			}
		}
	}


	public Boolean getPrototype() {
		return prototype;
	}


	public void setPrototype(Boolean prototype) {
		this.prototype = prototype;
	}


	
	
	
}
