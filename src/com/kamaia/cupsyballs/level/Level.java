package com.kamaia.cupsyballs.level;

import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.map.Map;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;
import com.kamaia.cupsyballs.level.pieces.obstacles.effects.PlayerVerticalSlowObstacleEffect;

import java.util.ArrayList;

/**
 * Class Level
 * Created by Krystal on 4/8/2015.
 */
public class Level {
	private final int sizeY;
	private final int sizeX;
	private final Map levelMap;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	/**
	 * Constructor
	 * @param builder builds the Level
	 */
	private Level(LevelBuilder builder) {
		this.sizeY = builder.sizeY;
		this.sizeX = builder.sizeX;
		this.obstacles = builder.obstacles;
		this.levelMap = new Map.MapBuilder(this).createMap().Build();
	}

	/**
	 * returns the vertical size of the level.
	 *
	 * @return sizeY
	 */
	public int getSizeY() {
		return sizeY;
	}

	/**
	 * returns the horizontal size of the level.
	 *
	 * @return sizeX
	 */

	public int getSizeX() {
		return sizeX;
	}

	/**
	 * Returns the level's map object.
	 *
	 * @return levelMap.
	 */
	public Map getLevelMap() {
		return levelMap;
	}

	/**
	 * Returns all the obstacles in the level.
	 *
	 * @return obstacles
	 */
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public static class LevelBuilder {
		private int sizeY;
		private int sizeX;
		private final ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

		public LevelBuilder(){

		}

		/**
		 * Sets the size of the level.
		 * @param sizeX horizontal size of the level
		 * @param sizeY vertical size of the level
		 * @return LevelBuilder
		 */
		public LevelBuilder setSize(int sizeX, int sizeY) {
			this.sizeY = sizeY;
			this.sizeX = sizeX;
			return this;
		}

		/**
		 * Constructs the Obstacles for the Level
		 * @param numOfObstacles number of Obstacles to construct.
		 * @return LevelBuilder
		 */
		public LevelBuilder buildObstacles(int numOfObstacles) {
			for (int i = 0; i < numOfObstacles; i++) {
				Obstacle o = new Obstacle.ObstacleBuilder().setLength().setEffect(
					   new PlayerVerticalSlowObstacleEffect()).setSymbol().Build();
				obstacles.add(o);
			}
			return this;
		}

		/**
		 * Places the obstacles in the level.  Separated from buildObstacles() to improve readability and simplify the
		 * process of detecting obstacle collisions. (This is a todo item)
		 *
		 * @return LevelBuilder
		 * @see #setObstaclePosition(com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle o)
		 */
		public LevelBuilder placeObstacles() {
			for (Obstacle o : obstacles) {
				setObstaclePosition(o);
			}

			return this;
		}

		/**
		 * Sets the obstacle's position in the level.
		 * @param o the obstacle to place
		 */
		private void setObstaclePosition(Obstacle o) {
			o.setPosX(HelperFuncs.newRandomInRange(0, sizeX));
			o.setPosY(HelperFuncs.newRandomInRange(0, sizeY));

		}

		/**
		 * Finally builds the Level.
		 *
		 * @return a new Level.
		 */
		public Level Build() {
			return new Level(this);
		}
	}
}
