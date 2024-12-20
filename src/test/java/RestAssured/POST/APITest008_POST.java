package RestAssured.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITest008_POST {

    //https://restful-booker.herokuapp.com/auth
    //'Content-Type: application/json'
    // '{
    //    "username" : "admin",
    //    "password" : "password123"
    //}'

    @Description("TC - Verify the POST Request - BDD Style")
    @Test
    public void test_post_bddStyle(){
        String payload = "{\n" +
                "\t\"username\": \"admin\",\n" +
                "\t\"password\": \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                         .contentType(ContentType.JSON)                 //header
                          .log()
                             .all()
                                .body(payload)                          //body
                .when()
                    .log()
                        .all()
                            .post()
                .then()
                 .log().all()
                    .statusCode(200);
    }

}
