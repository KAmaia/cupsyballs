package com.kamaia.cupsyballs.helpers;

import java.util.Random;

/**
 * Created by Krystal on 4/6/2015.
 */
public class HelperFuncs {
	private static Random rand = new Random();

	public static int newRandomInRange(int min, int max) {
		int r = rand.nextInt((max - min) + 1) + min;
		return r;
	}


}