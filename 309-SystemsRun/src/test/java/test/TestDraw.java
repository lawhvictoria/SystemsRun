package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import control.App;
import gui.Draw;

public class TestDraw {
    
    @Test
    public void testDrawWidth() {
        String args[] = {""};
        App.main(args);        
        assertEquals(Draw.getWidth(), App.INITIAL_WIDTH);       
    }
    
    @Test
    public void testDrawHeight() {
        String args[] = {""};
        App.main(args);        
        assertEquals(Draw.getHeight(), App.INITIAL_HEIGHT);       
    }
}
