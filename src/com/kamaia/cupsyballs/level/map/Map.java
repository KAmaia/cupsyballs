package com.kamaia.cupsyballs.level.map;

import com.kamaia.cupsyballs.level.Level;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Map {

	private final String[] map;

	private Map(MapBuilder builder) {
		map = builder.map;
	}

	public String getString(int i) {
		return map[i];
	}

	public static class MapBuilder {
		private final int      sizeY;
		private final int      sizeX;
		private final Level    level;
		private       String[] map;

		public MapBuilder(Level level) {
			this.sizeY = level.getSizeY();
			this.sizeX = level.getSizeX();
			this.level = level;

		}

		public MapBuilder createMap() {
			map = new String[sizeY];
			for (int y = 0; y < sizeY - 1; y++) {
				map[y] = new String();

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

		public Map Build() {
			return new Map(this);
		}


	}
}
