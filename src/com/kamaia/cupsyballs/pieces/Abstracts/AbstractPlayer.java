package com.kamaia.cupsyballs.pieces.Abstracts;

import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Krystal on 4/5/2015.
 */
public class AbstractPlayer {
	protected     float          speed;
	private final Terminal.Color bgColor;
	private final Terminal.Color fgColor;
	protected     String         symbol;
	protected     float          posX;
	protected     float          posY;


	/**
	 * Constructor
	 *
	 * @param posX    starting position on the X axis.
	 * @param posY    starting position on the Y axis.
	 * @param speed   starting speed.  In float format.
	 * @param bgColor Terminal.Color for background.
	 * @param fgColor Terminal.Color for foreground.
	 */
	protected AbstractPlayer(int posX, int posY, float speed, Terminal.Color bgColor, Terminal.Color fgColor) {
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

	public float getPosY() {
		return posY;
	}

	public void setPosX(int posX){
		this.posX = posX;
	}
	public void setPosY(int posY) {

		this.posY = posY;
	}

	protected void moveLeft() {
		posX -= speed;
	}

	protected void moveRight() {
		posX += speed;
	}
}