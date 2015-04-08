package com.kamaia.cupsyballs.level;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.map.Map;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;
import com.kamaia.cupsyballs.level.pieces.obstacles.effects.PlayerVerticalSlowObstacleEffect;

import java.util.ArrayList;

/**
 * Created by Krystal on 4/8/2015.
 */
public class Level {
	private final int sizeY;
	private final int sizeX;
	private final Map levelMap;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	private Level(LevelBuilder builder) {
		this.sizeY = builder.sizeY;
		this.sizeX = builder.sizeX;
		this.obstacles = builder.obstacles;
		this.levelMap = new Map.MapBuilder(this).createMap().Build();
	}

	public int getSizeY() {
		return sizeY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public Map getLevelMap() {
		return levelMap;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}


	public static class LevelBuilder {
		private int sizeY;
		private int sizeX;
		private final ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

		public LevelBuilder setSize(int sizeX, int sizeY) {
			this.sizeY = sizeY;
			this.sizeX = sizeX;
			return this;
		}

		public LevelBuilder buildObstacles(int numOfObstacles) {
			for (int i = 0; i < numOfObstacles; i++) {
				Obstacle o = new Obstacle.ObstacleBuilder().setLength().setEffect(
					   new PlayerVerticalSlowObstacleEffect()).setSymbol().Build();
				obstacles.add(o);
			}
			return this;
		}

		public LevelBuilder placeObstacles() {
			for (Obstacle o : obstacles) {
				setObstaclePosition(o);
			}

			return this;
		}

		private void setObstaclePosition(Obstacle o) {
			o.setPosX(HelperFuncs.newRandomInRange(0, sizeX));
			o.setPosY(HelperFuncs.newRandomInRange(0, sizeY));

		}


		public Level Build() {
			return new Level(this);
		}
	}
}
