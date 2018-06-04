package menu;

import control.App;

public class FemaleButton extends Button{
	public FemaleButton(float x, float y, App app) {
        super(app, x, y, "src/images/female_default.png", 
                         "src/images/female_hover.png", 
                         "src/images/female_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;
    }
}
