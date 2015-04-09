package com.kamaia.cupsyballs.level.pieces.obstacles.effects;

import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;
import com.kamaia.cupsyballs.pieces.abstracts.AbstractPlayer;

/**
 * @author Krystal Amaia
 * @see com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface
 */
public class PlayerVerticalSlowObstacleEffect implements ObstacleEffectInterface {
	float oldSpeed;
	private boolean applied;

	@Override
	public void execute(AbstractPlayer target) {

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
