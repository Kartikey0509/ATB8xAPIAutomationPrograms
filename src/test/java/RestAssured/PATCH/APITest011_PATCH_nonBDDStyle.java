package RestAssured.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest011_PATCH_nonBDDStyle {



    @Description("Verify PATCH Request for Restful Booker")
    @Test
    public void test_Patch_NonBddStyle(){
        String token ="43640325cea068d";
        String bookingid ="1176";

        String payload= "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
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

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

    }
}
