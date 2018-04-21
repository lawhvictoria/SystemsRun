import processing.core.*;

public class Draw {
	
	private static PApplet app;
	
	public static void setApplet(PApplet applet) {
		
		app = applet;
	}
	
	public static PImage loadImage(String imgRef) {
		
		return app.loadImage(imgRef);
	}
	
	public static void drawImage(PImage img, float xUnscaled, float yUnscaled) {	
		
		app.image(	img, 
					xUnscaled / 100f * app.width,							// X
					yUnscaled / 100f * app.height,							// Y
					(float)app.width/App.INITIAL_WIDTH * img.width,			// Width
					(float)app.height/App.INITIAL_HEIGHT * img.height);		// Height
	}
	
	public static void drawRect(	float xUnscaled, float yUnscaled, 
								float widthUnscaled, float heighUnscaled) {
		
		app.rect( xUnscaled / 100f * app.width, yUnscaled / 100f * app.height, 
				(float)app.width/App.INITIAL_WIDTH * widthUnscaled, 
				(float)app.height/App.INITIAL_HEIGHT * heighUnscaled);
		
	}
}
