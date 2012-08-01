package engine.JWolf2D.testGame;

import engine.JWolf2D.core.Game;

public class Main {

	public static void main(String[] args) throws Exception{
		Game game = new Game(new GameScreen());
		game.setTitle("Test Game");
		game.setDisplayMode(800,600);
		game.start();
	}

}
