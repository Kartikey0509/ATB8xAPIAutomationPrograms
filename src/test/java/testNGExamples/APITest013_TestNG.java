package testNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITest013_TestNG {

    @BeforeTest
    public void getToken(){
        System.out.println("Get Token");
    }

    @BeforeTest
    public void bookingID(){
        System.out.println("Get BookingId");
    }
    @Test
    public void test_PUT(){
        System.out.println("3");
    }

   @AfterTest
    public void close(){
       System.out.println("Close all the sessions");
    }
}
