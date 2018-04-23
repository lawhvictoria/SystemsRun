
public class PipeItem extends Item{
	public PipeItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public PipeItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = 0;					//invert keys
		deltaGrade = 0;
		deltaSocial = 0;
	}
}
