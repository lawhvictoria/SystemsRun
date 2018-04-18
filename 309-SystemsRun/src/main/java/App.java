import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.PApplet;


public class App extends PApplet
{
	public static final int MIN_WIDTH = 300;
	public static final int MIN_HEIGHT = 500;
	public static final int INITIAL_WIDTH = 500;
	public static final int INITIAL_HEIGHT = 700;
	
	Item beer; // Test item
	
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
        
        
        // Test item
        beer = new BeerItem();        
    }

    public void draw(){
    	
    		//Test item
    		beer.x = 10;
    		beer.y = 10;
    		beer.draw();
    }
    
}
