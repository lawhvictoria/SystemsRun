package highScore;

import gui.Drawable;
import menu.CharHomeButton;
import menu.Menu;
import control.App;

public class HighScore extends Menu implements Drawable{
	final int stateTypeInitials =0;
	final int statePlayGame    =1;
	final int stateShowHighscore =2;
	int state = statePlayGame;
	
	public HighScore(App app) {
		super(app, "src/images/highScoreBackground.png");
	}

	public void draw() {
		switch(state) {
		 
		case stateTypeInitials:
		    // show text while it's typed
		    //text(inputText,62,62); 
		    break;
		 
		case statePlayGame:    
		    // what you have in draw now
		    break; 
		 
		case stateShowHighscore:    
		    // show high score
		    break; 
		}
		
	}

	@Override
	public void display() {
		elements.add(new HighScoreHomeButton(93, 90, app));
	}
}
