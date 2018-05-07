package menu;

import control.App;

public class MainMenu extends Menu {
    
    public MainMenu(App app) {
        super(app, "src/images/MainMenu_Background.png");
    }
    
    @Override
    public void display() {
        // create buttons in right spots and add to elements array
        elements.add(new PlayButton(50, 70, app));
        elements.add(new CharactersButton(50, 82.5f, app));
        elements.add(new HighScoresButton(50, 91, app));
        elements.add(new TutorialButton(12, 95, app));
        elements.add(new SettingsButton(91, 95, app));
        elements.add(new AppendixButton(86, 95, app));
    }

    @Override
    public void hide() {
        elements.clear();        
    }

}
