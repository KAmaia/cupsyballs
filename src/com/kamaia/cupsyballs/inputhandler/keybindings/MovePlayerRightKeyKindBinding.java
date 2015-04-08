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
public class MovePlayerRightKeyKindBinding implements GameKeyKindBindingInterface {
	private Key.Kind key = Key.Kind.ArrowRight;

	@Override
	public void execute(GameWindow window, Game sendingState) {
		if(checkPlayerBounds(sendingState.getPlayer(), sendingState.getLevel())) {
			sendingState.getPlayer().moveRight();
		}
	}

	private boolean checkPlayerBounds(Player player, Level level) {
		return !(player.getPosX() >= level.getSizeX() - 1 || player.getPosY() <= 2);

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
		return "Move Player Right";
	}
}
