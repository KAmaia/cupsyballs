package com.kamaia.cupsyballs.inputhandler.keybindings;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.states.Game;
import com.kamaia.cupsyballs.states.menus.InGameMenu;

/**
 * @author Krystal Amaia
 * @see com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface
 */
public class OpenInGameMenuKeyKindBinding implements GameKeyKindBindingInterface {
	private Key.Kind key = Key.Kind.Escape;

	@Override
	public void execute(GameWindow window, Game sendingState) {
		sendingState.pauseResume();
		InGameMenu igm = new InGameMenu(window);
		igm.run();
		sendingState.pauseResume();
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
		return "Open In Game Menu";
	}
}
