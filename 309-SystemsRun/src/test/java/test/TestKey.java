package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import control.Key;

public class TestKey {

    @Test
    public void testLeft() {
        assertEquals('a', Key.LEFT.getKey());
    }
    
    @Test
    public void testRight() {
        assertEquals('d', Key.RIGHT.getKey());
    }
    
}
