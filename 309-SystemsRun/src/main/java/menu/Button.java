package menu;

import gui.Draw;
import gui.Drawable;
import processing.core.PImage;

public abstract class Button implements Drawable{
    
    private PImage imgDefault;
    private PImage imgHover;
    private PImage imgClicked;    
    private PImage imgCurrent;
    
    private boolean clicked;
    
    private int x;
    private int y;
    
    public Button(String imgDefaultSrc, String imgHoverSrc, String imgClickedSrc) {
        imgDefault = Draw.loadImage(imgDefaultSrc);
        imgHover = Draw.loadImage(imgHoverSrc);
        imgClicked = Draw.loadImage(imgClickedSrc);
        
        imgCurrent = imgDefault;        
        clicked = false;
    }
    
    public void onClick() {
        clicked = !clicked;
        
        if(clicked) {
            imgCurrent = imgClicked;
        }
        else {
            imgCurrent = imgDefault;
        }
        
        onClickAction(clicked);
    }
    
    public abstract void onClickAction(boolean clicked);
    
    public boolean getClicked() {
        return clicked;
    }
    
    @Override
    public void draw() {
        Draw.drawImage(imgCurrent, x, y);
    }
    
}
