package control;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import gui.Draw;
import gui.Drawable;
import highscore.HighScore;
import menu.CharacterMenu;
import menu.MainMenu;
import menu.SettingsMenu;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;

public class App extends PApplet implements Drawable{

    // Constants
    public static final int MIN_WIDTH = 250;
    public static final int MIN_HEIGHT = 175;
    public static final int INITIAL_WIDTH = 1000;
    public static final int INITIAL_HEIGHT = 700;
    
    public static final int TARGET_FPS = 30;

    // Private Instance
    private DrawGroup[] menu = new DrawGroup[5];
    private DrawGroup currentView;
    
    private int fCount = 0;
    private long lastTime;
    private int fps = 0;
    

    // Main
    public static void main(String[] args) {
        PApplet.main("control.App");
    }
    
    @Override
    public void settings() {
        size(INITIAL_WIDTH, INITIAL_HEIGHT);
        Draw.setApplet(this);
        lastTime = System.currentTimeMillis();
    }

    @Override
    public void setup() {
        surface.setTitle("Systems Run");

        // Setup minimum window dimensions, allow resize of window
        SmoothCanvas sc = (SmoothCanvas) getSurface().getNative();
        final JFrame jf = (JFrame) sc.getFrame();
        Dimension d = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        jf.setMinimumSize(d);
        surface.setResizable(true);

        // Lock screen aspect
        jf.addComponentListener(new ComponentAdapter() {
        	@Override
            public void componentResized(ComponentEvent e) {
                jf.setSize(jf.getWidth(), jf.getWidth() * INITIAL_HEIGHT / INITIAL_WIDTH);
            }
        });
        
        menu[0] = new MainMenu(this);
        menu[1] = new World();
        menu[2] = new SettingsMenu(this);
        menu[3] = new CharacterMenu(this);
        menu[4] = new HighScore(this);
        
        currentView = menu[0];        
    }

    @Override
    public void keyPressed() {
        Controller.keyUpdate(key, true);
    }
    
    @Override
    public void keyReleased() {
        Controller.keyUpdate(key, false);
    }
    
    @Override
    public void mouseClicked() {
        Controller.clickUpdate(mouseX, mouseY);
    }
    
    @Override
    public void draw() {
        background(200, 200, 200);
        currentView.update();
        fCount++;
        if(System.currentTimeMillis() - lastTime >= 1000) {
            surface.setTitle("Systems Run [FPS: " + fCount + "]");
            lastTime = System.currentTimeMillis();
            fps = fCount;
            fCount = 0;            
        }
    }
    
    public static float toWorldX(float in) {
        return in  / Draw.getWidth()  * 100;
    }
    
    public static float toWorldY(float in) {
        return in  / Draw.getHeight()  * 100;
    }
    
    public static float toRealX(float in) {
        return in * Draw.getWidth() / 100;
    }
    
    public static float toRealY(float in) {
        return in * Draw.getHeight() / 100;
    }
    
    public void loadDrawGroup(int state) {
        currentView = menu[state];
    }
    
    public int getFPS() {
        return fps;
    }
    
    public void close() {
        exit();
    }
}
