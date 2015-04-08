package com.kamaia.cupsyballs.inputhandler.keybindings;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyCharBindingInterface;
import com.kamaia.cupsyballs.states.Game;

/**
 * Created by Krystal on 4/6/2015.
 */
public class ActivatePowerUpKeyCharBinding implements GameKeyCharBindingInterface {
	private char key = 'p';

	@Override
	public void execute(GameWindow window, Game sendingState) {

	}

	@Override
	public char getKey() {
		return key;
	}

	@Override
	public void setKey(Key newKey) {
		key = newKey.getCharacter();

	}

	@Override
	public String getBindingName() {
		return "Activate PowerUp";
	}
}
