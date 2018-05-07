package menu;

import control.App;

public class CharactersButton extends Button {
    
    public CharactersButton(float x, float y, App app) {
        super(app, x, y, "src/images/CharactersButton_default.png", 
                         "src/images/CharactersButton_hover.png", 
                         "src/images/CharactersButton_clicked.png");
    }

    @Override
    public void onClickAction(boolean clicked) {
        
        
    }
    
}
