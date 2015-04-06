package com.kamaia.cupsyballs.inputhandler;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyCharBindingInterface;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.inputhandler.keybindings.*;
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

	private ArrayList<GameKeyKindBindingInterface> gameKeyKindBindings = new ArrayList<GameKeyKindBindingInterface>();
	private ArrayList<GameKeyCharBindingInterface> gameKeyCharBindings = new ArrayList<GameKeyCharBindingInterface>();

	private GameWindow   gameWindow;

	/**
	 * @param window the main game window.
	 */
	public InputHandler(GameWindow window) {

		gameWindow = window;

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
	 * <p/>
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
		switch (k.getKind()) {
			case ArrowDown:
				sendingState.selectNextMenuItem(1);
				break;
			case ArrowUp:
				sendingState.selectNextMenuItem(-1);
				break;
			case Enter:
				sendingState.executeCurrentItem(gameWindow, sendingState);
				break;

			default:
				break;
		}
		//highlight our menu items.
	}

	/**
	 * This Function was Deleted.  Fuck You, That's Why!
	 */


}
