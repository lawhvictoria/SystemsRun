import processing.core.*;

public class Draw {
	
	public final static float DEPTH_MIN = .7f;
	public final static float DEPTH_MAX = 1.0f;
	
	private static PApplet app;
	
	public static void setApplet(PApplet applet) {
		
		app = applet;
	}
	
	public static PImage loadImage(String imgRef) {
		
		return app.loadImage(imgRef);
	}

	public static void drawImage(PImage img, float xUnscaled, float yUnscaled) {
		drawImage(img, xUnscaled, yUnscaled, 100);
	}
	
	public static void drawImage(PImage img, float xUnscaled, float yUnscaled, float z) {	
		
		z = DEPTH_MIN + (DEPTH_MAX - DEPTH_MIN) * z / 100;
		
		app.imageMode(PImage.CENTER);
		app.image(	img, 
					xUnscaled / 100f * app.width,							// X
					yUnscaled / 100f * app.height,							// Y
					(float)app.width/App.INITIAL_WIDTH * img.width * z,		// Width
					(float)app.height/App.INITIAL_HEIGHT * img.height * z);	// Height
	}
	
	public static void drawRect(	float xUnscaled, float yUnscaled, 
								float widthUnscaled, float heighUnscaled) {
		
		app.rect( xUnscaled / 100f * app.width, yUnscaled / 100f * app.height, 
				(float) app.width/App.INITIAL_WIDTH * widthUnscaled, 
				(float) app.height/App.INITIAL_HEIGHT * heighUnscaled);
		
	}
	
	public static float getXScaleFactor() {
		return (float)app.width/App.INITIAL_WIDTH;
	}
	
	public static float getYScaleFactor() {
		return (float)app.height/App.INITIAL_HEIGHT;
	}
	
	public static float getZDepth(float y) {
		return (float)app.height/App.INITIAL_HEIGHT * y;
	}
}
