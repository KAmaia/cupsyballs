package com.kamaia.cupsyballs.states.menus;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;
import com.kamaia.cupsyballs.states.menus.menuItems.ExitGameMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.HelpMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.NewGameMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.ResumeGameMenuItem;

/**
 * See MainMenu.Java
 */

public class InGameMenu extends AbstractMenu {

	public InGameMenu(GameWindow window, AbstractState sendingState) {

		super(window);
		// TODO Auto-generated constructor stub
		menuItems.add(new NewGameMenuItem());
		menuItems.add(new ResumeGameMenuItem());
		menuItems.add(new HelpMenuItem());
		menuItems.add(new ExitGameMenuItem());

	}
}
