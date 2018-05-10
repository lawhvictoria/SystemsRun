package menu;

import control.App;

public class MuteButton extends Button {
	public MuteButton(float x, float y, App app) {
        super(app, x, y, "src/images/MuteButton_default.png", 
                         "src/images/MuteButton_hover.png", 
                         "src/images/MuteButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }
}
