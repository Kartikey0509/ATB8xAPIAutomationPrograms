package Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITest021_Assertion_Real {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST);

        response= requestSpecification.when().post();

        validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);

//Matcher is an utility function in org.hamcrest

        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
        validatableResponse.body("bookingid",Matchers.notNullValue());


        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");


        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Pramod");
        Assert.assertEquals(lastname,"Dutta");

        // AssertJ( 3rd- Lib to Assertions)
        assertThat(bookingId).isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Pramod").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();

        String s = ""; //Empty
        String s2 = " "; //Blank
    }
}
