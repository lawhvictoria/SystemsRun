import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;


public class App extends PApplet
{
	public static final int MIN_WIDTH = 250;
	public static final int MIN_HEIGHT = 175;
	public static final int INITIAL_WIDTH = 1000;
	public static final int INITIAL_HEIGHT = 700;
	
	World world; // Put this somewhere else later
	
    public static void main( String[] args )
    {
    		PApplet.main("App");    		
    }
    
    public void settings(){
        size(INITIAL_WIDTH, INITIAL_HEIGHT);    
        Draw.setApplet(this);
    }

    public void setup(){
    	
    		// Background color and window name
        fill(120,50,240);
        surface.setTitle("Systems Run");
        
        // Setup minimum window dimensions, allow resize of window
        SmoothCanvas sc = (SmoothCanvas) getSurface().getNative();
        JFrame jf = (JFrame) sc.getFrame();
        Dimension d = new Dimension(MIN_WIDTH, MIN_HEIGHT);
        jf.setMinimumSize(d);
        surface.setResizable(true);
        
        
        // Put this somewhere else 
        world = new World();
    }

    public void draw(){
    		world.update();
    }
    
}
