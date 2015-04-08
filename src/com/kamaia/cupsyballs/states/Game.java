package com.kamaia.cupsyballs.states;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.kamaia.cupsyballs.gui.GameWindow;
import com.kamaia.cupsyballs.level.Level;
import com.kamaia.cupsyballs.level.map.Map;
import com.kamaia.cupsyballs.level.pieces.obstacles.Obstacle;
import com.kamaia.cupsyballs.pieces.Players.Cup;
import com.kamaia.cupsyballs.pieces.Players.Player;
import com.kamaia.cupsyballs.states.abstracts.AbstractState;
import com.kamaia.cupsyballs.states.menus.GameOverMenu;

/**
 * posX = Horizontal
 * posY = Vertical
 */
public class Game extends AbstractState {

	private final Player player;
	private final Cup    cup;
	private       int    gameLevel;
	private       Level  level;
	private       Map    map;
	private boolean paused = false;

	public Game(GameWindow window) {
		super(window);

		gameScreen = window.getScreen();
		player = new Player(gameScreen.getTerminalSize().getColumns() / 2, 3);
		cup = new Cup(ts.getColumns() / 2, ts.getRows() - 4, Color.BLACK, Color.BLUE);
		gameLevel = 1;
	}

	/**
	 * The main game loop.
	 */
	public void run() {
		//Build the first level, and map
		level = new Level.LevelBuilder().setSize(ts.getRows(), ts.getColumns()).buildObstacles(10).placeObstacles()
		                                .Build();
		map = level.getLevelMap();
		//The Main Game Loop
		long lastTime = System.nanoTime(); // get the nano time the first time the loop is run.
		double ticks = 140d;                // how many ticks per second do we want?  higher = faster.
		double ns = 1000000000 / ticks;    // ns is the number of nano seconds per second,
		// divided by the number of updates per second we want.
		double delta = 0;                  // delta is our controlling time measurement.
		running = true;
		gameScreen.startScreen();
		while (running) {
			//paused is set by pauseResume(), basically it gives us a second method to control the game logic,
			//without shutting down the game by modifying boolean running.

			while (!paused) {
				long now = System.nanoTime();      // get the current nano time each loop.
				delta += (now - lastTime) / ns;    // subtract our last time from it and divide it by our magic
				// update number
				lastTime = now;                    // reset last time to this time.
				if (delta >= 2) {                  // if our delta is greater than one allow the game to tick.
					tick();                       // run our updates

					delta = 0;                    // reset delta before the next game loop.
				}
			}
		}
		shutdown();                                  //   If !running shutdown the system.
	}

	public Player getPlayer() {
		/**
		 *
		 * Returns the player Object....D'uh!
		 *
		 */
		return player;
	}

	/**
	 * The Heart and soul of the game loop.  Tick() is responsible for telling the game to update
	 * pretty much everything, including input, "win" conditions, and levelling up the game.
	 * A bug in Lanterna is currently preventing the cursor from ACTUALLY becoming invisible.
	 * I've filed bug reports, hopefully it's fixed soon.
	 */
	private void tick() {
		Key k = gameScreen.readInput();
		if (k != null) {
			inputhandler.handleInput(this, k);
		}
		if (checkWin()) {
			levelUp();
		}
		player.update();
		updateCup();
		cup.update(); //todo: pass in a MAP argument.
		updateScreen();
	}

	private void drawMap() {
		for (int i = 0; i < level.getSizeH(); i++) {
			gameScreen.putString(0, i, map.getString(i), Color.YELLOW, Color.BLACK);
		}
	}

	/**
	 * Increases the gameLevel of the game.
	 * Higher Levels = Higher Speeds. (To Encourage Power Up Use.)
	 */

	private void levelUp() {

		// TODO Auto-generated method stub
		gameLevel++;
		if (cup.getCupSize() >= 3) {
			cup.modCupSize(-1);
		}
		if (gameLevel >= 3) {
			player.addLife();
		}

		player.setPosY(0);
		cup.levelUp();
		player.updateScore(gameLevel);
	}


	/**
	 * Updates the postion of the cup on the screen.
	 * If the cup reaches an edge cup.toggleLeft is called to change its direction.
	 * Passes Level to adjust cup speed.
	 * <p/>
	 * TODO: Move this functionality into the Cup.update() method after creating a real gameLevel.
	 */
	private void updateCup() {

		// updates the cups position on the screen
		if (cup.getPosX() + cup.getCupSize() + 1 >= ts.getColumns() - 1 || cup.getPosX() <= 0) {
			cup.toggleLeft();
		}
	}

	/**
	 * Checks to see if the screen's size has changed. If it has, it does a refresh cycle and moves the cup to the
	 * appropriate y location.
	 * Updates the game screen.
	 */
	protected void updateScreen() {

		//Checks to see if the screen has been resized since the last draw cycle.  If so, it updates the position of
		//the cup.
		if (gameScreen.updateScreenSize()) {
			gameScreen.clear();
			cup.updateY(ts.getRows() - 4);
			gameScreen.refresh();
		}
		//If it hasn't been resized, it simply redraws it.  (Yes I see the code replication, but it doesn't work
		//properly otherwise.
		else {
			gameScreen.clear();

			drawPlayer();
			drawCup();
			drawMap();
			drawScoreBoard();
			gameScreen.refresh();
		}
	}


	private void drawPlayer() {
		/**
		 *
		 * draws the player to the game screen.  Pretty self explanatory.
		 *
		 */
		gameScreen.putString((int) player.getPosX(), (int) player.getPosY(), player.getSymbol(), player.getBgColor(),
		                     player.getFgColor());
	}

	/**
	 * See this is what I mean.  This function is painfully obvious.  Draws the cup to the screen.
	 */
	private void drawCup() {

		gameScreen.putString((int) cup.getPosX(), (int) cup.getPosY(), cup.getSymbol(), Color.BLUE, Color.BLACK);
	}

	/**
	 * Checks to see if the ball is in the cup.
	 * If it is, it resets the player's position to the top of the screen, and increments the player's score.
	 * If Not it checks the remaining number of lives, if there are lives remaining, it resets the player to the
	 * top of the screen and decrements the player's lives by 1.  If the player is out of lives, it runs the
	 * GameOverMenu state.
	 */
	private boolean checkWin() {

		if ((int) player.getPosX() >= (int) cup.getPosX() && player.getPosX() <= cup.getPosX() + cup
			   .getCupSize() && (int) player.getPosY() == (int) cup.getPosY()) {
			return true;
		}
		else if ((int) player.getPosY() >= (int) cup.getPosY() && (int) player.getPosX() != (int) cup
			   .getPosX() || checkObstacleCollisions()) {
			if (player.getLives() >= 0) {
				reset();
			}
		}
		return false;
	}

	private boolean checkObstacleCollisions() {
		boolean objectCollision = false;

		for (Obstacle o : level.getObstacles()) {
			int oEnd = o.getPosX() + o.getLength();
			if (((int) player.getPosY() == o.getPosY()) && (((int) player.getPosX() >= o.getPosX()) && ((int) player
				   .getPosX() <= oEnd))) {
				objectCollision = true;
			}
		}
		return objectCollision;
	}

	/**
	 * Resets the Player's Postion back to the top of the board
	 */

	private void reset() {
		if (player.getLives() > 0) {
			player.setLives(-1);
			player.deathScore();

			player.setPosX(ts.getColumns() / 2);
			player.setPosY(0);
		}
		else if (player.getLives() <= 0) {
			GameOverMenu gom = new GameOverMenu(gw);
			gom.run();
		}
	}

	/**
	 * Draws The Scoreboard on the bottom of the screen.
	 * seriously, this is pretty self commenting, isn't it?
	 */
	private void drawScoreBoard() {

		String divider = "";
		String scoreBoard = "Level: " + gameLevel + "\tScore: " + player.getScore() + "\tLives Remaining: " + player
			   .getLives();
		String menuString = "(ESC) For Menu";
		for (int i = 0; i <= ts.getColumns(); i++) {
			divider += "=";
		}
		gameScreen.putString(0, ts.getRows() - 3, divider, Color.RED, Color.BLACK);
		gameScreen.putString((ts.getColumns() - scoreBoard.length()) / 2, ts.getRows() - 2, scoreBoard, Color.GREEN,
		                     Color.BLACK);
		gameScreen.putString((ts.getColumns() - menuString.length()) / 2, ts.getRows() - 1, menuString, Color.GREEN,
		                     Color.BLACK);
	}

	/**
	 * Toggles Whether Or Not The State Is Paused;
	 */
	public void pauseResume() {

		paused = !paused;
	}

	public Level getLevel() {
		return level;
	}
}
