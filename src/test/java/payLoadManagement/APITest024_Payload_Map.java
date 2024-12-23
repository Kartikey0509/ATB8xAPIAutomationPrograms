package payLoadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class APITest024_Payload_Map {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq() {
        //{
        //            "firstname" : "James",
        //                "lastname" : "Brown",
        //                "totalprice" : 111,
        //                "depositpaid" : true,
        //                "bookingdates" : {
        //            "checkin" : "2018-01-01",
        //                    "checkout" : "2019-01-01"
        //        },
        //            "additionalneeds" : "Breakfast"
        //        }


        // JSON -> Hashmap

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "James");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", "111");
        jsonBodyUsingMap.put("depositpaid","true");

        //New Linked hashmap for bookingDates jitne curly braces utne Maps
        Map<String, Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2018-01-01" );
        bookingDatesMap.put("checkout", "2019-01-01");


        //Add BookingDate map into jsonBody Map to get the entire json

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);

        //payload is now in json map so
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response= requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " +  bookingId);




    }
}
