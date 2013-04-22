package engine.JWolf2D.gui;

import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.resource.Textures;

public class Button extends Clickable {
	private GuiManager manager;
	private Label label;
	
	public Button(Vector2 pos, GuiManager manager, String title) {
		this.texName = "defaultButtonUp";
		this.texNameDown = "defaultButtonDown";
		this.pos = pos;
		init();
		this.manager = manager;
		label = new Label(manager, title, pos.x+((Textures.get().get(texName).getTextureWidth()/2)-6*title.length()), pos.y+9, 12, 18);
		manager.addLabel(label);
	}
	
	public void render() {
		if(down)
			sprite.setTexture(texNameDown);
		else
			sprite.setTexture(texName);
		sprite.render();
	}
	
	public void setDownTexture(String texNameDown) {
		this.texNameDown = texName;
	}
	
	public void setUpTexture(String texName) {
		this.texName = texName;
	}
}
