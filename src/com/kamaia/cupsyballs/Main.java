package com.kamaia.cupsyballs;

import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.MainMenu;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow gw = new GameWindow(80, 40);
		MainMenu mm = new MainMenu(gw);
		System.out.print("Game Running at: " + System.currentTimeMillis());
		mm.run();
		
	}

}
