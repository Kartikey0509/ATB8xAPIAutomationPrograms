package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest023_SoftAssertion {
    @Test
    public void test_softAssertExample() {
        System.out.println("Start of the program");
        //Create instance of soft assert and then use by default assert is taken as Hard assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("End of the program");


        Assert.assertEquals("Chrome", "Chrome");
        softAssert.assertEquals("FF", "ff");
    }
}