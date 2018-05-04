package menu;

import java.util.ArrayList;
import gui.Drawable;

public abstract class Menu {
    ArrayList<Drawable> elements;
    
    public Menu() {
        elements = new ArrayList<Drawable>();
    }
    
    public void draw() {
        for(Drawable el : elements) {
            el.draw();
        }
    }
    
    public abstract void display();
    
    public abstract void hide();
}
