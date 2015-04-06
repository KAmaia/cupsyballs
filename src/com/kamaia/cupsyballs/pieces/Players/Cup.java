package com.kamaia.cupsyballs.pieces.Players;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

public class Cup extends AbstractPiece {

	private int cupSize;
	private boolean movingLeft;

	/**
	 * cupsize sets the cups width.  It shrinks each level.
	 * the for loop here simply adds '_' (Underscores) To the Cup
	 *
	 * @param posX    same as abstract piece.
	 * @param posY    same as abstract piece.
	 * @param bgColor same as abstract piece.
	 * @param fgColor same as abstract piece.
	 */
	public Cup(int posX, int posY, Terminal.Color bgColor, Terminal.Color fgColor) {
		super(posX, posY, .25f, bgColor, fgColor);
		cupSize = 7;
		symbol = "|";
		for (int i = 0; i < cupSize; i++) {
			symbol += "_";
		}
		symbol += "|";
	}

	/**
	 * We Covered this in the game loop.
	 * When movingLeft is true, the cup moves left.
	 * When MovingLeft is false the cup is moving.....
	 * You guessed it, right.
	 */
	public void toggleLeft() {
		movingLeft = !movingLeft;
	}

	/**
	 * moves the cup in the appropriate direction based on movingLeft.
	 * @param level is passed in to adjust the speed of the cup.  The higher the level, the faster it goes!!!
	 */
	public void updateX(int level) {
		if (!movingLeft) {
			posX -= speed * level / 2;
		}
		else {
			posX += speed * level / 2;
		}
	}

	/**
	 * This function is only called when the game resizes.  It sets the cup back to the appropriate number of spaces
	 * off the bottom.
	 * @param newY the new value of Y.  Always gamescreen.rows - 4;
	 */
	public void updateY(int newY) {
		posY = newY;
	}

	public int getCupSize() {
		return cupSize;
	}

	/**
	 * Modifies the size of the cup.
	 * @param cupMod this number should always be a multiple of two. (Won't be catastrophic if it's not, you'll just
	 *                  an uneven cup).  This number modifies the size of the cup.
	 */
	public void modCupSize(int cupMod) {
		cupSize += cupMod;
		symbol = "|";
		for (int i = 0; i < cupSize; i++) {
			symbol += "_";
		}
		symbol += "|";
	}

}
