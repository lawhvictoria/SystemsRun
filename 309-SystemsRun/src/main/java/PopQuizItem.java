
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
		deltaGrade = 0;					// 50/50 positive negative
		deltaSocial = 0;
	}
}
