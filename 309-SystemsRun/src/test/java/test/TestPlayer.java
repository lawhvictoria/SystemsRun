package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import control.App;
import control.Player;
import control.World;

public class TestPlayer {

    @Test
    public void testPlayerX() {
        String args[] = { "" };
        App.main(args);
        World world = new World();
        Player player = new Player(world, 100, 50);        
        assertEquals(player.getX(), 100);
    }
    
    @Test
    public void testPlayerY() {
        String args[] = { "" };
        App.main(args);
        World world = new World();
        Player player = new Player(world, 100, 50); 
        assertEquals(player.getY(), 50);
    }
}
