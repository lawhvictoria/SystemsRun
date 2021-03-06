package item;
import control.Player;
import control.World;
import gui.Draw;

public class KillChildItem extends Item {

    public KillChildItem() {
        
        super("src/images/kill.png");
        setupWeights();
    }

    public KillChildItem(World world) {
        
        super("src/images/kill.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 0;
        deltaGrade = 0;
        deltaSocial = 0;
    }

    @Override
    public void itemEffect(Player player) {
    		Draw.subtractDimension();
        if (!Draw.subtractDimension()) {
            deltaSleep *= 1;
        }
    }
}
