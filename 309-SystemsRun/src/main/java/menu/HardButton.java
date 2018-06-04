package menu;

import control.App;

public class HardButton extends Button{
	
	public HardButton(float x, float y, App app) {
        super(app, x, y, "src/images/hard_default.png", 
                         "src/images/hard_hover.png", 
                         "src/images/hard_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;        
    }
}
