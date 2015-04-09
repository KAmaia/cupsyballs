package com.kamaia.cupsyballs.inputhandler.keybindings;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.players.Players.Player;
import com.kamaia.cupsyballs.states.Game;

/**
 * @author Krystal Amaia
 * @see com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface
 */
public class MovePlayerLeftKeyKindBinding implements GameKeyKindBindingInterface {
	private Key.Kind key = Key.Kind.ArrowLeft;

	@Override

	public void execute(GameWindow window, Game sendingState) {
		if (sendingState != null) {
			if (checkPlayerBounds(sendingState.getPlayer())) {
				sendingState.getPlayer().moveLeft();
			}
		}
	}

	private boolean checkPlayerBounds(Player player) {
		return !(player.getPosX() <= 0 || player.getPosY() <= 2);

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
		return "Move Player Left";
	}
}
