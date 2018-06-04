package bars;

import java.util.ArrayList;
import control.DrawGroup;
import gui.Drawable;
import menu.Background;

public abstract class BarMenu implements DrawGroup{
	ArrayList<Drawable> elements;
    
    public BarMenu() {
        elements = new ArrayList<Drawable>();
        elements.add(new Background("src/images/PlayOverlay.png"));
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
