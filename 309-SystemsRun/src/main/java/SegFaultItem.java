
public class SegFaultItem extends Item{

	public SegFaultItem() {
		super("src/images/SegFault.png");
		setupWeights();
	}
	
	public SegFaultItem(World world) {
		super("src/images/SegFault.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;					// game over
		deltaGrade = 0;
		deltaSocial = 0;
	}

}
