package com.kamaia.cupsyballs.pieces.obstacles;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

/**
 * Created by Krystal on 4/5/2015.
 * NOT HERE YET
 */

public class Obstacle extends AbstractPiece {
	public Obstacle(int posX, int posY, float speed) {
		super(posX, posY, speed, Terminal.Color.BLACK, Terminal.Color.BLUE);

	}
}
