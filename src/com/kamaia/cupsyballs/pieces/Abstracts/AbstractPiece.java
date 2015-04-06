package com.kamaia.cupsyballs.pieces.Abstracts;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Krystal on 4/5/2015.
 */
public class AbstractPiece {
	protected String         symbol;
	protected float          posX;
	protected float          posY;
	protected float          speed;
	protected Terminal.Color bgColor;
	protected Terminal.Color fgColor;


	public AbstractPiece(float posX, float posY, float speed, Terminal.Color bgColor, Terminal.Color fgColor) {
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.bgColor = bgColor;
		this.fgColor = fgColor;
	}

	public Terminal.Color getBgColor() {
		return bgColor;
	}

	public Terminal.Color getFgColor() {
		return fgColor;
	}

	public String getSymbol() {
		return symbol;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(int posX) {

		// TODO Auto-generated method stub
		this.posX = posX;

	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(int posY) {

		// TODO Auto-generated method stub
		this.posY = posY;
	}

	public void moveLeft() {
		posX -= 1;
	}

	public void moveRight() {
		posX += 1;
	}
}