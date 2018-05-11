package menu;

import control.App;

public class HomeButton extends Button{
	
	public HomeButton(float x, float y, App app) {
        super(app, x, y, "src/images/home_default.png", 
                         "src/images/home_hover.png", 
                         "src/images/home_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
    }
}
