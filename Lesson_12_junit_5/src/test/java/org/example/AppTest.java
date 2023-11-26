package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    void factorialTest(){
        assertEquals(120, App.factorial(5));
        assertEquals(1, App.factorial(1));
        assertEquals(2, App.factorial(2));
        assertEquals(6, App.factorial(3));
        assertEquals(24, App.factorial(4));
    }
}

