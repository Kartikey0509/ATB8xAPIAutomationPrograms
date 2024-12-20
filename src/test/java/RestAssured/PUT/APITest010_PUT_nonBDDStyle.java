package RestAssured.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest010_PUT_nonBDDStyle {



    @Description("Verify PUT Request for Restful Booker")
    @Test
    public void test_Put_NonBddStyle(){
        String token ="43640325cea068d";
        String bookingid ="1176";

        String payload= "{\n" +
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
        RequestSpecification requestSpecification = RestAssured.given();
             requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
             requestSpecification.basePath("/booking/"+bookingid);
             requestSpecification.contentType(ContentType.JSON);
             requestSpecification.cookie("token",token);
             requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}
