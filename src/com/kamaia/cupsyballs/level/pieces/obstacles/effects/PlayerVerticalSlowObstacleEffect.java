package com.kamaia.cupsyballs.level.pieces.obstacles.effects;

import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;
import com.kamaia.cupsyballs.players.abstracts.AbstractPlayer;

/**
 * @author Krystal Amaia
 * @see com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface
 */
public class PlayerVerticalSlowObstacleEffect implements ObstacleEffectInterface {
	float oldSpeed;
	private boolean applied;
	private int ticksToApply;

	public PlayerVerticalSlowObstacleEffect(int ticksToApply){
		this.ticksToApply = ticksToApply;
	}
	@Override
	public void execute(AbstractPlayer target) {
		if(!applied) {
			oldSpeed = target.getSpeed();
			target.addEffect(this, ticksToApply);
		}
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
		player.setSpeed(player.getSpeed() *.90f);
	}

	@Override
	public void removeEffect(AbstractPlayer target) {
		target.setSpeed(oldSpeed);
		toggleApplied();
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
