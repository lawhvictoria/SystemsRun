package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import control.App;

public class TestApp {
    
    @Test
    public void testToRealX() {
        String args[] = {""};
        App.main(args);     
        assertEquals(App.INITIAL_WIDTH, App.toRealX(100));
    }
    
    @Test
    public void testToRealY() {
        String args[] = {""};
        App.main(args);     
        assertEquals(App.INITIAL_HEIGHT, App.toRealY(100));
    }
}
