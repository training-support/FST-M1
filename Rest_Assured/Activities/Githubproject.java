package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Githubproject {
    String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAdHoKnIfBodgiGcW4zQ/NN9JcA0SFwWxhUEv5DmsDKv";
    int id;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void setUP(){
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", "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")
                .build();
        responseSpec = new  ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .expectBody("key", equalTo(sshkey))
                .expectBody("title", equalTo("TestAPIKey"))
                .expectContentType("application/json")
                .build();
    }
    @Test(priority = 1)
    public void postTest(){
        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key",sshkey);
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        id = response.then().extract().path("id");
        System.out.println(sshkey);
        response.then().statusCode(201).spec(responseSpec);

    }
    @Test(priority = 2)
    public void getTest(){
        given().spec(requestSpec).pathParams("KeyId", sshkey)
                .when().get("/{KeyId}")
                .then().statusCode(200).spec(responseSpec);
        Reporter.log("get the sshkey");
    }
    @Test(priority = 3)
    public void deleteTest(){
        given().spec(requestSpec).pathParams("KeyId", sshkey)
                .when().delete("/{keyId}")
                .then().statusCode(anyOf(is(200),is(204))).time(lessThan(3000L));
        Reporter.log("Logging into delete selenium");
    }

}
