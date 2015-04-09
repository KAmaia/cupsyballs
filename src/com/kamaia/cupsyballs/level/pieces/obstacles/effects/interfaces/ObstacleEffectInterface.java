package com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces;

import com.kamaia.cupsyballs.pieces.abstracts.AbstractPlayer;

/**
 * @author Krystal Amaia
 *
 */
public interface ObstacleEffectInterface {
	/**
	 * Adds the effect to target's ActiveEffect List.
	 * @param target target of the obstacle effect.
	 */
	public void execute(AbstractPlayer target);

	/**
	 * Gets the name of the effect.
	 * @return The name of the effect as a String.
	 */
	public String getEffectname();

	/**
	 * Applies the effect to the player.
	 * @param player target of the effect to apply
	 */
	void applyEffect(AbstractPlayer player);

	/**
	 * Removes the effect from the target player
	 * @param player target of the effect to remove
	 */
	void removeEffect(AbstractPlayer player);

	/**
	 * Toggles whether or not the effect is applied.
	 */
	void toggleApplied();

	/**
	 * Is the effect Applied?
	 * @return whether or not the effect is applied.
	 */
	boolean isApplied();
}
