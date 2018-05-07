package control;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

import gui.Draw;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {

    // Constants
    public static final int MIN_WIDTH = 250;
    public static final int MIN_HEIGHT = 175;
    public static final int INITIAL_WIDTH = 1000;
    public static final int INITIAL_HEIGHT = 700;
    
    // menus
    int state = 0; //The current state
    final int MAIN_MENU = 0;
    final int GAME_MENU = 1;
    final int GAME = 2;
    final int PAUSE = 3;
    boolean click = false;
    PImage img;

    // Private Instance
    private World world; // TODO: Move this elsewhere

    // Main
    public static void main(String[] args) {
        PApplet.main("control.App");

    }
    
    @Override
    public void settings() {
        size(INITIAL_WIDTH, INITIAL_HEIGHT);
        Draw.setApplet(this);
    }

    @Override
    public void setup() {
    		img = loadImage("src/images/mainScreen.png");
    		
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

        // TODO: Move this call elsewhere
        world = new World();
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
    public void draw() {
    		if (state == 0) {
    			image(img, 0, 0);
    		}
    }
    
    public void mousePressed() {
    		if (mouseX < 425 & mouseX > 125 & mouseY <450 & mouseY >300 ) {
    			click = true;
    		}
    	}
}
