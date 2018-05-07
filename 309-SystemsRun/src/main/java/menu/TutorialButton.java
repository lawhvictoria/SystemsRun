package menu;

import control.App;

public class TutorialButton extends Button {
    
    public TutorialButton(float x, float y, App app) {
        super(app, x, y, "src/images/TutorialButton_default.png", 
                         "src/images/TutorialButton_hover.png", 
                         "src/images/TutorialButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }
}
