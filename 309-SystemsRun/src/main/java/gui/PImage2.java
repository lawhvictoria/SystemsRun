package gui;

import control.App;
import processing.core.PApplet;
import processing.core.PImage;

public class PImage2{
    
    PImage imgs[];
    private int current = 0;
    private int frameSkip;
    private int curSkip = 0;
    
    public PImage2(int frameSkip, String ...imgSrcs) {
        this.frameSkip = frameSkip * App.TARGET_FPS;
        imgs = new PImage[imgSrcs.length];
        for(int i = 0; i < imgSrcs.length; i++) {
            imgs[i] = Draw.loadImage(imgSrcs[i]);
        }
    }
    
    public PImage getImage(){
        if(current >= imgs.length) {
            current = 0;
        }
        
        if(curSkip++ >= (float) frameSkip / (float)App.fps) {
            curSkip = 0;
            return imgs[current++];
        }
        return imgs[current];
    }
    
    
}
