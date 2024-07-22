package project;

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

public class GitHubTest {
    int keyId;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINKTslBgwuMUC/t2msbAdgMLag177o+CSpV/VwumlyHz";

    @BeforeClass
    public void setUp(){
        //Request Specification
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.github.com/user/keys").
                addHeader("Content-Type","application/json").
                addHeader("Authorization","token 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").
                build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThanOrEqualTo(3000L)).build();
    }

    @Test (priority = 1)
    public void postRequest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshkey);
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        System.out.println(response.getBody().asPrettyString());
        keyId = response.then().extract().path("id") ;
        response.then().spec(responseSpec).body("key",equalTo(sshkey));
    }

    @Test(priority = 2)
    public void getRequest(){
        given().spec(requestSpec).pathParam("id",keyId).log().all().
                when().get("/{id}").then()
                .spec(responseSpec).statusCode(200).log().all();
    }

    @Test(priority = 3)
    public void deleteRequest(){
        given().spec(requestSpec).pathParam("id",keyId).log().all().
                when().delete("/{id}").then()
                .statusCode(204).log().all();
    }
}
