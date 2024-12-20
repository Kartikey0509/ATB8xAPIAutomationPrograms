package RestAssured.GET;



import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest005_GET_BDDStyle {

    @Test
    public void test_Get_Request_BDDStyle() {
        String pin_code = "388620";
        RestAssured
                .given()
                     .baseUri("https://api.zippopotam.us")
                         .basePath("/IN/" + pin_code)
                .when()
                    .log()
                     .all()
                .get()
                    .then()
                        .log()
                            .all()
                             .statusCode(200);


    }

    @Test
    public void test_Get_Request_BDDStyle_Negative() {
        String pin_code = "231217";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log()
                .all()
                .statusCode(200);

    }

}
