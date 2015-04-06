package com.kamaia.cupsyballs.gui;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

public class GameWindow {
	private Screen s;
	private Terminal t;
	public GameWindow(int rows, int cols){
		t = TerminalFacade.createSwingTerminal(rows, cols);
		t.setCursorVisible(false);
		s = new Screen(t); 
	}
	public Screen getScreen(){
		return s;
	}
	public Terminal getTerminal(){
		return t;
	}
	

	
}
