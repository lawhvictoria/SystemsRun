package item;
import control.Player;
import control.World;

public class SegFaultItem extends Item {

    public SegFaultItem() {
        
        super("src/images/SegFault.png");
        setupWeights();
    }

    public SegFaultItem(World world) {
        
        super("src/images/SegFault.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 0;
        deltaGrade = 0;
        deltaSocial = 0;
    }

    @Override
    public void itemEffect(Player player) {
        deltaSleep *= 1;
    }

}
