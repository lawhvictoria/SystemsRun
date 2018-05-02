package item;
import control.Player;
import control.World;
import gui.Draw;

public class KillChildItem extends Item {

    public KillChildItem() {
        
        super("src/images/cat.png");
        setupWeights();
    }

    public KillChildItem(World world) {
        
        super("src/images/cat.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 0;
        deltaGrade = 0;
        deltaSocial = 0;
    }

    @Override
    public void itemEffect(Player player) {
        if (!Draw.subtractDimension()) {
            // kill player
        }
    }
}
