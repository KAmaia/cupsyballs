package com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.Game;

/**
 * @author Krystal Amaia
 * This interface binds keys to game actions.
 */
public interface GameKeyKindBindingInterface {
	/**
	 * Executes the selected keybinding
	 * @param window the window that asked for the keybinding.
	 * @param sendingState I don't think this is even needed anymore, but I'm leaving it here just in case.
	 */
	public void execute(GameWindow window, Game sendingState);

	/**
	 * Returns the key that was pressed.
	 * @return Key.Kind
	 */
	public Key.Kind getKey();

	/**
	 * @WIP
	 * Used to Remap KeyBindings.  This Feature is not yet implemented.
	 * @param keyKind the new key to bind to.
	 */
	public void setKey(Key.Kind keyKind);

	/**
	 * Gets the name of the keybinding.
	 * @return the name of the current keybinding as a String.
	 */
	public String getBindingName();

}
