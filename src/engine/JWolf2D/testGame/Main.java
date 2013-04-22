package engine.JWolf2D.testGame;

import engine.JWolf2D.core.Game;

public class Main {

	public static void main(String[] args) throws Exception{
		Game game = new Game(new MenuScreen());
		game.setTitle("Test Game");
		game.setDisplayMode(1024,720);
		game.start();
	}

}
