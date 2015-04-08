package com.kamaia.cupsyballs.level.map;

import com.kamaia.cupsyballs.level.Level;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Map {

	private final int      sizeH;
	private final int      sizeW;
	private final String[] map;

	private Map(MapBuilder builder) {
		sizeH = builder.sizeH;
		sizeW = builder.sizeW;
		map = builder.map;
	}

	public String getString(int i) {
		return map[i];
	}

	public static class MapBuilder {
		private final int      sizeH;
		private final int      sizeW;
		private final Level    level;
		private       String[] map;

		public MapBuilder(Level level) {
			this.sizeH = level.getSizeH();
			this.sizeW = level.getSizeW();
			this.level = level;

		}

		public MapBuilder createMap() {
			map = new String[sizeW];
			for (int y = 0; y < sizeH; y++) {
				map[y] = new String();

				String tmp = "";
				for (Obstacle o : level.getObstacles()) {
					int oStart = o.getPosX();
					int oEnd = o.getPosX() + o.getLength();
					int oPosY = o.getPosY();

					if (oPosY == y) {
						for (int x = 0; x < sizeW; x++) {
							if (x == oStart) {
								tmp += o.getSymbol();
								System.out.println("tmp= " + tmp);


							}
							else if (x < oStart || x > oEnd) {
								tmp+=" ";

							}
						}
						System.out.println(tmp);

					}
					map[y] = tmp;
				}
			} return this;
		}

		public Map Build() {
			return new Map(this);
		}


	}
}
