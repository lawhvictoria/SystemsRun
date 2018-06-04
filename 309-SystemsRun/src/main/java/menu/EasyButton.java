package menu;

import control.App;

public class EasyButton extends Button{
	
	public EasyButton(float x, float y, App app) {
        super(app, x, y, "src/images/easy_default.png", 
                         "src/images/easy_hover.png", 
                         "src/images/easy_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;        
    }
}
