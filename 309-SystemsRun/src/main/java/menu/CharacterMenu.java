package menu;

import control.App;

public class CharacterMenu extends Menu{
	public CharacterMenu(App app) {
        super(app, "src/images/characterMenuBlank.png");
    }
    
    @Override
    public void display() {
        // create buttons in right spots and add to elements array
		elements.add(new LeftArrowButton(18, 41, app));
		elements.add(new RightArrowButton(45, 41, app));
		elements.add(new LeftArrowButton(60, 41, app));
		elements.add(new RightArrowButton(87, 41, app));
		elements.add(new CharHomeButton(93, 90, app));
		elements.add(new CharSaveSettings(74, 90, app));
		elements.add(new MaleButton(32, 75, app));
		elements.add(new FemaleButton(74, 75, app));
    }
}
