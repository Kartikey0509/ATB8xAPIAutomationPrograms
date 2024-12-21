package testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest020_TestNG_invocationCount {

    @Test(invocationCount = 3)
    public void test01(){
        Assert.assertTrue(true);
        System.out.println("I will run thrice");
    }
}
