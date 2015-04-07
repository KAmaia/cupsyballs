package com.kamaia.cupsyballs.pieces.obstacles;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.pieces.Abstracts.AbstractPiece;

/**
 * Created by Krystal on 4/5/2015.
 * NOT HERE YET
 */

public class Obstacle extends AbstractPiece {
	private int length;
	private int center;

	private Obstacle(ObstacleBuilder builder){
		this.symbol = builder.symbol;
		this.length = builder.length;
		this.center = builder.center;
	}

	public int getLength() {
		return length;
	}
	public String getSymbol(){
		return symbol;
	}

	public static class ObstacleBuilder{
		private int length;
		private int center;
		private String symbol;

		public ObstacleBuilder setLengthAndCenter(){
			length = HelperFuncs.newRandomInRange(1, 5);
			center = length / 2;
			return this;
		}
		public ObstacleBuilder setSymbol(String symbol){
			this.symbol = "";
			for(int i = 0; i < length; i++){
				this.symbol+=symbol;
			}
			return this;
		}


		public Obstacle Build(){
			return new Obstacle(this);
		}
	}
}
