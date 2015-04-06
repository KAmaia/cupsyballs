package com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.Game;

/**
 * Created by Krystal on 4/6/2015.
 */
public interface GameKeyCharBindingInterface {
	public void execute(GameWindow window, Game sendingState);

	public char getKey();

	public void setKey(Key newKey);

	public String getBindingName();
}
