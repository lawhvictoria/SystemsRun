package item;
import control.Player;
import control.World;

public class PopQuizItem extends Item{
	
    public PopQuizItem() {
		
	    super("src/images/popQuiz.png");
		setupWeights();
	}
	
	public PopQuizItem(World world) {
		
	    super("src/images/popQuiz.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		
	    deltaSleep = 0;
		deltaGrade = 0;
		deltaSocial = 0;
	}
	
	@Override
	public void itemEffect(Player player) {
	}
}
