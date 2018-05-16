package control;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import gui.Draw;
import gui.Drawable;
import menu.Background;
import menu.CharacterMenu;
import menu.MainMenu;
import menu.PlayMenu;
import menu.SettingsMenu;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet implements Drawable{

    // Constants
    public static final int MIN_WIDTH = 250;
    public static final int MIN_HEIGHT = 175;
    public static final int INITIAL_WIDTH = 1000;
    public static final int INITIAL_HEIGHT = 700;
    
    public static final int TARGET_FPS = 30;
    
    public PImage img;

    // Private Instance
    //private World world; // TODO: Move this elsewhere
    private DrawGroup[] menu = new DrawGroup[5];
    public DrawGroup currentView;
    
    private int frameCount = 0;
    private long lastTime;
    public static int fps = 0;
    

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

        img = loadImage("src/images/PlayOverlay.png");
        
        // TODO: Move this call elsewhere       
        menu[0] = new MainMenu(this);
        menu[1] = new World();
//        menu[1] = new PlayMenu(this);
        menu[2] = new SettingsMenu(this);
        menu[3] = new CharacterMenu(this);
        
        currentView = menu[0];
        
     
//        menu[1] = image1.blend(image2, 0, 0, image2.width, image2.height, 0, 0, image2.width, image2.height, ADD);

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
        frameCount++;
        if(System.currentTimeMillis() - lastTime >= 1000) {
            surface.setTitle("Systems Run [FPS: " + frameCount + "]");
            lastTime = System.currentTimeMillis();
            fps = frameCount;
            frameCount = 0;            
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
    
    public void close() {
        exit();
    }
}
