package testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest016_TestNG_DependsOnMethod {


    @Test
    public void serverStarted(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }


    @Test(dependsOnMethods = "serverStarted")
    public void method1(){
        System.out.println("Method1");
        Assert.assertTrue(true);
    }

@Test(dependsOnMethods = "serverStarted")
    public void method2(){
        System.out.println("Method2");
        Assert.assertTrue(true);
    }



}
