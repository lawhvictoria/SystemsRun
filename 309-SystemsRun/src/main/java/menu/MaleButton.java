package menu;

import control.App;

public class MaleButton extends Button{
	public MaleButton(float x, float y, App app) {
        super(app, x, y, "src/images/male_default.png", 
                         "src/images/male_hover.png", 
                         "src/images/male_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
    		
    }
}
