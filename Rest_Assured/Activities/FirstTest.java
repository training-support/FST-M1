package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

//    https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    @Test
    public void getRequestWithQueryParams(){
        //Send Request, save the response
        Response response =
                given().       //Request Specification
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type", "application/json").
                        queryParam("status","alive").
                when().
                        get("/findByStatus");
        //Print Response body
        System.out.println(response.getBody().asString());
//        System.out.println(response.getBody().asPrettyString());
//        Print Response headers
//        System.out.println(response.getHeaders().asList());
        //Extract Properties
        String petStatus = response.then().extract().path("[0].status");
        System.out.println("Pet Status is:  "+petStatus);
        //Assertions
        Assert.assertEquals(petStatus,"alive");
    }


//    https://petstore.swagger.io/v2/pet/{petId}
    @Test
    public void getRequestWithPathParam(){
        given(). //Request Specification
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParams("petId",77232).
                log().all().
        when(). //HTTP Method
                get("/{petId}").
        then(). //Response Specification
                statusCode(200).
                body("status", equalTo("alive")).
                body("name", equalTo("Riley")).
                log().all();
    }
}
