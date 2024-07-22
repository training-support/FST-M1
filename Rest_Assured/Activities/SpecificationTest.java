package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    int petId;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp(){
        //request specification
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2/pet").
                addHeader("Content-Type","application/json").
                build();
        //response specification
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectBody("status",equalTo("alive")).
                expectResponseTime(lessThanOrEqualTo(3000L)).
                build();
    }

    @Test(priority = 1)
    public void postRequest(){
        Map<String, Object>  reqBody = new HashMap<>();
        reqBody.put("id", 78372);
        reqBody.put("name","Rijen");
        reqBody.put("status", "alive");
        //Send Request, save response
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        petId = response.then().extract().path("id");
        response.then().spec(responseSpec).body("name",equalTo("Rijen"));

    }

    @Test (priority = 2)
    public void getRequest(){
        given().spec(requestSpec).pathParam("petId",petId).log().all().
                when().get("/{petId}").then()
                .spec(responseSpec).log().all();
    }

    @Test (priority = 3)
    public void deleteRequest(){
        given().spec(requestSpec).pathParam("petId",petId).log().all().
                when().delete("/{petId}").then()
                .statusCode(200).body("message",equalTo(""+petId)).log().all();
    }
}
