package menu;

import control.App;

public class mediumButton extends Button {
	
	public mediumButton(float x, float y, App app) {
        super(app, x, y, "src/images/medium_default.png", 
                         "src/images/medium_hover.png", 
                         "src/images/medium_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }
}
