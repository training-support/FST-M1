package activities;
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

public class GitHubProject {
    //SSH Key to test with
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJ56Q+UiCwVN1Xub4YnXuA0OhO14QY6GaBKTMJfRRxLU";
    int sshKeyId;
    //Request Specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").addHeader("Authorization", "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").
            addHeader("Content-Type", "application/json").
            build();

    //Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();


    @Test(priority = 1)
    public void postRequestTest() {
        //Path: https//api.github.com/user/keys
        //Request body
        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        //Generate response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        //Extract the Id
        sshKeyId =response.then().extract().path("id");
        if (sshKey!=null){//Assertions
        response.then().statusCode(201).spec(responseSpec);}
        else{
            throw new RuntimeException("Failed to to get ID");
        }

    }
    @Test(priority = 2)
    public void getRequestTest(){
        //Path: https://api.github.com/user/keys/{keyId}
        //Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).when().get("/{keyId}").then().statusCode(200)
                .spec(responseSpec);
    }
}
