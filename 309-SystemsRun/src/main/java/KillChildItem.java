
public class KillChildItem extends Item{
	public KillChildItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public KillChildItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;				// Unfork but kill you if you are at 1 fork
		deltaGrade = 0;
		deltaSocial = 0;
	}
}
