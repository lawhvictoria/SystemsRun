package menu;

import java.util.ArrayList;
import control.App;
import control.DrawGroup;
import gui.Drawable;

public abstract class Menu implements DrawGroup {
    ArrayList<Drawable> elements;
    protected App app;
    
    public Menu(App app, String imgSrc) {
        this.app = app;
        elements = new ArrayList<Drawable>();
        elements.add(new Background(imgSrc));
        display();
        
    }
    
    public void update() {
        for(Drawable el : elements) {
            el.draw();
        }
    }
    
    public abstract void display();
    
    public void hide() {
        elements.clear();        
    }
}
