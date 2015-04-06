package com.kamaia.cupsyballs.pieces;

public class Player {
	private String symbol = "O";
	private int score = 0;
	private float speed;
	private float posX;
	private float posY;

	public Player(int startX) {
		speed = .05f;
		posX = startX;
		posY = 0;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getScore() {
		return score;
	}

	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public void moveLeft() {
		posX -= 1;
	}

	public void moveRight() {
		posX += 1;
	}

	public void updateY(int level) {
		posY += speed * level;
	}

	public void setPosY(int posY) {

		// TODO Auto-generated method stub
		this.posY = posY;
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
		posY +=1;
		
	}
}
