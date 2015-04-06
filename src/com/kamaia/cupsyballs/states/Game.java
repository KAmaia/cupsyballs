package com.kamaia.cupsyballs.states;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.gui.menus.GameOverMenu;
import com.kamaia.cupsyballs.pieces.Cup;
import com.kamaia.cupsyballs.pieces.Player;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;

public class Game extends AbstractState {

	private Player player;
	private Cup cup;
	private int level;
	private int tries = 3;
	final double ticks = 60d;
	private boolean paused = false;

	public Game(GameWindow window) {

		// TODO Auto-generated constructor stub
		super(window);
		gameScreen = window.getScreen();
		player = new Player(gameScreen.getTerminalSize().getColumns() / 2);
		cup = new Cup(ts.getColumns() / 2, ts.getRows() - 4);
		level = 1;
	}

	public void run() {

		// Game Loop
		long lastTime = System.nanoTime();
		double ns = 1000000000 / ticks;
		double delta = 0;
		running = true;
		gameScreen.startScreen();
		while (running) {
			while (!paused) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				if (delta >= 1) {
					tick();
					delta = 0;
				}
			}
		}
		shutdown();
	}

	public Player getPlayer() {

		return player;
	}

	private void tick() {
		gameScreen.setCursorPosition(-10, -10);
		gameScreen.getTerminal().setCursorVisible(false);
		Key k = gameScreen.readInput();
		if (k != null) {
			inputhandler.handleInput(this, k);
		}
		if (checkWin()) {
			levelUp();
		}
		else {
			player.updateY(level);
			updateCup();
			updateScreen();
		}
	}

	private void levelUp() {

		// TODO Auto-generated method stub
		level++;
		if (cup.getCupSize() >= 3) {
			cup.modCupSize(-1);
		}
		player.setPosY(0);
		player.updateScore(level);
	}

	private void updateCup() {

		// updates the cups position on the screen
		if (cup.getPosX() + cup.getCupSize() + 1 >= ts.getColumns() - 1
				|| cup.getPosX() <= 0) {
			cup.toggleLeft();
		}
		cup.updateX(level);
	}

	private void updateScreen() {

		// refreshes the entire screen. Lanterna is still a bit buggy
		// though....have to report some of this.
		if (gameScreen.updateScreenSize()) {
			gameScreen.clear();
			cup.updateY(ts.getRows() - 4);
			gameScreen.refresh();
		}
		else {
			gameScreen.clear();
			drawPlayer();
			drawCup();
			drawScoreBoard();
			gameScreen.refresh();
		}
	}

	private void drawPlayer() {

		// draws the player to the screen. (Will fix these casts sometime next
		// whenever.
		gameScreen.putString((int) player.getPosX(), (int) player.getPosY(),
				player.getSymbol(), Color.RED, Color.BLACK);
	}

	private void drawCup() {

		gameScreen.putString((int) cup.getPosX(), (int) cup.getPosY(),
				cup.getSymbol(), Color.BLUE, Color.BLACK);
	}

	private boolean checkWin() {

		// checks to see if the ball is in the cup.
		if ((int) player.getPosX() >= (int) cup.getPosX()
				&& player.getPosX() <= cup.getPosX() + cup.getCupSize()
				&& (int) player.getPosY() == (int) cup.getPosY()) {
				return true;
		}
		else if ((int) player.getPosY() >= (int) cup.getPosY()
				&& (int) player.getPosX() != (int) cup.getPosX()) {
			if (tries > 0) {
				tries--;
				reset();
			}
			else {
				GameOverMenu gom = new GameOverMenu(gw);
				gom.run();
			}
		}
		return false;
	}

	private void reset() {

		player.setPosX(ts.getColumns() / 2);
		player.setPosY(0);
	}

	private void drawScoreBoard() {

		String divider = "";
		String scoreBoard = "Level: " + level + "\tScore: "
				+ player.getScore() + "\tLives Remaining: " + tries;
		String menuString = "(ESC) to quit";
		for (int i = 0; i <= ts.getColumns(); i++) {
			divider += "=";
		}
		gameScreen.putString(0, ts.getRows() - 3, divider, Color.RED,
				Color.BLACK);
		gameScreen.putString((ts.getColumns() - scoreBoard.length()) / 2,
				ts.getRows() - 2, scoreBoard, Color.GREEN, Color.BLACK);
		gameScreen.putString((ts.getColumns() - menuString.length()) / 2,
				ts.getRows() - 1, menuString, Color.GREEN, Color.BLACK);
	}
	public void pauseResume(){
		paused = !paused;
	}
}
