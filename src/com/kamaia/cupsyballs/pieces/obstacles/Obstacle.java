package com.kamaia.cupsyballs.pieces.obstacles;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

/**
 * Created by Krystal on 4/5/2015.
 * NOT HERE YET
 */

public class Obstacle extends AbstractPiece {
	String[] symbols = {"=", "+", "*", "#"};
	private int length;

	public Obstacle(int posX, int posY, float speed) {
		super(posX, posY, speed, Terminal.Color.BLUE, Terminal.Color.BLACK);
		length = HelperFuncs.newRandomInRange(1, 5);
		String selectedSymbol = symbols[HelperFuncs.newRandomInRange(0, symbols.length - 1)];
		symbol = "";
		for (int i = 0; i < length; i++) {
			symbol += selectedSymbol;
		}
	}

	public int getLength() {
		return length;
	}
}
