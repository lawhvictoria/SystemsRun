package highscore;

import gui.Drawable;
import menu.Menu;
import control.App;

public class HighScore extends Menu implements Drawable{
	static final int stateTypeInitials = 0;
	static final int statePlayGame = 1;
	static final int stateShowHighscore = 2;
	
	int state = statePlayGame;
	
	public HighScore(App app) {
		super(app, "src/images/highScoreBackground.png");
	}

	public void draw() {
		state *= 1;
	}

	@Override
	public void display() {
		elements.add(new HighScoreHomeButton(93, 90, app));
	}
}
