package menu;

import control.App;
import gui.Draw;
import gui.Drawable;
import gui.PImage2;

public class Background implements Drawable{

    private PImage2 img;
   
    
    public Background(String ...imgSrc) {
        img = new PImage2(3, imgSrc);
        
                //Draw.loadImage(imgSrc);
    }
    
//    @Override
    public void draw() {
        Draw.drawImage(img.getImage());
    }
}
