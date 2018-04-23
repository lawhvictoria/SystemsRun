
public class CompileErrorItem extends Item{
	public CompileErrorItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public CompileErrorItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = -1;
		deltaGrade = -1;
		deltaSocial = -1;
	}
}
