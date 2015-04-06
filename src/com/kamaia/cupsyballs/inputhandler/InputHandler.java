package com.kamaia.cupsyballs.inputhandler;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.InGameMenu;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;
import com.kamaia.cupsyballs.states.Game;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;

import java.util.ArrayList;

/**
 * OH DEAR GOD! I don't want to comment this one!!!! InputHandler is a massive mess but it works as planned, and so I
 * don't think I'm going to change it too much.
 * <p>
 * Inputhandler handles input for the different game/menu states based on an instanceof case.
 *
 */
public class InputHandler {
	//this class really needs something.

	private int menuIndex = 0;
	private ArrayList<MenuItemInterface> menuItems;
	private Screen       screen;
	private GameWindow   gameWindow;
	private TerminalSize ts;

	/**
	 * @param window the main game window.
	 */
	public InputHandler(GameWindow window) {

		gameWindow = window;
		screen = gameWindow.getScreen();
		ts = screen.getTerminalSize();

	}

	/**
	 * This method handles input for various menus, and the game itself.  The sending state identifies iteslf when it calls
	 * into inputHandler and Key k can never be null.
	 *
	 * @param sendingState the abstract state that has asked inputHandler to handle input.
	 * @param k            the key code that input handler is handling.
	 */
	public void handleInput(AbstractState sendingState, Key k) {


		if (sendingState instanceof Game) {
			//if the sending state is of the Game sub-class.
			// handle Game input
			switch (k.getKind()) {
				case Escape:
					//some really fucking ugly casts, though they work.
					//when the escape key is pressed during the game, pause the game state,
					//launch the in game menu.
					((Game) sendingState).pauseResume();
					InGameMenu igm = new InGameMenu(gameWindow, sendingState);
					igm.run();
					//after the in game menu finishes, resume the original sending state.
					((Game) sendingState).pauseResume();
					break;

				case ArrowLeft:
					//more ugly casts that  move the ball to the left
					if (((Game) sendingState).getPlayer().getPosX() > 0) {
						((Game) sendingState).getPlayer().moveLeft();
						break;
					}
				case ArrowRight:
					// even more ugly casts that move the ball right
					if (((Game) sendingState).getPlayer().getPosX() < ts
						   .getColumns() - 1) {
						((Game) sendingState).getPlayer().moveRight();
						break;
					}
				case ArrowDown:
					// one more ugly cast here, accelerate the ball downwards.
					((Game) sendingState).getPlayer().moveDown();
					break;

				default:
					break;
			}
		}
		else if (sendingState instanceof AbstractMenu) {
			// handle menu input
			//pull the menu items from the sending menu.
			menuItems = ((AbstractMenu) sendingState).getMenuItems();
			//preset our previous and current menu items.
			MenuItemInterface curMenuItem = menuItems.get(menuIndex);
			MenuItemInterface preMenuItem = menuItems.get(menuItems.size() - 1);

			switch (k.getKind()) {
				case ArrowUp:
					if (menuIndex > 0) {
						menuIndex--;
						//if we're not at the first entry in the list
						//reduce our index by one, and set our current menu item to that index,
						//and our previous menu item to the next one in the list.
						preMenuItem = selectMenuItem(menuIndex + 1);
						curMenuItem = selectMenuItem(menuIndex);
					}
					break;
				case ArrowDown:
					//BUG CHECK: Index loops past the last item in the list.
					if (menuIndex <= menuItems.size() - 2) {
						menuIndex++;

						//if we're not at the last entry in the list
						//increment our index by one, and set our current menu item to that index,
						//and our previous menu item to the previous one in the list.
						preMenuItem = selectMenuItem(menuIndex - 1);
						curMenuItem = selectMenuItem(menuIndex);
					}
					break;
				case Enter:
					//our execution method in the menuItemInterface
					curMenuItem.execute(gameWindow, sendingState);
					break;
				default:
					break;
			}
			//highlight our menu items.
			curMenuItem.highlight();
			preMenuItem.deHighlight();
		}
	}

	/**
	 * This function will be depreciated in later releases.
	 *
	 * @param index index of the requested menuItem.
	 * @return the menuItem at selected index.
	 */
	private MenuItemInterface selectMenuItem(int index) {

		return menuItems.get(index);
	}
}
