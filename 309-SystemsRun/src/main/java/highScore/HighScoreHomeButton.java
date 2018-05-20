package highScore;

import control.App;
import menu.Button;

public class HighScoreHomeButton  extends Button {
	public HighScoreHomeButton(float x, float y, App app) {
        super(app, x, y, "src/images/highScoreHome_default.png", 
                         "src/images/highScoreHome_hover.png", 
                         "src/images/highScoreHome_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
    		app.loadDrawGroup(0);  
    }
}