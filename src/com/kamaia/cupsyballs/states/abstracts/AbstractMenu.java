package com.kamaia.cupsyballs.states.abstracts;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.menus.menuItems.interfaces.MenuItemInterface;

import java.util.ArrayList;

public abstract class AbstractMenu extends AbstractState {
	/**
	 * menuItems arrayList of menuItemInterfaces;
	 * menuIndex should really probably move.
	 */
	protected final ArrayList<MenuItemInterface> menuItems = new ArrayList<MenuItemInterface>();
	private         int                          menuIndex = 0;

	protected AbstractMenu(GameWindow window) {

		super(window);
	}

	/**
	 *  Starts the game loop.
	 */
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

	/**
	 * Updates the game screen each tick.  If the game window gets resized, resizes the virtual terminal to fit.
	 */
	protected void updateScreen() {

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

	/**
	 * Draws the Menu Text centered on the screen.
	 *
	 */
	private void drawMenuItems() {

		int menuItemPosition = (ts.getRows() - menuItems.size()) / 2;
		for (MenuItemInterface mii : menuItems) {
			int centerXPos = (ts.getColumns() - mii.getItemString().length()) / 2;
			gameScreen.putString(centerXPos, menuItemPosition,
			                     mii.getItemString(), mii.getFgColor(),
			                     mii.getBgColor());
			menuItemPosition += 1;
		}
	}

	/**
	 * Selects the next menu item and highlights it.
	 *
	 * @param mod if positive 1 moves up the list, if -1 moves down the list
	 */

	public void selectNextMenuItem(int mod) {

		if (mod == -1) {
			if (menuIndex + mod >= 0) {
				menuIndex -= 1;
			}
			else {
				menuIndex = 0;
			}
		}
		else if (mod == 1) {
			if (menuIndex + mod <= menuItems.size() - 1) {
				menuIndex += 1;
			}
			else {
				menuIndex = menuItems.size() - 1;
			}
		}
		MenuItemInterface selected = menuItems.get(menuIndex);
		for (MenuItemInterface mii : menuItems) {
			if (!mii.equals(selected)) {
				mii.deHighlight();
			}
			else {
				mii.highlight();
			}
		}
	}

	/**
	 * executes the currently selected menu item on the game window.
	 *
	 * @param window the window on which the item is being executed
	 * @param state the (abstract)state requesting execution.
	 */
	public void executeCurrentItem(GameWindow window, AbstractState state) {
		menuItems.get(menuIndex).execute(window, state);
	}
}
