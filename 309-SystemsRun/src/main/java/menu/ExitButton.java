package menu;

import control.App;

public class ExitButton extends Button {
    public ExitButton(float x, float y, App app) {
        super(app, x, y, "src/images/ExitButton_default.png", 
                         "src/images/ExitButton_hover.png", 
                         "src/images/ExitButton_clicked.png");
        setDelay(12);
    }

    @Override
    public void onClickAction(boolean clicked) {
        app.close();
        
    }
}
