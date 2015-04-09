package com.kamaia.cupsyballs.level.map;

import com.kamaia.cupsyballs.level.Level;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;

/**
 * @author Krystal Amaia
 */
public class Map {

	private final String[] map;

	/**
	 * Constructor
	 */
	private Map(MapBuilder builder) {
		map = builder.map;
	}

	/**
	 * Returns a specific String from the String[] map
	 * @param i The specified String from the String[] map
	 * @return map[i] as a string value.
	 */
	public String getString(int i) {
		return map[i];
	}

	/**
	 * MapBuilder constructs a map of the calling level.
	 */
	public static class MapBuilder {
		private final int      sizeY;
		private final int      sizeX;
		private final Level    level;
		private       String[] map;

		/**
		 * Constructor
		 * @param level the level which is being mapped.
		 */
		public MapBuilder(Level level) {
			this.sizeY = level.getSizeY();
			this.sizeX = level.getSizeX();
			this.level = level;

		}

		/**
		 * Builds a String[] of the level.
		 * @return Mapbuilder with the map created.
		 */
		public MapBuilder createMap() {
			map = new String[sizeY];
			for (int y = 0; y < sizeY - 1; y++) {
				map[y] = "";

				char[] tmp = new char[sizeX];
				for (Obstacle o : level.getObstacles()) {
					int oStart = o.getPosX();
					int oEnd = o.getPosX() + o.getLength();
					int oPosY = o.getPosY();

					if (oPosY == y) {
						for (int x = 0; x < sizeX; x++) {
							if (x < oStart || x > oEnd) {
								tmp[x] = ' ';
							}
							else if (x >= oStart && x <= oEnd) {
								tmp[x] = o.getSymbol();
							}

						}

					}
					map[y] = new String(tmp);
				}
			}
			return this;
		}

		/**
		 * Builds the final map.
		 * @return a new map of the level.
		 */
		public Map Build() {
			return new Map(this);
		}


	}
}
