package testNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITest014_TestNG_Priority {

    @Test(priority = 0)
    public void getToken(){
        System.out.println("Get Token");
    }

    @Test(priority = -4)
    public void bookingID(){
        System.out.println("Get BookingId");
    }
    @Test(priority = 5)
    public void test_PUT(){
        System.out.println("3");
    }

    @Test(priority = 2)
    public void close(){
        System.out.println("Close all the sessions");
    }
}
