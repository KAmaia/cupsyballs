package com.kamaia.cupsyballs.gui.menus.menuItems;

import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;


public class HelpMenuItem implements MenuItemInterface {

	private Color fgColor;
	private Color bgColor;

	@Override
	public String getItemString() {

		// TODO Auto-generated method stub
		return "HELP (Coming Soon)";
	}

	@Override
	public void execute(GameWindow window, AbstractState state) {

		// TODO Auto-generated method stub
		
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
