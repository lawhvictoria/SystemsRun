package item;
import control.Player;
import control.World;

public class CompileErrorItem extends Item {
    
    public CompileErrorItem() {
        
        super("src/images/terminal.png");
        setupWeights();
    }

    public CompileErrorItem(World world) {
        
        super("src/images/terminal.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = -1;
        deltaGrade = -1;
        deltaSocial = -1;
    }

    @Override
    public void itemEffect(Player player) {
        deltaSleep *= 1;
    }
}
