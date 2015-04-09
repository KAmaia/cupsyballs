package com.kamaia.cupsyballs.helpers;

import java.util.Random;

/**
 * @author Krystal Amaia
 * A collection of helpful functions that really don't belong anywhere, but get used everywhere.  Statics are used to
 * simplify calling the functions.  None of these functions require state.
 */
public class HelperFuncs {
	private static final Random rand = new Random();

	/**
	 * Gets a random integer between int min and int max
	 * @param min the minimum value desired from the random range.
	 * @param max the maximum value desired from the random range.
	 * @return the random value between min & max as an integer.
	 */
	public static int newRandomInRange(int min, int max) {
		return rand.nextInt((max - min) + 1) + min;
	}


}