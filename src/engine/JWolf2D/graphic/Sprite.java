package engine.JWolf2D.graphic;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.resource.Textures;

public class Sprite {
	private Vector2 pos;
	private Texture texture;
	private int wScale, hScale;
	
	public Sprite(Vector2 pos, String texName) {
		this.pos = pos;
		wScale = 1;
		hScale = 1;
		this.setTexture(texName);
	}
	
	public Sprite(Vector2 pos, String texName, int scaleWidthPercent, int scaleHeightPercent) {
		this.pos = pos;
		wScale = scaleWidthPercent/100;
		hScale = scaleHeightPercent/100;
		this.setTexture(texName);
	}
	
	public void render() {
		glEnable(GL_TEXTURE_2D);
		texture.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0,0);
			glVertex2f(pos.x,pos.y);
			glTexCoord2f(1,0);
			glVertex2f(pos.x+getWidth(),pos.y);
			glTexCoord2f(1,1);
			glVertex2f(pos.x+getWidth(),pos.y+getHeight());
			glTexCoord2f(0,1);
			glVertex2f(pos.x,pos.y+getHeight());
		glEnd();
		
		glDisable(GL_TEXTURE_2D);
	}
	
	public Vector2 getPos() {
		return pos;
	}
	
	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
	
	public float getWidth() {
		return texture.getTextureWidth() * wScale;
	}
	
	public float getHeight() {
		return texture.getTextureHeight() * hScale;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(String name) {
		texture = Textures.get().get(name);
		
		if(texture == null)
			throw new NullPointerException("Texture not found.");
	}
	
	public String getTextureName() {
		return Textures.get().getName(texture);
	}
}
