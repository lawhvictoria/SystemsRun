package menu;

import control.App;

public class HighScoresButton extends Button {
    
    public HighScoresButton(float x, float y, App app) {
        super(app, x, y, "src/images/HighScoresButton_default.png", 
                         "src/images/HighScoresButton_hover.png", 
                         "src/images/HighScoresButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }

}
