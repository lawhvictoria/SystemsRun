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
    PImage img2;
    PImage img3;
    PImage dimg;

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
    		dimg = loadImage("src/images/playBackground.gif");
    		img = loadImage("src/images/mainScreen.png");
    		img2 = loadImage("src/images/characterSettings.png");
    		img3 = loadImage("src/images/highscores.png");
    		
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
    		fill(204, 102, 0);
    		rect(425, 125, 450, 300);
    		if (state == 0) {
    			image(img, 0, 0);
    			fill(204, 102, 0);
        		//rect(352, 408, 272, 100);
        		//rect(398, 525, 184, 68);
        		//rect(398, 603, 184,68);
        		//rect(23, 610, 173, 68);
    			//ellipse(946, 646, 80, 80);
    		}
    		
    		if(state == 1) {
    			//image(dimg, 0, 0);
    			background(200, 200, 200);
    	        world.update();
    		}
    		
    		if(state == 2) {
    			image(img2, 0, 0);
    		}
    		
    		if(state == 3) {
    			image(img3, 0, 0);
    		}
    		
    }
    
    public void mousePressed() {
    		if (mouseX < 624 & mouseX > 352 & mouseY < 508 & mouseY > 408 ) {
    			click = true;
    			state = 1;
    		}
    		
    		if (mouseX < 582 & mouseX > 398 & mouseY < 593 & mouseY > 525 ) {
    			click = true;
    			state = 2;
    		}
    		
    		if (mouseX < 582 & mouseX > 398 & mouseY < 671 & mouseY > 603 ) {
    			click = true;
    			state = 3;
    		}
    		
    		if (mouseX < 1026 & mouseX > 946 & mouseY < 726 & mouseY > 646 ) {
    			click = true;
    			state = 0;
    		}
    	}
}
