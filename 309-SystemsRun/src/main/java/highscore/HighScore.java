package highscore;

import gui.Drawable;
import menu.Menu;
import control.App;

public class HighScore extends Menu implements Drawable{
	static final int STATE_TYPE_INITIALS = 0;
	static final int STATE_PLAY_GAME = 1;
	static final int STATE_SHOW_HIGH_SCORE = 2;
	
	int state = STATE_PLAY_GAME;
	
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
