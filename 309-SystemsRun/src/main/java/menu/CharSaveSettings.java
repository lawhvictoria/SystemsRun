package menu;

import control.App;

public class CharSaveSettings extends Button{
	public CharSaveSettings(float x, float y, App app) {
        super(app, x, y, "src/images/saveSettingsNormal.png", 
                         "src/images/saveSettingsHover.png", 
                         "src/images/saveSettingPressed.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
    		
    }
}
