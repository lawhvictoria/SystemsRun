package menu;

import control.App;

public class PlayMenu extends Menu{
	public PlayMenu(App app) {
        super(app, "src/images/PlayOverlay.png");
    }
    
    @Override
    public void display() {
        elements.add(new PlayButton(50, 70, app));
    }
}
