package item;
import control.Player;
import control.World;

public class BookItem extends Item {
    
    public BookItem() {
        
        super("src/images/book.png");
        setupWeights();
    }

    public BookItem(World world) {
        
        super("src/images/book.png", world);
        setupWeights();
    }

    private void setupWeights() {
        
        deltaSleep = -1;
        deltaGrade = 1;
        deltaSocial = 0;
    }

    @Override
    public void itemEffect(Player player) {
        deltaSleep *= 1;
    }
}
