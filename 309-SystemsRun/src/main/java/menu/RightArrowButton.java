package menu;

import control.App;

public class RightArrowButton extends Button{
	public RightArrowButton(float x, float y, App app) {
        super(app, x, y, "src/images/rightArrow_default.png", 
                         "src/images/rightArrow_hover.png", 
                         "src/images/rightArrow_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;
    }
}
