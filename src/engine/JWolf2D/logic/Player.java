package engine.JWolf2D.logic;

import org.lwjgl.input.Keyboard;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.AnimatedSprite;
import engine.JWolf2D.level.Layer;
import engine.JWolf2D.resource.Textures;

public class Player extends PlayerBase{
	private float xMoveSpeed;
	private int timer = 0, fx = 0, row=0;
	private AnimatedSprite aSprite;
	private String dir = "right";
	private boolean idle;
	
	public Player(Vector2 pos, String textureName, Layer l) {
		super(pos, textureName, l);
		Textures.get().add("player", "res/images/test/Aliens.png");
		aSprite = new AnimatedSprite(textureName, 32, 30, pos);
		size = new Vector2(28, 30);
	}

	public void update(long deltaTime) {
		xMoveSpeed = 0;
		row=0;
		idle = true;
		gravity = layer.getGravity();
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xMoveSpeed = -200.0f*(deltaTime/1000.0f);
			row=1;
			dir = "left";
			idle = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xMoveSpeed = 200.0f*(deltaTime/1000.0f);
			row=1;
			dir = "right";
			idle = false;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W) && jumping == false) {
			yVelocity = -8;
		}
		
		addVelocity(xMoveSpeed, 0);
		checkCollision();
	}
	
	public void render() {
		timer++;
		if(timer >= 10) {
			timer = 0;
			if(fx < 4 && idle == false) {
				fx++;
			}else {
				fx = 0;
			}
		}
		aSprite.render(fx, row, dir);
	}
}
