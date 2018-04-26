import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;

public class App extends PApplet {

    // Constants
    public static final int MIN_WIDTH = 250;
    public static final int MIN_HEIGHT = 175;
    public static final int INITIAL_WIDTH = 1000;
    public static final int INITIAL_HEIGHT = 700;

    // Private Instance
    private World world; // TODO: Move this elsewhere

    // Main
    public static void main(String[] args) {
        PApplet.main("App");

    }

    public void settings() {
        size(INITIAL_WIDTH, INITIAL_HEIGHT);
        Draw.setApplet(this);
    }

    public void setup() {
        surface.setTitle("Systems Run");

        // Setup minimum window dimensions, allow resize of window
        SmoothCanvas sc = (SmoothCanvas) getSurface().getNative();
        JFrame jf = (JFrame) sc.getFrame();
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
        world = new World();
    }

    public void keyPressed() {
        Controller.keyUpdate(key, true);
    }

    public void keyReleased() {
        Controller.keyUpdate(key, false);
    }

    public void draw() {
        background(200, 200, 200);
        world.update();
    }
}
