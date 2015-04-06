package com.kamaia.cupsyballs.gui.menus;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.ExitGameMenuItem;
import com.kamaia.cupsyballs.gui.menus.menuItems.HelpMenuItem;
import com.kamaia.cupsyballs.gui.menus.menuItems.HighScoresMenuItem;
import com.kamaia.cupsyballs.gui.menus.menuItems.NewGameMenuItem;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;

public class MainMenu extends AbstractMenu {

	public MainMenu(GameWindow gw) {

		super(gw);
		// TODO Auto-generated constructor stub
		menuItems.add(new NewGameMenuItem());
		menuItems.add(new HighScoresMenuItem());
		menuItems.add(new HelpMenuItem());
		menuItems.add(new ExitGameMenuItem());
		
		
	}
	
}
