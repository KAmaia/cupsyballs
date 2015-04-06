package com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.Game;

/**
 * @author Krystal Amaia
 *         4/6/2015.
 *         This interface exists to map keys to actions.
 */
public interface GameKeyKindBindingInterface {
	public void execute(GameWindow window, Game sendingState);

	public Key.Kind getKey();

	public void setKey(Key.Kind keyKind);

	public String getBindingName();

}
