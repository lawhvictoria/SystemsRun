package item;
import control.Player;
import control.World;

public class BedItem extends Item {

    public BedItem() {
        
        super("src/images/cat.png");
        setupWeights();
    }

    public BedItem(World world) {
        
        super("src/images/cat.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 1;
        deltaGrade = 0;
        deltaSocial = -1;
    }

    @Override
    public void itemEffect(Player player) {
        // TODO
    }
}
