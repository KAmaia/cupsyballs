package com.kamaia.cupsyballs.states.abstracts;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.InputHandler;


public abstract class AbstractState {
	//Holds all the information for different states.
	protected final GameWindow   gw;
	protected final InputHandler inputhandler;
	protected final TerminalSize ts;
	protected final int          sizeY;
	protected final int          sizeX;
	protected       Screen       gameScreen;
	protected       boolean      running;

	protected AbstractState(GameWindow window) {

		gw = window;
		gameScreen = gw.getScreen();
		inputhandler = new InputHandler(gw);
		ts = gameScreen.getTerminalSize();
		sizeX = ts.getColumns();
		sizeY = ts.getRows();
		running = true;
	}

	/**
	 * MUST BE OVERLOADED
	 */

	protected abstract void updateScreen();

	/**
	 * sets the running status of the non-abstract state
	 *
	 * @param setRunning (really?!?)
	 */
	public void setRunning(boolean setRunning) {
		//sets the running status of the state
		running = setRunning;
	}

	/**
	 * Does One Last update and prints GoodBye!.
	 * Shuts down the terminal.
	 */
	public void shutdown() {
		// terminates curses mode.
		gameScreen.clear();
		TerminalSize ts = gameScreen.getTerminalSize();
		gameScreen.putString(ts.getColumns() / 2, ts.getRows() / 2, "GOODBYE!", Color.RED, Color.BLACK);
		gameScreen.refresh();
		gameScreen.stopScreen();
		setRunning(false);
	}

}
