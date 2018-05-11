package menu;

import control.App;

public class CharHomeButton extends Button{
	public CharHomeButton(float x, float y, App app) {
        super(app, x, y, "src/images/charHome_default.png", 
                         "src/images/charHome_hover.png", 
                         "src/images/charHome_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
    		app.loadDrawGroup(0);
    }
}
