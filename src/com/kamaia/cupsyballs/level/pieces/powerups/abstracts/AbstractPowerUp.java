package com.kamaia.cupsyballs.level.pieces.powerups.abstracts;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPlayer;

/**
 * Created by Krystal on 4/5/2015.
 */
class AbstractPowerUp extends AbstractPlayer {
	/**
	 * NOT HERE YET!
	 *
	 * @param posX
	 * @param posY
	 * @param speed
	 * @param bgColor
	 * @param fgColor
	 */

	public AbstractPowerUp(int posX, int posY, float speed, Terminal.Color bgColor,
	                       Terminal.Color fgColor) {
		super(posX, posY, speed, bgColor, fgColor);
	}

}
