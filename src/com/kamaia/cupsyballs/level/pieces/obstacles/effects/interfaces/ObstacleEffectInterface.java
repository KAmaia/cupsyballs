package com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces;

import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPlayer;
import com.kamaia.cupsyballs.pieces.Players.Player;

/**
 * Created by Krystal on 4/8/2015.
 */
public interface ObstacleEffectInterface {
	public void execute(Player target);
	public String getEffectname();

	void applyEffect(AbstractPlayer player);

	void removeEffect(AbstractPlayer player);

	void toggleApplied();

	boolean isApplied();
}
