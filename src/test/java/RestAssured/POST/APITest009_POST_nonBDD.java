package RestAssured.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest009_POST_nonBDD {

 static RequestSpecification r = RestAssured.given();
    @Description("TC - Verify the POST Request - Non BDD Style -Positive")
    @Test
    public void test_post_nonBddStyle(){
        String payload = "{\n" +
                "\t\"username\": \"admin\",\n" +
                "\t\"password\": \"password123\"\n" +
                "}";


                   r.baseUri("https://restful-booker.herokuapp.com");
                        r.basePath("/auth");
                         r.contentType(ContentType.JSON)                 //header
                          .log()
                             .all();
                         r.body(payload) ;                         //body
                r.when()
                    .log()
                        .all()
                         .post();
                r.then()
                 .log().all()
                    .statusCode(200);
    }

    @Description("TC - Verify the POST Request - Non BDD Style -Negative")
    @Test
    public void test_post_nonBddStyle_neg(){
        String payload = "{\n" +
                "\t\"username\": \"admin\",\n" +
                "\t\"password\": \"password123\"\n" +
                "}";


        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON)                 //header
                .log()
                .all();
        r.body(payload) ;                         //body
        r.when()
                .log()
                .all()
                .post();
        r.then()
                .log().all()
                .statusCode(200);
    }

}
