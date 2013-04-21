package engine.JWolf2D.level;


import engine.JWolf2D.geom.Rectangle2;
import engine.JWolf2D.logic.Entity;
import engine.JWolf2D.logic.GameObject;
import engine.JWolf2D.util.Bag;

public class Layer {
	public Bag<Entity> entities;
	public Bag<GameObject> objects;
	private String name;
	
	public Layer(String name) {
		this.name = name;
		entities = new Bag<Entity>();
		objects = new Bag<GameObject>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public boolean removeEntity(Entity e) {
		return entities.remove(e);
	}
	
	public void addObject(GameObject o) {
		objects.add(o);
	}
	
	public boolean removeObject(GameObject o) {
		return objects.remove(o);
	}
	
	public void update(long deltaTime) {
		for(Entity e : entities) {
			e.update(deltaTime);
		}
		for(GameObject o : objects) {
			o.update(deltaTime);
		}
	}
	
	public void render() {
		for(Entity e : entities) {
			e.render();
		}
		for(GameObject o : objects) {
			o.render();
		}
	}
	
	public boolean collidesWithEntities(Rectangle2 rect) {
		for(Entity e : entities) {
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
	
	public GameObject getCollidesWithObject(Rectangle2 rect) {
		for(GameObject o : objects) {
			if(o.collides(rect)) {
				return o;
			}
		}
		return null;
	}
}
