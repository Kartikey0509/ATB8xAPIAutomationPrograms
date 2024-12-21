package testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest019_TestNG_AlwaysRun {

    @Test(alwaysRun = false)
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test02(){
        Assert.assertTrue(true);
        System.out.println("I am always available");
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
        System.out.println("I am test Method");
    }
}
