package menu;

import control.App;

public class SaveSettingsButton extends Button{
	public SaveSettingsButton(float x, float y, App app) {
        super(app, x, y, "src/images/saveSettings_default.png", 
                         "src/images/saveSettings_hover.png", 
                         "src/images/saveSettings_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        delayFrameCount *= 1;
    }
}
