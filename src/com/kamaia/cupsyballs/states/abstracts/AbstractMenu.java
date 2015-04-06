package com.kamaia.cupsyballs.states.abstracts;

import java.util.ArrayList;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;

public abstract class AbstractMenu extends AbstractState {

	int menuIndex = 0;
	protected ArrayList<MenuItemInterface> menuItems = new ArrayList<MenuItemInterface>();
	
	public AbstractMenu(GameWindow window) {
		super(window);
	}
	
	@Override
	public void run() {
		gameScreen.startScreen();
		menuItems.get(0).highlight();
		while (running) {
			Key k = gameScreen.readInput();
			if (k != null) {
				inputhandler.handleInput(this, k);
			}
			updateScreen();
		}
	}

	private void updateScreen() {

		if (gameScreen.updateScreenSize()) {
			gameScreen.clear();
			drawMenuItems();
			gameScreen.refresh();
		}
		else {
			gameScreen.clear();
			drawMenuItems();
			gameScreen.refresh();
		}
	}
	
	public ArrayList<MenuItemInterface> getMenuItems(){
		return menuItems;
	}
	
	private void handleInput(Key k) {

		System.out.println(menuItems.size());
		
		System.out.println("Index:\t" + menuIndex);
	}

	

	private void drawMenuItems() {

		// TODO Auto-generated method stub
		int menuItemPosition = (ts.getRows() - menuItems.size()) / 2;
		for (MenuItemInterface mii : menuItems) {
			int centerXPos = (ts.getColumns() - mii.getItemString().length()) / 2;
			gameScreen.putString(centerXPos, menuItemPosition,
					mii.getItemString(), mii.getFgColor(),
					mii.getBgColor());
			menuItemPosition += 1;
		}
	}
}
