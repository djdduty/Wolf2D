package engine.JWolf2D.testGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.lwjgl.input.Keyboard;

import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.AnimatedSprite;
import engine.JWolf2D.level.Layer;
import engine.JWolf2D.level.Level;
import engine.JWolf2D.logic.GameObject;
import engine.JWolf2D.logic.PlayerExample;
import engine.JWolf2D.resource.Textures;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;

public class GameScreen implements Screen{
	private ScreenManager manager;
	private PlayerExample test;
	private int timer=0, fx;
	private Level level;
	
	public GameScreen() {
	
	}
	
	public void init(ScreenManager manager) {
		this.manager = manager;
		
		Textures.get().add("test", "res/images/test/test.png");
		level = new Level("test");
		level.load("src/res/test.xml");

		Textures.get().add("player", "res/images/test/Aliens.png");
		test = new PlayerExample(new Vector2(400, 200), "player", level.getMainLayer());
		
	}

	public void update(long deltaTime) {
		test.update(deltaTime);
		
		while(Keyboard.next()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				level.save();
			}
		}
	}

	public void render() {
		level.render();
		test.render();
	}
}
