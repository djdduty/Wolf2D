package engine.JWolf2D.testGame;

import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.AnimatedSprite;
import engine.JWolf2D.level.Layer;
import engine.JWolf2D.logic.GameObject;
import engine.JWolf2D.logic.PlayerExample;
import engine.JWolf2D.resource.Textures;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;

public class GameScreen implements Screen{
	private ScreenManager manager;
	private PlayerExample test;
	private int timer=0, fx;
	private Layer layer;
	
	public GameScreen() {
	
	}
	
	public void init(ScreenManager manager) {
		this.manager = manager;
		
		Textures.get().add("test", "res/images/test/test.png");
		layer = new Layer("test");
		layer.addObject(new GameObject(new Vector2(400-96,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(400-64,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(400-32,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(400,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(432,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(400-96,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(400-64,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(400-32,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(400,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(432,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+32,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+64,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96+32,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96+64,300-16), "test"));
		layer.addObject(new GameObject(new Vector2(496+32,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(496+64,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96+32,300+16), "test"));
		layer.addObject(new GameObject(new Vector2(496+96+64,300+16), "test"));

		Textures.get().add("player", "res/images/test/Aliens.png");
		test = new PlayerExample(new Vector2(400, 300-64), "player", layer);
		
	}

	public void update(long deltaTime) {
		test.update(deltaTime);
	}

	public void render() {
		
		/*timer++;
		if(timer >= 10) {
			timer = 0;
			if(fx < 4) {
				fx++;
			}else {
				fx = 0;
			}
		}
		test.render(fx, 3);*/
		layer.render();
		test.render();
	}
}
