package engine.JWolf2D.level;


import engine.JWolf2D.geom.Rectangle2;
import engine.JWolf2D.logic.PlayerBase;
import engine.JWolf2D.logic.GameObject;
import engine.JWolf2D.util.Bag;

public class Layer {
	public Bag<PlayerBase> entities;
	public Bag<GameObject> objects;
	private String name;
	private float gravity;
	private Level level;
	
	public Layer(String name, Level level) {
		this.level = level;
		this.name = name;
		entities = new Bag<PlayerBase>();
		objects = new Bag<GameObject>();
		gravity = 0.5f;
	}
	
	public String getName() {
		return name;
	}
	
	public void addEntity(PlayerBase e) {
		entities.add(e);
	}
	
	public boolean removeEntity(PlayerBase e) {
		return entities.remove(e);
	}
	
	public void addObject(GameObject o) {
		objects.add(o);
	}
	
	public boolean removeObject(GameObject o) {
		return objects.remove(o);
	}
	
	public void update(long deltaTime) {
		for(PlayerBase e : entities) {
			e.update(deltaTime);
		}
		for(GameObject o : objects) {
			o.update(deltaTime);
		}
	}
	
	public void render() {
		for(PlayerBase e : entities) {
			e.render();
		}
		for(GameObject o : objects) {
			o.render();
		}
	}
	
	public boolean collidesWithEntities(Rectangle2 rect) {
		for(PlayerBase e : entities) {
			if(e.collides(rect)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collidesWithObjects(Rectangle2 rect) {
		for(GameObject o : objects) {
			if(o.collides(rect)) {
				return true;
			}
		}
		return false;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setGravity(float g) {
		gravity = g;
	}
	
	public float getGravity() {
		return gravity;
	}
	
	public GameObject getCollidesWithObject(Rectangle2 rect) {
		for(GameObject o : objects) {
			if(o.collides(rect)) {
				return o;
			}
		}
		return null;
	}
}
