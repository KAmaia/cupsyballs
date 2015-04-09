package com.kamaia.cupsyballs.pieces.Players;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.abstracts.AbstractPlayer;

public class Player extends AbstractPlayer {
	private int score = 0;
	private int lives;

	public Player(int startX, int lives) {
		super(startX, 0, .15f, Terminal.Color.RED, Terminal.Color.BLACK);

		this.lives = lives;
		this.symbol = "O";
	}

	public int getLives() {
		return lives;
	}

	/**
	 * sets the number of lives sthe player has.
	 *
	 * @param lives how many lives to add (or subtract if negative)
	 */
	public void setLives(int lives) {
		this.lives += lives;
	}

	public int getScore() {
		return score;
	}

	/**
	 * Moves the player along the Y Axis.
	 *
	 * @param level passed in from Game to make the player move faster/slower.
	 */
	public void updateY(int level) {
		posY += getSpeed() * level;
	}

	/**
	 * Updates the score based on the level you're in.  (I know, it's boring....)
	 * You are scored based on the level you are on.
	 * The Formula is score += score + level.
	 *
	 * @param level the games current level.
	 */
	public void updateScore(int level) {

		// TODO Auto-generated method stub
		score += score + level;

	}

	public void deathScore() {
		score -= 1;
	}

	/**
	 * really?
	 *
	 * @param posX sets the players new posX
	 */
	public void setPosX(int posX) {

		// TODO Auto-generated method stub
		this.posX = posX;

	}

	/**
	 * Moves the player one step closer to the bottom of the scree.  E.G. when the down arrow is pressed.
	 */
	public void moveDown() {

		// TODO Auto-generated method stub
		posY += getSpeed();

	}

	public void update() {
		applyEffects();
		moveDown();
	}

	public void moveLeft() {
		posX -= 1;
	}

	public void moveRight() {
		posX += 1;
	}

	public void addLife() {
		lives += 1;
	}

}

