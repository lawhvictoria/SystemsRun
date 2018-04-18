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
		
		float sDim = img.width < img.height ? img.width : img.height;
		
		app.image(	img, 
					xUnscaled / 100f * app.width,		// X
					yUnscaled / 100f * app.height,		// Y
					100 * img.width / sDim,				// Width
					100 * img.height / sDim);			// Height
	}
}
