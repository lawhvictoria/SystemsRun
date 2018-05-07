package menu;

import control.App;

public class PlayButton extends Button{
    
    public PlayButton(float x, float y, App app) {
        super(app, x, y, "src/images/StartButton_default.png", 
                         "src/images/StartButton_hover.png", 
                         "src/images/StartButton_clicked.png");
        setDelay(12);
    }

    @Override
    public void onClickAction(boolean clicked) {
        app.loadDrawGroup(1);
        
    }
}
