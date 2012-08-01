package engine.JWolf2D.level;

import engine.JWolf2D.util.Bag;

public class Level {
	private Bag<Layer> layers;
	private String name;
	
	public Level(String name) {
	this.name = name;	
	}
	
	public void save(String filePath) {
		
	}
	
	public void load(String filePath) {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void addLayer(Layer l) {
		layers.add(l);
	}
	
	public void removeLayer(Layer l) {
		layers.remove(l);
	}
	
	public void update(long deltaTime) {
		for(Layer l : layers) {
			l.update(deltaTime);
		}
	}
	
	public void render() {
		for(Layer l : layers) {
			l.render();
		}
	}
}
