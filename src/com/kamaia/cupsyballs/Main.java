package com.kamaia.cupsyballs;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.MainMenu;

public class Main {


	public static void main(String[] args) {
		//Seriously, how the fuck am I supposed to comment this?
		//There is like NOTHING HERE!

		//Create A New Game Window
		GameWindow gw = new GameWindow(80, 40);

		//Create a new Main Menu, and pass it the game window to work with
		MainMenu mm = new MainMenu(gw);

		//see eminem run
		mm.run();

	}

}
