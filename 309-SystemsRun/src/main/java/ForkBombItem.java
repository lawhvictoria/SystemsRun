public class ForkBombItem extends Item{
	
    public ForkBombItem() {
		
        super("src/images/forkbomb.png");
		setupWeights();
	}
	
	public ForkBombItem(World world) {
		
	    super("src/images/forkbomb.png", world);
		setupWeights();
	}
	
	private void setupWeights() {
		
	    deltaSleep = 0;
		deltaGrade = 0;
		deltaSocial = 0;
	}
	
    @Override
    public void itemEffect(Player player) {
        
        Draw.addDimension();
        // TODO: Increase bar decay rate
    }
}
