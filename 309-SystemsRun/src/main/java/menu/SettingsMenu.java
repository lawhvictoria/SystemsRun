package menu;

import control.App;

public class SettingsMenu extends Menu{

	public SettingsMenu(App app) {
        super(app, "src/images/mainSettingsBackground.png");
    }
    
    @Override
    public void display() {
        // create buttons in right spots and add to elements array
    		elements.add(new MuteButton(18, 41, app));
		elements.add(new MuteButton(18, 61, app));
		elements.add(new easyButton(18, 82, app));
		elements.add(new mediumButton(34, 82, app));
    }
}
