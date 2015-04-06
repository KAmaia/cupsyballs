package com.kamaia.cupsyballs.states.abstracts;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.inputhandler.InputHandler;


public abstract class AbstractState {
	//Holds all the information for different states.
	protected GameWindow   gw;
	protected Screen       gameScreen;
	protected boolean      running;
	protected InputHandler inputhandler;
	protected TerminalSize ts;

	public AbstractState(GameWindow window) {

		gw = window;
		gameScreen = gw.getScreen();
		inputhandler = new InputHandler(gw);
		ts = gameScreen.getTerminalSize();
		running = true;
	}

	//THIS FUNCTION MUST BE OVERRIDDEN!
	protected abstract void run();

	//THIS FUNCTION MUST BE OVERRIDDEN!
	protected abstract void updateScreen();


	public void setRunning(boolean setRunning) {
		//sets the running status of the state
		running = setRunning;
	}

	public void shutdown() {
		// terminates curses mode.
		gameScreen.clear();
		TerminalSize ts = gameScreen.getTerminalSize();
		gameScreen.putString(ts.getColumns() / 2, ts.getRows() / 2, "GOODBYE!",
		                     Color.RED, Color.BLACK);
		gameScreen.refresh();
		gameScreen.stopScreen();
		setRunning(false);
	}

}
