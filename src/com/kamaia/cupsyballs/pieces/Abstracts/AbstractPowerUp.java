package com.kamaia.cupsyballs.pieces.Abstracts;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Krystal on 4/5/2015.
 */
public class AbstractPowerUp extends AbstractPiece {


	public AbstractPowerUp(float posX, float posY, float speed, Terminal.Color bgColor,
	                       Terminal.Color fgColor) {
		super(posX, posY, speed, bgColor, fgColor);
	}

}
