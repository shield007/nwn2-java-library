package org.stanwood.nwn2.gui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The UIScene tag at the top of the XML files defines certain global parameters
 * about the entire GUI window being defined in the file.
 * </p>
 * <p>
 * A scene doesn't have anything to render by default, but rather contains items
 * that will get rendered. So a file that defines a UIScene and nothing else
 * will not appear as anything in the game.
 * </p>
 * <p>
 * Some of the attributes for UIScene overlap with those of UIObject, even
 * though UIScene does not inherit from UIObject, so this attributes will be
 * repeated here.
 * </p>
 */
public class UIScene extends NWN2GUIObject {
		
	private String name;

	/**
	 * his determines where scenes fall in the render order, in terms of which scenes should cover up other scenes.<br/>
	 * The valid arguments to this attribute in order of highest priority to lowest are:<br/>
	 * SCENE_TOOLTIP - Appears on top of any other GUI<br/>
	 * SCENE_GLOBAL - Used for messageboxes generally.<br/>
	 * SCENE_FE_FULLSCREEN - Pre-game full screen GUIs<br/>
	 * SCENE_INGAME_FULLSCREEN - Full screen GUIs within the game.<br/>
	 * SCENE_INGAME_SYSTEM - Escape menu and options screens.<br/>
	 * SCENE_SCRIPT - GUIs brought up by script<br/>
	 * SCENE_NWN1_DIALOG - The NWN1 style dialog box<br/>
	 * SCENE_INGAME_MENU - The popup player menu<br/>
	 * SCENE_INGAME - Most of the windows in-game<br/>
	 * SCENE_INGAME_TARGET - The target box<br/>
	 */
	private String priority;
	
	/**
	 * The time between updates, in seconds. If no value is specified, the scene will get an update every frame.
	 */
	private Float updateRate;
	
	/**
	 * This determines if the entire scene is draggable. This is different from dragging a single UI Object within a scene as it moves the entire window. The default setting is false.
	 */
	private Boolean draggable = false;
	
	private Integer dragRegionX;
	private Integer dragregionY;
	private Integer dragregionWidth;
	private Integer dragregionHeight;
	
	/**
	 * Determines if this scene can be resized by dragging the edges of it. This is used in the chat window for resizing, for example. The default setting is false.
	 */
	private Boolean dragresizable = false;
	
	/**
	 * This attribute defines the size, in pixels, of the border of the scene that can be clicked on in order to resize the window.
	 */
	private int dragResizeBorder;
	
	/**
	 * If set to false, then mouse clicks should pass right through the background of this scene. Useful for semi-transparent overlays and other situations where it is expected that the user be able to click through the UI Object. The default setting is true.
	 */
	private Boolean captureMouseClicks = true;
	
	/**
	 * This is pretty much a redundant attribute. It does the exact same thing as capturemouseclicks.
	 */
	private Boolean captureMouseEvents;
	
	/**
	 * This attribute can be true or false. By default it is false. It controls what happens to this scene when the resolution of the game changes. Scenes that have this attribute set to 'true' will not have their origins moved but their dimenions will be adjusted to the new resolution. Scenes that have this attribute set to 'false' will not be resized when the resolution changes but their origin will change to stay roughly in the same part of the screen that the window appeared in before.
	 */
	private Boolean fullscreen;
	
	private Width width;
	private Height height;	
	private XPosition x = new XPosition(0);
	private YPosition y = new YPosition(0);
	
	/**
	 * This is the amount of time in seconds a scene should be up before it is automatically removed from view and unloaded from memory. If 0 or not set, then the scene will never be automatically removed from view. 
	 */
	private Float expireTime;
	
	/**
	 * This is the amount of time in seconds a scene should not be visible before it should be unloaded from memory. This can be used to unload scenes that were shown once that will not be needed again anytime soon. The next time the scene is requested, it will be loaded from disk. This makes it possible to sometimes do quick testing of GUI changes by setting a short idleexpiretime, closing the window, then reopening it to see what it looks like with the new changes on disk.
	 */
	private Float idleexpiretime;
	
	/**
	 * This attribute is only of interest in message-box style GUI screens. If enabled, the engine will attempt to automatically position the text, the 'okay', and the 'cancel' button in a classic message box layout. If left false, then the engine will not attempt to arrange any of the contents of the messagebox when the message box is requested. It is false by default.
	 */
	private Boolean autolayout = false;
	
	/**
	 * 	If set to true, then this UI scene will block access to the game or any underlying GUI screens until the window is closed. It is false by default. Note that scripts that bring up GUIs can override this parameter based on the parameters passed in to the script function.
	 */
	private Boolean modal = false;

	/**
	 * The time in seconds this scene should take to fade in completely when opened.
	 */
	private Float fadeIn;	

	/**
	 * The time in seconds this scene should take to fade out completely when closed.
	 */
	private Float fadeOut;	
	
	/**
	 * In order for a server script to have any control over this GUI at all, this attribute must exist in the UIScene tag and must be set to true. It is false by default. If false, than all script functions that attempt to manipulate a user's GUI will fail.
	 */
	private Boolean scriptloadable  = false;	

	/**
	 * If this attribute is set true, then use of the backout key ('Esc' key by default) will cause this window to close. The backout key follows a defined set of logic for determining what to do when it is used. First it closes any open 'windows' in the reverse order that they were opened (Most recent window opened is closed first). If there are no windows to close, it clears the player's target. If the player has nothing targetted, it brings up the in-game options screen.
	 */
	private Boolean backoutkey;
		
	private List<Callback>onCreate;
	private List<Callback>onDestory;
	private List<Callback>onAdd;
	private List<Callback>onRemove;
	private List<Callback>onBackout;
	private List<Callback>onUpdate;
	private List<Callback>onUnhandledMouseClick;
	
	public UIScene(NWN2GUIObject parent) {
		super(parent);
	}
	
	
	/**
	 * Used to get the scene name
	 * @return The scene name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Used to set the scene name
	 * @param name The scene name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Float getUpdateRate() {
		return updateRate;
	}
	public void setUpdateRate(Float updateRate) {
		this.updateRate = updateRate;
	}
	public Boolean getDraggable() {
		return draggable;
	}
	public void setDraggable(Boolean draggable) {
		this.draggable = draggable;
	}
	public Integer getDragRegionX() {
		return dragRegionX;
	}
	public void setDragRegionX(Integer dragRegionX) {
		this.dragRegionX = dragRegionX;
	}
	public Integer getDragregionY() {
		return dragregionY;
	}
	public void setDragregionY(Integer dragregionY) {
		this.dragregionY = dragregionY;
	}
	public Integer getDragregionWidth() {
		return dragregionWidth;
	}
	public void setDragregionWidth(Integer dragregionWidth) {
		this.dragregionWidth = dragregionWidth;
	}
	public Integer getDragregionHeight() {
		return dragregionHeight;
	}
	public void setDragregionHeight(Integer dragregionHeight) {
		this.dragregionHeight = dragregionHeight;
	}
	public Boolean getDragresizable() {
		return dragresizable;
	}
	public void setDragresizable(Boolean dragresizable) {
		this.dragresizable = dragresizable;
	}
	public int getDragResizeBorder() {
		return dragResizeBorder;
	}
	public void setDragResizeBorder(int dragResizeBorder) {
		this.dragResizeBorder = dragResizeBorder;
	}
	public Boolean getCaptureMouseClicks() {
		return captureMouseClicks;
	}
	public void setCaptureMouseClicks(Boolean captureMouseClicks) {
		this.captureMouseClicks = captureMouseClicks;
	}
	public Boolean getCaptureMouseEvents() {
		return captureMouseEvents;
	}
	public void setCaptureMouseEvents(Boolean captureMouseEvents) {
		this.captureMouseEvents = captureMouseEvents;
	}
	public Boolean getFullscreen() {
		return fullscreen;
	}
	public void setFullscreen(Boolean fullscreen) {
		this.fullscreen = fullscreen;
	}
	
	/** 
	 * Used to get the width of the scene in pixels. The value SCREEN_WIDTH can also be 
	 * returned to make this scene always match the width of the full screen.
	 * @return The scene width
	 */
	public Width getWidth() {
		return width;
	}
	
	/** 
	 * Used to set the width of the scene in pixels. The value SCREEN_WIDTH can also be 
	 * used to make this scene always match the width of the full screen.
	 * @param width The scene width
	 */
	public void setWidth(Width width) {
		this.width = width;
	}
	
	/** 
	 * Used to get the height of the scene in pixels. The value SCREEN_HEIGHT can also be 
	 * returned to make this scene always match the height of the full screen.
	 * @return The scene height
	 */
	public Height getHeight() {
		return height;
	}
	
	/** 
	 * Used to set the height of the scene in pixels. The value SCREEN_HEIGHT can also be 
	 * used to make this scene always match the height of the full screen.
	 * @param height The scene height
	 */
	public void setHeight(Height height) {
		this.height = height;
	}
	
	/**
	 * Used to get the X origin for the scene. The value can either be a integer, ALIGN_CENTER, ALIGN_LEFT, ALIGN_RIGHT.
	 * If the GUI XML file did not specify a X origin, then "0" is returned.
	 * @return The X origin of the scene 
	 */			
	public XPosition getX() {
		return x;
	}
	
	/**
	 * Used to set the X origin of the scene. The value can either be a integer, ALIGN_CENTER, ALIGN_LEFT, ALIGN_RIGHT. 
	 * @param x The X origin of the scene 
	 */
	public void setX(XPosition x) {
		this.x = x;
	}
	
	/**
	 * Used to get the Y origin for the scene. The value can either be a integer, ALIGN_CENTER, ALIGN_LEFT, ALIGN_RIGHT.
	 * If the GUI XML file did not specify a Y origin, then "0" is returned.
	 * @return The Y origin of the scene 
	 */
	public YPosition getY() {	
		return y;
	}
	
	/**
	 * Used to set the Y origin of the scene. The value can either be a integer, ALIGN_CENTER, ALIGN_LEFT, ALIGN_RIGHT. 
	 * @param y The Y origin of the scene 
	 */
	public void setY(YPosition y) {
		this.y = y;
	}
	
	public Float getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Float expireTime) {
		this.expireTime = expireTime;
	}
	public Float getIdleexpiretime() {
		return idleexpiretime;
	}
	public void setIdleexpiretime(Float idleexpiretime) {
		this.idleexpiretime = idleexpiretime;
	}
	public Boolean getAutolayout() {
		return autolayout;
	}
	public void setAutolayout(Boolean autolayout) {
		this.autolayout = autolayout;
	}
	public Boolean getModal() {
		return modal;
	}
	public void setModal(Boolean modal) {
		this.modal = modal;
	}
	public Float getFadeIn() {
		return fadeIn;
	}
	public void setFadeIn(Float fadeIn) {
		this.fadeIn = fadeIn;
	}
	public Float getFadeOut() {
		return fadeOut;
	}
	public void setFadeOut(Float fadeOut) {
		this.fadeOut = fadeOut;
	}
	
	public Boolean getScriptloadable() {
		return scriptloadable;
	}
	
	public void setScriptloadable(Boolean scriptloadable) {
		this.scriptloadable = scriptloadable;
	}
	
	public Boolean getBackoutkey() {
		return backoutkey;
	}
	
	public void setBackoutkey(Boolean backoutkey) {
		this.backoutkey = backoutkey;
	}
	
	public void addOnUpdate(Callback callback) {
		if (onUpdate==null) {
			onUpdate= new ArrayList<Callback>();			
		}
		onUpdate.add(callback);
	}
	
	public List<Callback> getOnUpdate() {
		return  onUpdate;
	}

	public void addOnCreate(Callback callback) {
		if (onCreate==null) {
			onCreate= new ArrayList<Callback>();			
		}
		onCreate.add(callback);
	}
	
	public List<Callback> getOnCreate() {
		return  onCreate;
	}

	
	public void addOnDestory(Callback callback) {
		if (onDestory==null) {
			onDestory= new ArrayList<Callback>();			
		}
		onDestory.add(callback);
	}
	
	public List<Callback> getOnDestory() {
		return  onDestory;
	}

	public void addOnAdd(Callback callback) {
		if (onAdd==null) {
			onAdd= new ArrayList<Callback>();			
		}
		onAdd.add(callback);
	}
	
	public List<Callback> getOnAdd() {
		return  onAdd;
	}

	public void addOnRemove(Callback callback) {
		if (onRemove==null) {
			onRemove= new ArrayList<Callback>();			
		}
		onRemove.add(callback);
	}
	
	public List<Callback> getOnRemove() {
		return  onRemove;
	}

	
	public void addOnBackout(Callback callback) {
		if (onBackout==null) {
			onBackout= new ArrayList<Callback>();			
		}
		onBackout.add(callback);
	}
	
	public List<Callback> getonBackout() {
		return  onBackout;
	}
		
	public void addOnUnhandledMouseClick(Callback callback) {
		if (onUnhandledMouseClick==null) {
			onUnhandledMouseClick= new ArrayList<Callback>();			
		}
		onUnhandledMouseClick.add(callback);
	}
	
	public List<Callback> getOnUnhandledMouseClick() {
		return  onUnhandledMouseClick;
	}
	
	
}
