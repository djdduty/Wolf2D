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
		
		//Textures.get().add("test", "res/images/test/test.png");
		level = new Level("test");
		/*Layer layer = new Layer("main");
		level.addLayer(layer);
		layer.addObject(new GameObject(new Vector2(304,284), "test"));
		layer.addObject(new GameObject(new Vector2(336,284), "test"));
		layer.addObject(new GameObject(new Vector2(368,284), "test"));
		layer.addObject(new GameObject(new Vector2(400,284), "test"));
		layer.addObject(new GameObject(new Vector2(432,284), "test"));
		layer.addObject(new GameObject(new Vector2(528,284), "test"));
		layer.addObject(new GameObject(new Vector2(560,284), "test"));
		layer.addObject(new GameObject(new Vector2(592,284), "test"));
		layer.addObject(new GameObject(new Vector2(624,284), "test"));
		layer.addObject(new GameObject(new Vector2(656,284), "test"));

		layer.addObject(new GameObject(new Vector2(304,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(336,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(368,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(400,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(432,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(304,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(336,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(368,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(400,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(432,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(528,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(560,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(592,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(624,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(656,284-128), "test"));
		layer.addObject(new GameObject(new Vector2(528,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(560,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(592,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(624,316-128), "test"));
		layer.addObject(new GameObject(new Vector2(656,316-128), "test"));
		

		layer.addObject(new GameObject(new Vector2(528,348), "test"));
		layer.addObject(new GameObject(new Vector2(560,348), "test"));
		layer.addObject(new GameObject(new Vector2(592,348), "test"));
		layer.addObject(new GameObject(new Vector2(624,348), "test"));
		layer.addObject(new GameObject(new Vector2(656,348), "test"));
		layer.addObject(new GameObject(new Vector2(304,348), "test"));
		layer.addObject(new GameObject(new Vector2(336,348), "test"));
		layer.addObject(new GameObject(new Vector2(368,348), "test"));
		layer.addObject(new GameObject(new Vector2(400,348), "test"));
		layer.addObject(new GameObject(new Vector2(432,348), "test"));
		layer.addObject(new GameObject(new Vector2(464,348), "test"));
		layer.addObject(new GameObject(new Vector2(496,348), "test"));
		
		level.setMainLayer(layer);*/
		level.load("src/res/test.xml");

		Textures.get().add("player", "res/images/test/Aliens.png");
		test = new PlayerExample(new Vector2(400, 232), "player", level.getMainLayer());
		
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
