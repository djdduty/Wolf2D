package engine.JWolf2D.core;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Game {
	private StateManager manager;
	
	static {
		if(System.getProperty("os.name").startsWith("Win")) {
			new Thread() {
				{
					setDaemon(true);
					start();
				}
				
				public void run() {
					while(true) {
						try {
							Thread.sleep(Long.MAX_VALUE);
						}
						catch(Exception exc) {}
					}
				}
			};
		}
	}
	
	public Game(State initialState) {
		manager = new StateManager(initialState);
	}
	
	public void setTitle(String title) {
		Display.setTitle(title);
	}
	
	public void setDisplayMode(int width, int height) throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(width,height));
	}
	
	public int getWidth() {
		return Display.getWidth();
	}
	
	public int getHeight() {
		return Display.getHeight();
	}
	
	public StateManager getStateManager() {
		return manager;
	}
	
	public void start() throws LWJGLException {
		Display.create();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_ALPHA_TEST);	
		//glEnable(GL_DEPTH_TEST);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		try {
			manager.init(this);
			
			long lastTime = System.nanoTime();
			int frames = 0;
			long lastSecond = System.nanoTime();
			
			while (!Display.isCloseRequested()) {
				long now = System.nanoTime();
				
				glClear(GL_COLOR_BUFFER_BIT);
				
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
					break;
				
				long deltaTime = System.nanoTime()-lastTime;
				lastTime += 1e9/60.0;
				
				manager.update(deltaTime);
				manager.render();
				
				Display.update();
				
				frames++;
				
				if(System.nanoTime()-lastSecond >= 1e9) {
					System.out.println(frames);
					frames = 0;
					lastSecond += 1e9;
				}
				
				long sleepTime = (int)Math.round(1e9/60.0 - (System.nanoTime() - now));
				if(sleepTime > 0) {
					long time = System.nanoTime();
					long timePassed;
					while((timePassed = System.nanoTime() - time) < sleepTime) {
						if(timePassed < sleepTime * 0.8)
							try{
								Thread.sleep(1);
							}
							catch(Exception exc) {}
						else
							Thread.yield();
					}
				}
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			Display.destroy();
		}
	}
}


