package activities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Activity1 {
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void PostRequest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");
        Response response =
                given().contentType(ContentType.JSON)
                        .body(reqBody)
                        .when().post(ROOT_URI);
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=2)
    public void getRequest() {
        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", "77232")
                        .get(ROOT_URI + "/{petId}");
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=3)
    public void deleteRequest() {
        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", "77232")
                        .delete(ROOT_URI + "/{petId}");

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
