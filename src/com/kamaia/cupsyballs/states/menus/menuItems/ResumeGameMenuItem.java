package com.kamaia.cupsyballs.states.menus.menuItems;

import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;
import com.kamaia.cupsyballs.states.menus.menuItems.interfaces.MenuItemInterface;


public class ResumeGameMenuItem implements MenuItemInterface {

	private Color bgColor;
	private Color fgColor;

	@Override
	public String getItemString() {

		// TODO Auto-generated method stub
		return "Resume Game";
	}

	@Override
	public void execute(GameWindow window, AbstractState state) {

		// TODO Auto-generated method stub
		state.setRunning(false);


	}

	@Override
	public void highlight() {

		// TODO Auto-generated method stub
		bgColor = Color.RED;
		fgColor = Color.BLUE;
	}

	@Override
	public void deHighlight() {

		// TODO Auto-generated method stub
		bgColor = Color.BLACK;
		fgColor = Color.WHITE;
	}

	@Override
	public Color getFgColor() {

		// TODO Auto-generated method stub
		return fgColor;
	}

	@Override
	public Color getBgColor() {

		// TODO Auto-generated method stub
		return bgColor;
	}
}
