package control;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import gui.Draw;
import menu.MainMenu;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;

public class App extends PApplet {

    // Constants
    public static final int MIN_WIDTH = 250;
    public static final int MIN_HEIGHT = 175;
    public static final int INITIAL_WIDTH = 1000;
    public static final int INITIAL_HEIGHT = 700;
    
    public static final int TARGET_FPS = 30;

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

    public void settings() {
        size(INITIAL_WIDTH, INITIAL_HEIGHT);
        Draw.setApplet(this);
        lastTime = System.currentTimeMillis();
    }

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
            public void componentResized(ComponentEvent e) {
                jf.setSize(jf.getWidth(), jf.getWidth() * INITIAL_HEIGHT / INITIAL_WIDTH);
            }
        });

        // TODO: Move this call elsewhere       
        menu[0] = new MainMenu(this);;
        menu[1] = new World();
        
        currentView = menu[0];
    }

    public void keyPressed() {
        Controller.keyUpdate(key, true);
    }

    public void keyReleased() {
        Controller.keyUpdate(key, false);
    }
    
    public void mouseClicked() {
        Controller.clickUpdate(mouseX, mouseY);
    }

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
}
