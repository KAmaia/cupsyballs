package com.kamaia.cupsyballs.playlist;


import com.kamaia.cupsyballs.map.Map;

import java.util.ArrayList;

/**
 * Created by Krystal on 4/6/2015.
 */
public class Playlist {

	private int size;
	private int mapIndex = 0;

	private ArrayList<Map> maps = new ArrayList<Map>();

	private Playlist(PlaylistBuilder builder) {
		this.size = builder.size;
		this.maps = builder.maps;
	}
	public Map getCurrentMap(){
		return maps.get(mapIndex);
	}
	public Map getNextMap(){
		if(mapIndex + 1 < size) {
			mapIndex += 1;
		}
		return maps.get(mapIndex);
	}
	public Map getPreviousMap(){
		if(mapIndex > 0) {
			mapIndex -= 1;
		}
		return maps.get(mapIndex);
	}

	public static class PlaylistBuilder {
		private final int size;
		private ArrayList<Map> maps = new ArrayList<Map>();

		public PlaylistBuilder(int size) {
			this.size = size;
		}
		public PlaylistBuilder buildMaps(){
			for(int i = 0; i < size; i++){
				maps.add(new Map.MapBuilder(80, 40).Build());
			}
			return this;
		}
		public Playlist Build(){
			return new Playlist(this);
		}
	}
}