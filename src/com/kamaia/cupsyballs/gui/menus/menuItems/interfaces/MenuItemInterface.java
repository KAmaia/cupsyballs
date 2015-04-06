package com.kamaia.cupsyballs.gui.menus.menuItems.interfaces;

import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;



public interface MenuItemInterface {
	public String getItemString();
	public void execute(GameWindow window, AbstractState state);
	public void highlight();
	public void deHighlight();
	public Color getFgColor();
	public Color getBgColor();
}
