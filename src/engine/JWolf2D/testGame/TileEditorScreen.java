package engine.JWolf2D.testGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.AnimatedSprite;
import engine.JWolf2D.graphic.Sprite;
import engine.JWolf2D.level.Layer;
import engine.JWolf2D.level.Level;
import engine.JWolf2D.logic.GameObject;
import engine.JWolf2D.logic.Player;
import engine.JWolf2D.resource.Textures;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;

public class TileEditorScreen implements Screen{
	private ScreenManager manager;
	private Level level;
	private Layer layer;
	private Sprite testSprite;
	private Vector2 preview;
	
	public TileEditorScreen() {
	
	}
	
	public void init(ScreenManager manager) {
		this.manager = manager;
		preview = new Vector2(Mouse.getX(), (Mouse.getY()*-1)+Display.getHeight());
		testSprite = new Sprite(new Vector2(Mouse.getX(), Mouse.getY()), "lolnulltex");
		level = new Level("test");
		layer = new Layer("main", level);
		level.addLayer(layer);
		level.setMainLayer(layer);
		
	}

	public void update(long deltaTime) {
		
		//update preview
		int posX = Mouse.getX();
		preview.x = (posX-=posX%testSprite.getWidth()) + testSprite.getWidth()/2 - testSprite.getWidth()/2%testSprite.getWidth();
		
		int posY = (int) ((Mouse.getY()*-1)+Display.getHeight() + testSprite.getHeight()/2 - testSprite.getHeight()/2%testSprite.getHeight());
		preview.y = posY-=posY%testSprite.getHeight();
		
		
		//input
		while(Keyboard.next()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				level.save();
			}
		}
		
		while(Mouse.next()) {
			if(Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
				System.out.println("clicked, X:" + Mouse.getX() + ", Y:" + Mouse.getY());
				layer.addObject(new GameObject(new Vector2(preview.x, preview.y), "nulltex"));//y this no work
			}
		}
		
		//update things
		level.update(deltaTime);
		testSprite.setPos(preview);
	}
	
	public void render() {
		level.render();
		testSprite.render();
	}
}
