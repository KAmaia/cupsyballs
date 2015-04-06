package com.kamaia.cupsyballs.gui.menus.menuItems.interfaces;

import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;


/**
 * The Interface responsible for menuItems.
 */

public interface MenuItemInterface {
	/**
	 * @return the items name in string form.
	 */
	public String getItemString();

	/**
	 *
	 * @param window the window on which the menu item is going to act.
	 * @param state the state that has requested execution.
	 */
	public void execute(GameWindow window, AbstractState state);

	/**
	 * Sets the color of the currently selected menu Item...(Kinda)
	 */
	public void highlight();

	/**
	 * returns the colors to normal.
	 */
	public void deHighlight();

	/**
	 * Yeah, I'm not even going to bother.
	 * @return
	 */
	public Color getFgColor();
	public Color getBgColor();
}
