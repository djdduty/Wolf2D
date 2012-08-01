package engine.JWolf2D.logic;

import org.lwjgl.input.Keyboard;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.AnimatedSprite;
import engine.JWolf2D.level.Layer;
import engine.JWolf2D.resource.Textures;

public class PlayerExample extends Entity{
	private int xMoveSpeed, timer = 0, fx = 0, row=0;
	private AnimatedSprite aSprite;
	private String dir = "right";
	public PlayerExample(Vector2 pos, String textureName, Layer l) {
		super(pos, textureName, l);
		Textures.get().add("player", "res/images/test/Aliens.png");
		aSprite = new AnimatedSprite(textureName, 32, 32, pos);
		size = new Vector2(32, 32);
	}

	public void update(long deltaTime) {
		xMoveSpeed = 0;
		row=0;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xMoveSpeed = -4;
			row=3;
			dir = "left";
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xMoveSpeed = 4;
			row=3;
			dir = "right";
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W) && jumping == false) {
			yVelocity = -7;
		}
		
		addVelocity(xMoveSpeed, 0);
		checkCollision();
	}
	
	public void render() {
		timer++;
		if(timer >= 10) {
			timer = 0;
			if(fx < 4) {
				fx++;
			}else {
				fx = 0;
			}
		}
		aSprite.render(fx, row, dir);
	}
}
