package engine.JWolf2D.testGame;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import engine.JWolf2D.core.Screen;
import engine.JWolf2D.core.ScreenManager;
import engine.JWolf2D.geom.Vector2;
import engine.JWolf2D.gui.*;

public class MenuScreen implements Screen{
	private GuiManager gui;
	private ScreenManager manager;
	private Button playButton, editorButton, optionsButton, exitButton;
	
	public void init(ScreenManager manager) {
		this.manager = manager;
		gui = new GuiManager("res/images/gui/8bitbig.png");
		
		playButton = new Button(new Vector2(Display.getWidth()/2-64, Display.getHeight()/2-49), gui, "Play");
		editorButton = new Button(new Vector2(Display.getWidth()/2-64, Display.getHeight()/2-16), gui, "Editor");
		optionsButton = new Button(new Vector2(Display.getWidth()/2-64, Display.getHeight()/2+17), gui, "Options");
		exitButton = new Button(new Vector2(Display.getWidth()/2-64, Display.getHeight()/2+50), gui, "Exit");
		
		gui.addLabel(new Label(gui, "Main Menu!", Display.getWidth()/2-150, 200, 40, 40));
		gui.addLabel(new Label(gui, "abcde 1234567890!?", 10, 100, 40, 40));
		gui.addButton(playButton);
		gui.addButton(editorButton);
		gui.addButton(optionsButton);
		gui.addButton(exitButton);
	}

	public void update(long deltaTime) {
		while(Mouse.next()) {
			gui.update();
		}
		
		if(playButton.clicked()) {
			System.out.println("Going so soon?");
			manager.setScreen(new GameScreen());
		}
		
		if(editorButton.clicked()) {
			System.out.println("Make me some shiz!");
			manager.setScreen(new EditorScreen());
		}
		
		if(optionsButton.clicked()) {
			System.out.println("Coming soon!");
		}
		
		if(exitButton.clicked()) {
			System.out.println("Bye bye!");
			manager.getGame().requestClose();
		}
	}

	public void render() {
		gui.render();
	}
	
}
