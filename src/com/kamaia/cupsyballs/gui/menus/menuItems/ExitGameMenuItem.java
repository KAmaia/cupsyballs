package com.kamaia.cupsyballs.gui.menus.menuItems;

import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;


public class ExitGameMenuItem implements MenuItemInterface {

	private Color bgColor = Color.BLACK;
	private Color fgColor = Color.WHITE;

	@Override
	public String getItemString() {
		return "Exit Game";
	}

	@Override
	public void execute(GameWindow window, AbstractState state) {
		// Shutdown the program.
		state.shutdown();
		System.exit(0);
	}

	@Override
	public void highlight() {

		// Set the highlight colors
		bgColor = Color.RED;
		fgColor = Color.BLUE;

	}

	@Override
	public void deHighlight() {

		// Return the colors back to default
		bgColor = Color.BLACK;
		fgColor = Color.WHITE;
	}

	@Override
	public Color getFgColor() {
		//Return the forground color
		return fgColor;
	}

	@Override
	public Color getBgColor() {

		// Return the bgColor
		return bgColor;
	}


}
