package item;
import control.Player;
import control.World;

public class BedItem extends Item {

    public BedItem() {
        
        super("src/images/sleep.png");
        setupWeights();
    }

    public BedItem(World world) {
        
        super("src/images/sleep.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 1;
        deltaGrade = 0;
        deltaSocial = -1;
    }

    @Override
    public void itemEffect(Player player) {
    		int num = 1;
    }
}
