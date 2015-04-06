package com.kamaia.cupsyballs.pieces.Players;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

public class Player extends AbstractPiece {
	private int score = 0;
	private int lives;

	public Player(int startX, int lives) {
		super(startX, 0, .05f, Terminal.Color.RED, Terminal.Color.BLACK);
		this.lives = lives;
		this.symbol = "O";
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives += lives;
	}

	public int getScore() {
		return score;
	}

	public void updateY(int level) {
		posY += speed * level;
	}

	public void updateScore(int level) {

		// TODO Auto-generated method stub
		score += score + level;

	}

	public void setPosX(int posX) {

		// TODO Auto-generated method stub
		this.posX = posX;

	}

	public void moveDown() {

		// TODO Auto-generated method stub
		posY += 1;

	}
}
