
public class PopQuizItem extends Item{
	public PopQuizItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public PopQuizItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;
		deltaGrade = 0;					// 50/50 positive negative
		deltaSocial = 0;
	}
}
