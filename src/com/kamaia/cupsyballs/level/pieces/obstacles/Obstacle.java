package com.kamaia.cupsyballs.level.pieces.obstacles;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.pieces.obstacles.effects.interfaces.ObstacleEffectInterface;
import com.kamaia.cupsyballs.pieces.Players.Player;

/**
 * Created by Krystal on 4/5/2015.
 * NOT HERE YET
 */

public class Obstacle {
	private final int    length;
	private final char symbol;
	private final ObstacleEffectInterface oei;
	private       int    posX;
	private       int    posY;


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
	public void onCollision(Player target){
		oei.execute(target);
	}




	public static class ObstacleBuilder {
		private int    length;
		private ObstacleEffectInterface oei;
		private char symbol;

		public ObstacleBuilder setLength() {
			length = HelperFuncs.newRandomInRange(1, 5);

			return this;
		}
		public ObstacleBuilder setSymbol() {
			this.symbol = '#';
			return this;
		}
		public ObstacleBuilder setEffect(ObstacleEffectInterface oei){
			this.oei = oei;
			return this;
		}

		public Obstacle Build() {
			return new Obstacle(this);
		}
	}
}
