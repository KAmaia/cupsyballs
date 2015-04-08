package com.kamaia.cupsyballs.level.pieces.obstacles;

import com.kamaia.cupsyballs.helpers.HelperFuncs;

/**
 * Created by Krystal on 4/5/2015.
 * NOT HERE YET
 */

public class Obstacle {
	private final int    length;
	private final String symbol;
	private       int    posX;
	private       int    posY;


	private Obstacle(ObstacleBuilder builder) {
		this.symbol = builder.symbol;
		this.length = builder.length;
	}

	public int getLength() {
		return length;
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

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}


	public static class ObstacleBuilder {
		private int    length;
		private String symbol;

		public ObstacleBuilder setLength() {
			length = HelperFuncs.newRandomInRange(1, 5);

			return this;
		}

		public ObstacleBuilder setSymbol(String symbol) {
			this.symbol = "";
			for (int i = 0; i < length; i++) {
				this.symbol += symbol;
			}
			return this;
		}


		public Obstacle Build() {
			return new Obstacle(this);
		}
	}
}
