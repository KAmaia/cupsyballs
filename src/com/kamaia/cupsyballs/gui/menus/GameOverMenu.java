package com.kamaia.cupsyballs.gui.menus;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.ExitGameMenuItem;
import com.kamaia.cupsyballs.gui.menus.menuItems.HelpMenuItem;
import com.kamaia.cupsyballs.gui.menus.menuItems.NewGameMenuItem;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;

/**
 * See MainMenu.Java
 */

public class GameOverMenu extends AbstractMenu {

	public GameOverMenu(GameWindow window) {

		super(window);
		// TODO Auto-generated constructor stub
		menuItems.add(new NewGameMenuItem());
		menuItems.add(new HelpMenuItem());
		menuItems.add(new ExitGameMenuItem());

	}
}
