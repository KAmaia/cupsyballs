package com.kamaia.cupsyballs.gui;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class GameWindow {
	private final Screen   s;
	private final Terminal t;

	/**
	 * CTor for the game window.
	 *
	 * @param rows number of Rows in the game window
	 * @param cols number of cols in the game window
	 */
	public GameWindow(int rows, int cols) {

		t = TerminalFacade.createSwingTerminal(rows, cols);
		s = new Screen(t);
		/**
		 * Workaround to make the cursor invisible.
		 */
		s.setCursorPosition(null);
	}

	/**
	 *
	 * @return Screen s;
	 */
	public Screen getScreen() {
		return s;
	}


}
