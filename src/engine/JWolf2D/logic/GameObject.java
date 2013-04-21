package engine.JWolf2D.logic;

import engine.JWolf2D.geom.Rectangle2;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.graphic.Sprite;
import engine.JWolf2D.level.Layer;

public class GameObject {
	private Vector2 pos, size;
	private Sprite texture;
	private float xDiff, yDiff;
	private Layer layer;
	private boolean isCollide;
	
	public GameObject(Vector2 pos, String texName) {
		this.pos = pos;
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
		size = new Vector2(texture.getWidth(), texture.getHeight());
		texture.setPos(pos);
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
