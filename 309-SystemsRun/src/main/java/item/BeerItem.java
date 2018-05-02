package item;
import control.Player;
import control.World;

public class BeerItem extends Item {

    public BeerItem() {
        
        super("src/images/cat.png");
        setupWeights();
    }

    public BeerItem(World world) {
        
        super("src/images/cat.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 0;
        deltaGrade = -1;
        deltaSocial = 1;
    }

    @Override
    public void itemEffect(Player player) {
        // TODO
    }
}
