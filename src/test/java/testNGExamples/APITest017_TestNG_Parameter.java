package testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITest017_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){

        System.out.println("Broswer is = "+value);
        if (value.equalsIgnoreCase("CHROME")){
            System.out.println("Start testing on Chrome");
        }
        if (value.equalsIgnoreCase("FIREFOX")){
            System.out.println("Start testing on Firefox");
        }
        else {
            System.out.println("You are using browser from different planet!!");
        }
    }
}
