package RestAssured.GET;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class APITest006_GET_NonBDDStyle {
    static RequestSpecification r = RestAssured.given();
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC1 NonBDDStyle Positive")
    @Test
    public void test_NonBDDStyle_positive(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/388620");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("TC2 NonBDDStyle Negative")
    @Test
    public void test_NonBDDStyle_negative(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/231217");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

}
