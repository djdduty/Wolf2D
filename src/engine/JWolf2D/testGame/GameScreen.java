package engine.JWolf2D.testGame;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.gui.Button;
import engine.JWolf2D.gui.CheckBox;
import engine.JWolf2D.gui.GuiManager;
import engine.JWolf2D.gui.Label;
import engine.JWolf2D.level.Level;
import engine.JWolf2D.logic.EnemyExample;
import engine.JWolf2D.logic.Player;
import engine.JWolf2D.resource.Textures;

public class GameScreen implements Screen{
	private Level level;
	private Player player;
	private ScreenManager manager;
	private EnemyExample enemy;
	private GuiManager gui;
	
	public void init(ScreenManager manager) {
		this.manager = manager;
		gui = new GuiManager("res/images/gui/font.png");
		
		level = new Level("level");
		level.load("src/res/test.xml");
		
		Textures.get().add("player", "res/images/test/Aliens.png");
		player = new Player(new Vector2(400,332), "player", level.getMainLayer());
		level.setPlayer(player);
		
		enemy = new EnemyExample(new Vector2(400,332), level.getMainLayer());
	}

	public void update(long deltaTime) {
		level.update(deltaTime);
		player.update(deltaTime);
		enemy.update(deltaTime);
		
		while(Keyboard.next()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_E)) {
				manager.setScreen(new TileEditorScreen());
			}
		}
		while(Mouse.next()) {
			gui.update();
		}
	}

	public void render() {
		level.render();
		player.render();
		enemy.render();
		gui.render();
	}
}
