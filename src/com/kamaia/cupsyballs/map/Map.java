package com.kamaia.cupsyballs.map;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Map {

	private final int sizeH;
	private final int sizeW;

	private Map(MapBuilder builder){
		sizeH = builder.sizeH;
		sizeW = builder.sizeW;
	}

	public static class MapBuilder{
		private final int sizeH;
		private final int sizeW;

		public MapBuilder(int sizeH, int sizeW){
			this.sizeH = sizeH;
			this.sizeW = sizeW;
		}
		public Map Build(){
			return new Map(this);
		}
	}
}
