package game.rpg.genericgame;

import org.lwjgl.input.Keyboard;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;

public class MenuScreen implements Screen{
	private ScreenManager manager;
	
	public void init(ScreenManager manager) {
		this.manager = manager;
	}

	public void update(long deltaTime) {
		if(Keyboard.isKeyDown(Keyboard.KEY_P)) {
			manager.setScreen(new GameScreen());
		}
	}

	public void render() {
		
	}

}
