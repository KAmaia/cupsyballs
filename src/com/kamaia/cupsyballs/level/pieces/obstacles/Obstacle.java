package com.kamaia.cupsyballs.level.pieces.obstacles;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;
import com.kamaia.cupsyballs.players.Players.Player;

/**
 * Obstacle Class.
 * @author Krystal Amaia
 */

public class Obstacle {
	private final int    length;
	private final char symbol;
	private final ObstacleEffectInterface oei;
	private       int    posX;
	private       int    posY;

	/**
	 * Constructor
	 * @param builder
	 */
	private Obstacle(ObstacleBuilder builder) {
		this.symbol = builder.symbol;
		this.length = builder.length;
		this.oei = builder.oei;
	}

	public int getLength() {
		return length;
	}

	public char getSymbol() {
		return symbol;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Causes the obstacle to apply it's effect to target
	 * @param target target to which effect is applied.
	 */
	public void onCollision(Player target){
		oei.execute(target);
	}


	/**
	 * ObstacleBuilder builds the obstacles.
	 */
	public static class ObstacleBuilder {
		private int    length;
		private ObstacleEffectInterface oei;
		private char symbol;

		/**
		 * Sets the Obstacle's Length.
		 * @return ObstacleBuilder with obstacle length set.
		 */
		public ObstacleBuilder setLength() {
			length = HelperFuncs.newRandomInRange(1, 5);
			return this;
		}

		/**
		 * Sets the Obstacle's Symbol.  (No Longer A STRING! YES!)
		 * @return ObstacleBuilder with the Obstacle's symbol set.
		 */
		public ObstacleBuilder setSymbol() {
			this.symbol = '#';
			return this;
		}

		/**
		 * Sets the Obstacle's Effect, if any.
		 * @param oei the ObstacleEffectInterface to apply.
		 * @return ObstacleBuilder with the Obstacle's Effect Applied.
		 */
		public ObstacleBuilder setEffect(ObstacleEffectInterface oei){
			this.oei = oei;
			return this;
		}

		/**
		 * Builds the Obstacle
		 * @return Obstacle with all parameters set.
		 */
		public Obstacle Build() {
			return new Obstacle(this);
		}
	}
}
