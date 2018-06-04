package menu;

import control.App;

public class LeftArrowButton extends Button{
	public LeftArrowButton(float x, float y, App app) {
        super(app, x, y, "src/images/leftArrow_default.png", 
                         "src/images/leftArrow_hover.png", 
                         "src/images/leftArrow_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;
    }
}
