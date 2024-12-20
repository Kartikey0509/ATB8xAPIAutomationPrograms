package Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITest012_TestCaseIntegration {

    //  Create a Token
    // Create a Booking
    //  Perform  a PUT request
    //  Verify that PUT is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET Request

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    String token;
    String bookingid;

    public String getToken() {
        String payload ="{\n" +
                "\t\"username\": \"admin\",\n" +
                "\t\"password\": \"password123\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        // When -     Response
        response = requestSpecification.when().post();

        // Then - Validatable Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Extract the token
        token = response.jsonPath().getString("token");
        System.out.println(token);

        return token;


    }

    public String getBookingID() {

        String payload ="{\n" +
        "    \"firstname\" : \"Rishu\",\n" +
                "    \"lastname\" : \"Raj\",\n" +
                "    \"totalprice\" : 121,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        // When -     Response
        response = requestSpecification.when().post();

        // Then - Validatable Response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingid= response.jsonPath().getString("bookingid");
        System.out.println("BookingId"+bookingid);

        assertThat(bookingid).isNotBlank().isNotEmpty().isNotNull();
        return bookingid;
    }
@Test(priority = 1)
    public void test_PUT_request(){
        token= getToken();
        bookingid =getBookingID();
        System.out.println(token);
        System.out.println(bookingid);

        String payload ="{\n" +
    "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        response= requestSpecification.when().put();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Test(priority = 2)
    public void test_get_request(){
        System.out.println(bookingid);
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        response= requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);

        String firstname = response.jsonPath().getString("firstname");
        Assert.assertEquals(firstname,"James");
    }

    @Test(priority = 3)
    public void test_delete_request(){
        System.out.println(bookingid);
        System.out.println(token);
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        response= requestSpecification.when().delete();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);  //#TODO -Bug in Delete Request
    }

    @Test(priority = 4)
    public void test_after_delete_request_get(){
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        response =requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(404);
    }

    //  Todo #2 - I will add more assertions here
}
