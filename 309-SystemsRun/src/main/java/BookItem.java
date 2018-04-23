
public class BookItem extends Item{
	public BookItem() {
		super("src/images/cat.png");
		setupWeights();
	}
	
	public BookItem(World world) {
		super("src/images/cat.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		deltaSleep = -1;
		deltaGrade = 1;
		deltaSocial = 0;
	}
}