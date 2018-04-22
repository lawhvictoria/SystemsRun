import processing.core.*;

public class Draw {
	
	public final static float DEPTH_MIN = .7f;
	public final static float DEPTH_MAX = 1.0f;
	
	public static int dim = 1;
	
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
		
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {

				drawImageCopy(img, xUnscaled, yUnscaled, z, i*100f/dim, j*100f/dim, (float)1/dim);

			}
		}
		
		
		
	}
	
	private static void drawImageCopy(PImage img, float xUnscaled, float yUnscaled, float z, float xOffset, float yOffset, float scale) {
		z = DEPTH_MIN + (DEPTH_MAX - DEPTH_MIN) * z / 100;
		//System.out.println(xOffset + " " + yOffset);
		app.imageMode(PImage.CENTER);
		app.image(	img, 
					(xOffset + xUnscaled*scale) / 100f * app.width,							// X
					(yOffset + yUnscaled*scale) / 100f * app.height,							// Y
					(float)app.width/App.INITIAL_WIDTH * img.width * z * scale,			// Width
					(float)app.height/App.INITIAL_HEIGHT * img.height * z * scale);		// Height
	}
	
	public static void drawRect(	float xUnscaled, float yUnscaled, 
								float widthUnscaled, float heighUnscaled) {
		
		app.rect( xUnscaled / 100f * app.width, yUnscaled / 100f * app.height, 
				(float) app.width/App.INITIAL_WIDTH * widthUnscaled, 
				(float) app.height/App.INITIAL_HEIGHT * heighUnscaled);
		
	}
	
	
	public static float getZDepth(float y) {
		return (float)app.height/App.INITIAL_HEIGHT * y;
	}
}
