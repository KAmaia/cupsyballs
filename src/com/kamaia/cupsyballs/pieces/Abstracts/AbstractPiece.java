package com.kamaia.cupsyballs.pieces.Abstracts;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Krystal on 4/5/2015.
 */
public class AbstractPiece {
	protected float          speed;
	private   Terminal.Color bgColor;
	private   Terminal.Color fgColor;
	protected String         symbol;
	protected int            posX;
	protected int            posY;

	protected AbstractPiece() {

	}

	/**
	 * Constructor
	 *
	 * @param posX    starting position on the X axis.
	 * @param posY    starting position on the Y axis.
	 * @param speed   starting speed.  In float format.
	 * @param bgColor Terminal.Color for background.
	 * @param fgColor Terminal.Color for foreground.
	 */
	protected AbstractPiece(int posX, int posY, float speed, Terminal.Color bgColor, Terminal.Color fgColor) {
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

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX){
		this.posX = posX;
	}
	public void setPosY(int posY) {

		this.posY = posY;
	}

	public void moveLeft() {
		posX -= 1;
	}

	public void moveRight() {
		posX += 1;
	}
}