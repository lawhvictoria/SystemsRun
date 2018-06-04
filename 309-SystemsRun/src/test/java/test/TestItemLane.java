package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import control.App;
import control.ItemLane;
import control.World;

public class TestItemLane {

    @Test
    public void testStartY() {
        String args[] = {""};
        App.main(args);  
        World world = new World();
        ItemLane lane = new ItemLane(world, 30, 40, 50, 60);
        assertEquals(40, lane.getStartY());
    }
    
    @Test
    public void testEndY() {
        String args[] = {""};
        App.main(args);  
        World world = new World();
        ItemLane lane = new ItemLane(world, 30, 40, 50, 60);
        assertEquals(60, lane.getEndY());
    }
}
