package examples;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    // GET https://petstore.swagger.io/v2/pet/{petId}

    @Test
    public void getRequestWithQueryParameter() {
        Response response =
                given().baseUri("https://petstore.swagger.io/v2/pet").
                        header("ContentType", "application/jason").
                        queryParam("status", "alive").
                        log().all().
                        when().get("/findByStatus");

        System.out.println(response.getHeaders());
        System.out.println(response.getBody().asString());

        String petStatus = response.then().extract().path("[0].status");
        Assert.assertEquals(petStatus, "alive");
    }

    @Test
    public void getRequestWithPathParameter() {
        given().baseUri("https://petstore.swagger.io/v2/pet").
                header("ContentType", "application/jason").
                pathParam("petId", 772321).
                log().all().
                when().get("/{petId}").
        then().statusCode(200).
                body("name", equalTo("Riley")).
                body("status", equalTo("alive")).
                log().all();
    }
}