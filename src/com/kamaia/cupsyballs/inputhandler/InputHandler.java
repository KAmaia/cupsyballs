package com.kamaia.cupsyballs.inputhandler;

import java.util.ArrayList;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.InGameMenu;
import com.kamaia.cupsyballs.gui.menus.menuItems.interfaces.MenuItemInterface;
import com.kamaia.cupsyballs.states.Game;
import com.kamaia.cupsyballs.states.abstracts.AbstractMenu;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;

public class InputHandler {

	private int menuIndex = 0;
	private ArrayList<MenuItemInterface> menuItems;
	private Screen screen;
	private GameWindow gameWindow;
	private TerminalSize ts;

	public InputHandler(GameWindow window) {

		gameWindow = window;
		screen = gameWindow.getScreen();
		ts = screen.getTerminalSize();
	}

	public void handleInput(AbstractState sendingState, Key k) {

		// TODO Auto-generated method stub
		if (sendingState instanceof Game) {
			// handle Game input
			switch (k.getKind()) {
				case Escape:
					((Game) sendingState).pauseResume();
					InGameMenu igm = new InGameMenu(gameWindow, sendingState);
					igm.run();
					((Game) sendingState).pauseResume();
					break;
				case ArrowLeft:
					if (((Game) sendingState).getPlayer().getPosX() > 0) {
						((Game) sendingState).getPlayer().moveLeft();
						break;
					}
				case ArrowRight:
					if (((Game) sendingState).getPlayer().getPosX() < ts
							.getColumns() - 1) {
						((Game) sendingState).getPlayer().moveRight();
						break;
					}
				case ArrowDown:
					((Game) sendingState).getPlayer().moveDown();
					break;
					
				default:
					break;
			}
		}
		else if (sendingState instanceof AbstractMenu) {
			// handle menu input
			menuItems = ((AbstractMenu) sendingState).getMenuItems();
			MenuItemInterface curMenuItem = menuItems.get(menuIndex);
			MenuItemInterface preMenuItem = menuItems
					.get(menuItems.size() - 1);
			switch (k.getKind()) {
				case ArrowUp:
					if (menuIndex > 0) {
						menuIndex--;
						preMenuItem = selectMenuItem(menuIndex + 1);
						curMenuItem = selectMenuItem(menuIndex);
					}
					break;
				case ArrowDown:
					if (menuIndex < menuItems.size() - 1) {
						menuIndex++;
						preMenuItem = selectMenuItem(menuIndex - 1);
						curMenuItem = selectMenuItem(menuIndex);
					}
					break;
				case Enter:
					curMenuItem.execute(gameWindow, sendingState);
					break;
				default:
					break;
			}
			curMenuItem.highlight();
			preMenuItem.deHighlight();
		}
	}

	private MenuItemInterface selectMenuItem(int index) {

		return menuItems.get(index);
	}
}
