package com.kamaia.cupsyballs.level.pieces.obstacles.effects;

import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPlayer;
import com.kamaia.cupsyballs.pieces.Players.Player;

/**
 * Created by Krystal on 4/8/2015.
 */
public class PlayerVerticalSlowObstacleEffect implements ObstacleEffectInterface {
	float oldSpeed;
	private boolean applied;

	@Override
	public void execute(Player target) {

		oldSpeed = target.getSpeed();
		target.addEffect(this, 10);

	}

	@Override
	public String getEffectname() {
		return "Slow Player's Vertical Velocity";
	}

	@Override
	public void applyEffect(AbstractPlayer player) {
		if (!applied) {
			toggleApplied();
		}
		player.setSpeed(player.getSpeed() / 2);
	}

	@Override
	public void removeEffect(AbstractPlayer target) {
		target.setSpeed(oldSpeed);
	}

	@Override
	public void toggleApplied() {
		applied = !applied;
	}

	@Override
	public boolean isApplied() {
		return applied;
	}
}
