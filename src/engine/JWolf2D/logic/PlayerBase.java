package engine.JWolf2D.logic;

import engine.JWolf2D.geom.Rectangle2;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.Sprite;
import engine.JWolf2D.level.Layer;

public class PlayerBase {
	protected Vector2 pos, size;
	private Sprite texture;
	protected float xVelocity, yVelocity;
	protected Layer layer;
	protected float gravity=0.5f;
	private boolean isCollide=false;
	protected boolean jumping=true;
	
	public PlayerBase(Vector2 pos, String texName, Layer l) {
		this.pos = pos;
		layer = l;
		texture = new Sprite(pos, texName);
		size = new Vector2(texture.getWidth(), texture.getHeight());
	}
	
	public Vector2 getPos() {
		return pos;
	}
	
	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	
	public void update(long deltaTime) {
		texture.setPos(pos);
		checkCollision();
		xVelocity = 0;
		gravity = layer.getGravity();
	}
	
	protected void checkCollision() {
		float oldX = pos.x;
		float oldY = pos.y;
		
		pos.x += xVelocity;
		if(layer.collidesWithObjects(new Rectangle2(pos, size))) {
			pos.x = oldX;
		}
		xVelocity = 0;
		pos.y += yVelocity;
		if(layer.collidesWithObjects(new Rectangle2(pos, size))) {
			if(layer.collidesWithObjects(new Rectangle2(new Vector2(pos.x+6, pos.y+12), new Vector2(size.x-12, size.y-10)))) {
				jumping = false;
				oldY = layer.getCollidesWithObject(new Rectangle2(pos, size)).getPos().y-(size.y);
			}
			pos.y = oldY;
			yVelocity = 0;
		}else {
			jumping = true;
			if(yVelocity < 10) {
				yVelocity += gravity;
			}
		}
	}
	
	public void addVelocity(float xMoveSpeed, float yAmount) {
		xVelocity += xMoveSpeed;
		yVelocity += yAmount;
	}
	
	public boolean collides(Rectangle2 rect) {
		isCollide = rect.intersects(new Rectangle2(pos, size));
		return isCollide;
	}
	
	public void render() {
		texture.render();
	}
	
	public Vector2 getSize() {
		return size;
	}
}
