package org.example;

import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    void factorialTest(){
        Assert.assertEquals(120, App.factorial(5));
        Assert.assertEquals(1, App.factorial(1));
        Assert.assertEquals(2, App.factorial(2));
        Assert.assertEquals(6, App.factorial(3));
        Assert.assertEquals(24, App.factorial(4));
    }
}

