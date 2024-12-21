package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest022_HardAssertion {

    @Test
    public void test_hardAssertExample() {
        System.out.println("Start of the program");
        Assert.assertTrue(false);
        System.out.println("End of the program");


        Assert.assertEquals("Chrome", "Chrome");
        Assert.assertEquals("FF", "ff");
    }
    }
