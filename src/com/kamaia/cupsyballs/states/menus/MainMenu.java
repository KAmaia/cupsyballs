package com.kamaia.cupsyballs.states.menus;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;
import com.kamaia.cupsyballs.states.menus.menuItems.ExitGameMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.HelpMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.HighScoresMenuItem;
import com.kamaia.cupsyballs.states.menus.menuItems.NewGameMenuItem;

/**
 * Anyone remember me saying that my state classes have very little code in them?  Well here's proof.
 * adds the menuItems to the menu.  (Exactly the same for all the other menus. (Procedure wise, not content.)
 * So I'm not going to bother with more than, "See MainMenu.Java"
 */
public class MainMenu extends AbstractMenu {

	public MainMenu(GameWindow gw) {
		//really all we do in the menu constructors is add the menu items.  AbstractMenu handles the rest.
		super(gw);
		menuItems.add(new NewGameMenuItem());
		menuItems.add(new HighScoresMenuItem());
		menuItems.add(new HelpMenuItem());
		menuItems.add(new ExitGameMenuItem());


	}

}
