package com.kamaia.cupsyballs.states.menus;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;
import com.kamaia.cupsyballs.states.menus.menuItems.ExitGameMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.HelpMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.HighScoresMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.NewGameMenuItem;

/**
 * See MainMenu.Java
 */

public class GameOverMenu extends AbstractMenu {

	public GameOverMenu(GameWindow window) {

		super(window);
		// TODO Auto-generated constructor stub
		menuItems.add(new NewGameMenuItem());
		menuItems.add(new HelpMenuItem());
		menuItems.add(new HighScoresMenuItem());
		menuItems.add(new ExitGameMenuItem());

	}
}
