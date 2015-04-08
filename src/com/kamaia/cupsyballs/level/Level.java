package com.kamaia.cupsyballs.level;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.map.Map;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;

import java.util.ArrayList;

/**
 * Created by Krystal on 4/8/2015.
 */
public class Level {
	private final int sizeH;
	private final int sizeW;
	private final Map levelMap;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	private Level(LevelBuilder builder) {
		this.sizeH = builder.sizeH;
		this.sizeW = builder.sizeW;
		this.obstacles = builder.obstacles;
		this.levelMap = new Map.MapBuilder(this).createMap().Build();
	}

	public int getSizeH() {
		return sizeH;
	}

	public int getSizeW() {
		return sizeW;
	}

	public Map getLevelMap() {
		return levelMap;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}


	public static class LevelBuilder {
		private int sizeH;
		private int sizeW;
		private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

		public LevelBuilder setSize(int sizeH, int sizeW) {
			this.sizeH = sizeH;
			this.sizeW = sizeW;
			return this;
		}

		public LevelBuilder buildObstacles(int numOfObstacles) {
			for (int i = 0; i < numOfObstacles; i++) {
				Obstacle o = new Obstacle.ObstacleBuilder().setLength().setSymbol("#").Build();
				obstacles.add(o);
			}
			return this;
		}

		public LevelBuilder placeObstacles() {
			for (Obstacle o : obstacles) {
				setObstaclePosition(o);

				System.out.println("Placing Obstacle with length: " + o.getLength() + " @ " + o.getPosX() + "," + o
					   .getPosY() + " " + o.getSymbol());
			}

			return this;
		}

		private void setObstaclePosition(Obstacle o) {
			o.setPosX(HelperFuncs.newRandomInRange(0, sizeW));
			o.setPosY(HelperFuncs.newRandomInRange(0, sizeH));

		}


		public Level Build() {
			return new Level(this);
		}
	}
}
