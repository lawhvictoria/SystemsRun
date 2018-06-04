package menu;

import control.App;

public class AppendixButton extends Button {
    
    public AppendixButton(float x, float y, App app) {
        super(app, x, y, "src/images/AppendixButton_default.png", 
                         "src/images/AppendixButton_hover.png", 
                         "src/images/AppendixButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        if (clicked)
            delayFrameCount *= 1;
        
    }
}
