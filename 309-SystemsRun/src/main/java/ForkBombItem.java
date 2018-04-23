
public class ForkBombItem extends Item{
	public ForkBombItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public ForkBombItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;		// Make delay faster
		deltaGrade = 0;
		deltaSocial = 0;
	}
}
