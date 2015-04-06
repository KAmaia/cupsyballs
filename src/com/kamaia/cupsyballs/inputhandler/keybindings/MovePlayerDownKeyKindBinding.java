package com.kamaia.cupsyballs.inputhandler.keybindings;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.states.Game;

/**
 * Created by Krystal on 4/6/2015.
 */
public class MovePlayerDownKeyKindBinding implements GameKeyKindBindingInterface {
	private Key.Kind key = Key.Kind.ArrowDown;

	@Override
	public void execute(GameWindow window, Game sendingState) {
		if (sendingState != null) {
			sendingState.getPlayer().moveDown();
		}
	}

	@Override
	public Key.Kind getKey() {
		return key;
	}

	@Override
	public void setKey(Key.Kind keyKind) {
		key = keyKind;
	}

	@Override
	public String getBindingName() {
		return "Move Player Down";
	}
}
