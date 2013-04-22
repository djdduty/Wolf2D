package engine.JWolf2D.gui;

import engine.JWolf2D.geom.Vector2;

public class Label {
	private String content;
	private GuiManager manager;
	private Vector2 pos, size;
	
	public Label(GuiManager manager, String content, float x, float y, int width, int height) {
		this.manager = manager;
		this.content = content;
		pos = new Vector2(x,y);
		size = new Vector2(width,height);
	}

	public void render() {
		manager.getFont().drawString(content, pos.x, pos.y, size.x, size.y);
	}

}
