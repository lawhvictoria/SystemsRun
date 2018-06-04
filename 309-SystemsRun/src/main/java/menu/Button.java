package menu;

import control.App;
import control.Controllable;
import control.Controller;
import control.Key;
import gui.Draw;
import gui.Drawable;
import processing.core.PImage;

public abstract class Button implements Drawable, Controllable {
    
    private PImage imgDefault;
    private PImage imgHover;
    private PImage imgClicked;    
    private PImage imgCurrent;
    
    private boolean clicked;
    
    private float x;
    private float y;
    
    protected App app;
    private boolean hover;
    
    protected int delayFrameCount = 0;
    private int delayFrameCountD = delayFrameCount;
    private boolean startCountdown = false;
    
    public Button(App app, float x, float y, String imgDefaultSrc, String imgHoverSrc, String imgClickedSrc) {
        this.x = x;
        this.y = y;
        this.app = app;
        
        imgDefault = Draw.loadImage(imgDefaultSrc);
        imgHover = Draw.loadImage(imgHoverSrc);
        imgClicked = Draw.loadImage(imgClickedSrc);
        
        imgCurrent = imgDefault;        
        clicked = false;
        
        Controller.addListener(this);
    }
    
    protected void setDelay(int frame) {
        delayFrameCount = frame;
        delayFrameCountD = frame;
    }
    
    private void onClick() {
        if(!startCountdown) {
            clicked = !clicked;
            
            if(clicked) {
                imgCurrent = imgClicked;
            }
            else if(hover) {
                imgCurrent = imgHover;
            }
            else {
                imgCurrent = imgDefault;
            }
            
            startCountdown = true;
        }
    }
    
    private void onHover() {
        hover = !hover;
        
        if(hover && !clicked) {
            imgCurrent = imgHover;           
        }
        else if(!clicked) {
            imgCurrent = imgDefault;
        }
    }
    
    public abstract void onClickAction(boolean clicked);
    
    public boolean getClicked() {
        return clicked;
    }
    
    @Override
    public void draw() {
        Draw.drawImage(imgCurrent, x, y);
        checkHover();
        checkExecute();
    }
    
    private void checkExecute() {
        if(startCountdown && delayFrameCountD-- <= 0) {
            startCountdown = false;
            delayFrameCountD = delayFrameCount;
            onClickAction(clicked);
        }        
    }
    
    private void checkHover() {
        
        if( App.toWorldX(app.mouseX) > App.toWorldX(App.toRealX(x) - Draw.scaleX((float)imgCurrent.width/2)) &&  
            App.toWorldX(app.mouseX) < App.toWorldX(App.toRealX(x) + Draw.scaleX((float)imgCurrent.width/2)) &&
            App.toWorldY(app.mouseY) > App.toWorldY(App.toRealY(y) - Draw.scaleY((float)imgCurrent.height/2)) &&
            App.toWorldY(app.mouseY) < App.toWorldY(App.toRealY(y) + Draw.scaleY((float)imgCurrent.height/2))) {
                
            if(!hover) {
                onHover();
            }
        }        
        else if(hover) {
            onHover();
        }       
    }
    
    public void clickUpdate(float xC, float yC) {                
        if( xC > App.toWorldX(App.toRealX(x) - Draw.scaleX((float)imgCurrent.width/2)) && 
            xC < App.toWorldX(App.toRealX(x) + Draw.scaleX((float)imgCurrent.width/2)) &&
            yC > App.toWorldY(App.toRealY(y) - Draw.scaleY((float)imgCurrent.height/2)) && 
            yC < App.toWorldY(App.toRealY(y) + Draw.scaleY((float)imgCurrent.height/2))) {
                
            onClick();
        }        
    }
    
    @Override
    public void keyUpdate(Key key, boolean down) {
        x *= 1;
    }
    
    
}
