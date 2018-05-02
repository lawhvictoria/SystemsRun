package gui;
import control.App;
import processing.core.*;

public class Draw {

    // Constants
    public final static float DEPTH_MIN = .6f;
    public final static float DEPTH_MAX = 1.0f;

    // Private Static
    private static int dim = 1;
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

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                drawImageCopy(img, xUnscaled, yUnscaled, z, i * 100f / dim, j * 100f / dim, (float) 1 / dim);
            }
        }
    }

    private static void drawImageCopy(PImage img, float xUnscaled, float yUnscaled, float z, float xOffset,
                                      float yOffset, float scale) {

        z = DEPTH_MIN + (DEPTH_MAX - DEPTH_MIN) * z / 100;
        app.imageMode(PImage.CENTER);
        app.image(img, (xOffset + xUnscaled * scale) / 100f * app.width,            // X
                (yOffset + yUnscaled * scale) / 100f * app.height,                  // Y
                (float) app.width / App.INITIAL_WIDTH * img.width * z * scale,      // Width
                (float) app.height / App.INITIAL_HEIGHT * img.height * z * scale);  // Height
    }

    public static void drawRect(float xUnscaled, float yUnscaled, float widthUnscaled, float heighUnscaled, int r,
                                int g, int b) {

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                drawRectCopy(xUnscaled, yUnscaled, 
                             widthUnscaled, heighUnscaled, i * 100f / dim, j * 100f / dim,
                             (float) 1 / dim, r, g, b);
            }
        }
    }

    private static void drawRectCopy(float xUnscaled, float yUnscaled, float widthUnscaled, float heighUnscaled,
                                     float xOffset, float yOffset, float scale, int r, int g, int b) {

        app.fill(r, g, b);
        app.rect((xOffset + xUnscaled * scale) / 100f * app.width,          // X
                (yOffset + yUnscaled * scale) / 100f * app.height,          // Y
                (float) app.width / App.INITIAL_WIDTH * widthUnscaled,      // Width
                (float) app.height / App.INITIAL_HEIGHT * heighUnscaled);   // Height
    }

    public static float getZDepth(float y) {
        return (float) app.height / App.INITIAL_HEIGHT * y;
    }

    public static void addDimension() {
        dim++;
    }

    public static boolean subtractDimension() {
        
        if (dim - 1 >= 1) {
            dim--;
            return true;
        }
        return false;
    }
}
