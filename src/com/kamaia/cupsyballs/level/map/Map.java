package com.kamaia.cupsyballs.level.map;

import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;

import java.util.ArrayList;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Map {

	private final int sizeH;
	private final int sizeW;
	private  ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	private Map(MapBuilder builder) {
		sizeH = builder.sizeH;
		sizeW = builder.sizeW;
		obstacles = builder.obstacles;
	}

	public static class MapBuilder {
		private final int sizeH;
		private final int sizeW;
		private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

		public MapBuilder(int sizeH, int sizeW) {
			this.sizeH = sizeH;
			this.sizeW = sizeW;
		}

		public MapBuilder addObstacles(int maxObstacles) {
			for (int i = 0; i < maxObstacles; i++) {
				Obstacle o = new Obstacle.ObstacleBuilder().setSymbol("#").setLengthAndCenter().Build();
				obstacles.add(o);
			}
			return this;
		}

		public Map Build() {
			return new Map(this);
		}
	}
}
