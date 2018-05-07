package menu;

import control.App;

public class SettingsButton extends Button {
    
    public SettingsButton(float x, float y, App app) {
        super(app, x, y, "src/images/SettingsButton_default.png", 
                         "src/images/SettingsButton_hover.png", 
                         "src/images/SettingsButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }

}
