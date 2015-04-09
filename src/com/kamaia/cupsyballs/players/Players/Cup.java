package com.kamaia.cupsyballs.players.Players;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.players.abstracts.AbstractPlayer;

public class Cup extends AbstractPlayer {

	private int     cupSize;
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
		super(posX, posY, .25f, Terminal.Color.RED, fgColor);
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
	 */
	void updateX() {
		if (!movingLeft) {
			moveRight();
		}
		else {
			moveLeft();
		}
	}

	/**
	 * This function is only called when the game resizes.  It sets the cup back to the appropriate number of spaces
	 * off the bottom.
	 *
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
	 *
	 * @param cupMod this number should always be a multiple of two. (Won't be catastrophic if it's not, you'll just
	 *               an uneven cup).  This number modifies the size of the cup.
	 */
	public void modCupSize(int cupMod) {
		cupSize += cupMod;
		symbol = "|";
		for (int i = 0; i < cupSize; i++) {
			symbol += "_";
		}
		symbol += "|";
	}

	public void update() {
		updateX();
	}

	public void levelUp() {
		speed += .5 * getSpeed();
	}
}
