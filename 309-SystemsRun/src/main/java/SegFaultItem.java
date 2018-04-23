
public class SegFaultItem extends Item{

	public SegFaultItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public SegFaultItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;					// game over
		deltaGrade = 0;
		deltaSocial = 0;
	}

}
