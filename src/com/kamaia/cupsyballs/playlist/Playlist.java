package com.kamaia.cupsyballs.playlist;


import com.kamaia.cupsyballs.helpers.HelperFuncs;
import com.kamaia.cupsyballs.level.Level;

import java.util.ArrayList;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Playlist {

	private int size;
	private int levelIndex = 0;

	private ArrayList<Level> levels = new ArrayList<Level>();

	private Playlist(PlaylistBuilder builder) {
		this.size = builder.size;
		this.levels = builder.levels;
	}

	public Level getCurrentLevel() {
		return levels.get(levelIndex);

	}

	public Level getNextLevel() {
		if (levelIndex + 1 < size) {
			levelIndex += 1;
		}
		return levels.get(levelIndex);

	}

	public Level getPreviousMap() {
		if (levelIndex > 0) {
			levelIndex -= 1;
		}
		return levels.get(levelIndex);
	}

	public static class PlaylistBuilder {
		private int size;
		private ArrayList<Level> levels = new ArrayList<Level>();

		public PlaylistBuilder(int size) {
			this.size = size;
		}

		public PlaylistBuilder buildLevels(int sizeX, int sizeY) {
			for (int i = 0; i < size - 1; i++) {
				if (i < 3) {
					levels.add(new Level.LevelBuilder().setSize(sizeX, sizeY).Build());
				}
				else {
					int numObstacles = HelperFuncs.newRandomInRange(i, i * 3);
					levels.add(new Level.LevelBuilder().setSize(sizeX, sizeY).buildObstacles(numObstacles)
					                                   .placeObstacles().Build());
				}
			}
			return this;
		}

		public Playlist Build() {
			return new Playlist(this);
		}
	}
}