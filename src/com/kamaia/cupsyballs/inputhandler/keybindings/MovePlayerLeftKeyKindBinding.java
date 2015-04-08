package com.kamaia.cupsyballs.inputhandler.keybindings;

import com.googlecode.lanterna.input.Key;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.gamekeybindinginterface.GameKeyKindBindingInterface;
import com.kamaia.cupsyballs.level.Level;
import com.kamaia.cupsyballs.pieces.Players.Player;
import com.kamaia.cupsyballs.states.Game;

/**
 * Created by Krystal on 4/6/2015.
 */
public class MovePlayerLeftKeyKindBinding implements GameKeyKindBindingInterface {
	private Key.Kind key = Key.Kind.ArrowLeft;

	@Override

	public void execute(GameWindow window, Game sendingState) {
		if (sendingState != null) {
			if (checkPlayerBounds(sendingState.getPlayer(), sendingState.getLevel())) {
				sendingState.getPlayer().moveLeft();
			}
		}
	}

	private boolean checkPlayerBounds(Player player, Level level) {
		if (player.getPosX() <= 0){
			return false;
		}
		else{
			return true;
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
		return "Move Player Left";
	}
}
