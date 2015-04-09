package com.kamaia.cupsyballs.players.abstracts;

import com.googlecode.lanterna.terminal.Terminal;
import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;

import java.util.HashMap;

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
	private HashMap<ObstacleEffectInterface, Integer> activeEffects = new HashMap<ObstacleEffectInterface, Integer>();


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

	public void setPosX(int posX) {
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

	/**
	 * @WIP
	 * Adds Selected Effect To Player's activeEffect list
	 * @param oei
	 * @param ticksToApply
	 */
	public void addEffect(ObstacleEffectInterface oei, int ticksToApply) {
		if (!activeEffects.containsKey(oei)) {
			activeEffects.put(oei, ticksToApply);
		}
		else {
			int ticks = activeEffects.get(oei);
			activeEffects.remove(oei);
			ticks += ticksToApply;
			activeEffects.put(oei, ticks);
		}
	}

	/**
	 * @WIP
	 * Applies all active effects to player.
	 *
	 */
	protected void applyEffects() {
		for (ObstacleEffectInterface oei : activeEffects.keySet()) {

			if (activeEffects.get(oei) > 0) {
				if (oei.isApplied()) {
					int ticksLeft = activeEffects.get(oei);
					ticksLeft --;
					System.out.println(oei.getEffectname() + ":"+ticksLeft);
					activeEffects.put(oei, ticksLeft);
					oei.applyEffect(this);

				}
				else {
					oei.toggleApplied();
					oei.removeEffect(this);
					activeEffects.remove(oei);
				}
			}
		}
	}

	/**
	 * Returns the player's speed.
	 * @return speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Sets the player's new speed.
	 * @param speed
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}