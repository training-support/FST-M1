package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest {
    //SSH Key to test with
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMKLuWuBAS8B+nFFD1cVE8GAhrHfPwJ4G+SFcX0BpyH8";
    int sshKeyId;
    //Request Specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").
            build();

    //Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).expectBody("key",equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest() {
        //Path: https//api.github.com/user/keys
        //Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        //Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        //Extract the id
        sshKeyId =response.then().extract().path("id");
        //Assertions
        response.then().statusCode(201).spec(responseSpec);
    }
    @Test(priority = 2)
    public void getRequestTest(){
        //Path: https://api.github.com/user/keys/{keyId}
        //Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).when()
                .get("/{keyId}").then()
                .statusCode(200)
                .spec(responseSpec);
    }

    // DELETE
    @Test(priority = 3)
    public void deleteRequest() {
        // send request, get Response, assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
                when().delete("/{petId}").
                then().statusCode(201).body("id", equalTo("" + sshKeyId));
    }
}