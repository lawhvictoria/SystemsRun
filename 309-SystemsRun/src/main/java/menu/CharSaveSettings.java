package menu;

import control.App;

public class CharSaveSettings extends Button{
	public CharSaveSettings(float x, float y, App app) {
        super(app, x, y, "src/images/charSaveSettings_default.png", 
                         "src/images/charSaveSettings_hover.png", 
                         "src/images/charSaveSettings_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
    		
    }
}
