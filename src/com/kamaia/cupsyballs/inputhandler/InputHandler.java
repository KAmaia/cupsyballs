package com.kamaia.cupsyballs.inputhandler;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyCharBindingInterface;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.inputhandler.keybindings.*;
import com.kamaia.cupsyballs.inputhandler.menukeykindbindinginterface.MenuKeyKindBindingInterface;
import com.kamaia.cupsyballs.states.Game;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;

import java.util.ArrayList;

/**
 * OH DEAR GOD! I don't want to comment this one!!!! InputHandler is a massive mess but it works as planned, and so I
 * don't think I'm going to change it too much.
 * <p/>
 * Inputhandler handles input for the different game/menu states based on an instanceof case.
 */
public class InputHandler {
	//this class really needs something.

	private int menuIndex = 0;
	private ArrayList<MenuItemInterface> menuItems;
	private ArrayList<GameKeyKindBindingInterface> gameKeyKindBindings = new ArrayList<GameKeyKindBindingInterface>();
	private ArrayList<GameKeyCharBindingInterface> gameKeyCharBindings = new ArrayList<GameKeyCharBindingInterface>();
	private ArrayList<MenuKeyKindBindingInterface> menuKeyKindBindings = new ArrayList<MenuKeyKindBindingInterface>();

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

		populateBindings();
	}

	private void populateBindings() {
		//Add Our KeyKindBindings to the ArrayList;
		gameKeyKindBindings.add(new MovePlayerLeftKeyKindBinding());
		gameKeyKindBindings.add(new MovePlayerRightKeyKindBinding());
		gameKeyKindBindings.add(new MovePlayerDownKeyKindBinding());
		gameKeyKindBindings.add(new OpenInGameMenuKeyKindBinding());

		//Add Our KeyCharBindings to the ArrayList;
		gameKeyCharBindings.add(new ActivatePowerUpKeyCharBinding());
	}

	/**
	 * This method handles input for various menus, and the game itself.  The sending state identifies iteslf when it calls
	 * into inputHandler and Key k can never be null.
	 *<p>
	 * After a small refactor this class looks much nicer.
	 *
	 * @param sendingState the abstract state that has asked inputHandler to handle input.
	 * @param k            the key code that input handler is handling.
	 */
	public void handleInput(Game sendingState, Key k) {
		if (!k.getKind().equals(Key.Kind.NormalKey)) {
			for (GameKeyKindBindingInterface gkkbi : gameKeyKindBindings) {
				if (k.getKind().equals(gkkbi.getKey())) {
					gkkbi.execute(gameWindow, sendingState);
				}
			}
		}
		else if (k.getKind().equals(Key.Kind.NormalKey)) {
			for (GameKeyCharBindingInterface gkcbi : gameKeyCharBindings) {
				if (k.getCharacter() == (gkcbi.getKey())) {

					gkcbi.execute(gameWindow, sendingState);
				}

			}
		}

	}

	public void handleInput(AbstractMenu sendingState, Key k) {

		// handle menu input
		//pull the menu items from the sending menu.
		menuItems = sendingState.getMenuItems();
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
