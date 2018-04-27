package Item;
import Control.Player;
import Control.World;

public class CompileErrorItem extends Item {
    
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

    @Override
    public void itemEffect(Player player) {
        // TODO
    }
}