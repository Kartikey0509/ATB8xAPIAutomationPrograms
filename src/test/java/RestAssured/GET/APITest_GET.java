package RestAssured.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest_GET {

    @Test
    public void test_Get_Request(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1")
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
