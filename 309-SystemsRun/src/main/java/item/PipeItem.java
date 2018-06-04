package item;
import control.Player;
import control.World;

public class PipeItem extends Item {

    public PipeItem() {
        
        super("src/images/Pipe.png");
        setupWeights();
    }

    public PipeItem(World world) {
        
        super("src/images/Pipe.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = 0;
        deltaGrade = 0;
        deltaSocial = 0;
    }

    @Override
    public void itemEffect(Player player) {
        deltaSleep *= 1 + player.speedX * 0;
    }
}
