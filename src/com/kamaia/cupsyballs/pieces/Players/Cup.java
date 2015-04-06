package com.kamaia.cupsyballs.pieces.Players;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

public class Cup extends AbstractPiece {

	private int cupSize;
	private boolean movingLeft;

	public Cup(int posX, int posY, Terminal.Color bgColor, Terminal.Color fgColor) {
		super(posX, posY, .25f, bgColor, fgColor);
		cupSize = 7;
		symbol = "|";
		for (int i = 0; i < cupSize; i++) {
			symbol += "_";
		}
		symbol += "|";
	}


	public void toggleLeft() {
		movingLeft = !movingLeft;
	}

	public void updateX(int level) {
		if (!movingLeft) {
			posX -= speed * level;
		}
		else {
			posX += speed * level;
		}
	}


	public void updateY(int newY) {
		posY = newY;
	}

	public int getCupSize() {
		return cupSize;
	}

	public void modCupSize(int cupMod) {
		cupSize += cupMod;
		symbol = "|";
		for (int i = 0; i < cupSize; i++) {
			symbol += "_";
		}
		symbol += "|";
	}

}
