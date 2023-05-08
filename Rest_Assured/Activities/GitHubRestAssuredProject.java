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
import static org.hamcrest.Matchers.lessThan;

public class GitHubRestAssuredProject {
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIOwtDfOWDrot9TwrN1z626hldcS5DlOMKxheppcqQN+m";
    int sshKeyId;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", "token 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")
                .addHeader("Content-Type", "application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(15000L))
                .expectBody("key", equalTo(sshKey))
                .expectBody("title", equalTo("TestAPIKey"))
                .build();
    }

    @Test(priority = 1)
    public void PostRequestTest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        Response response = given().log().all().spec(requestSpec).body(reqBody).when().post();
        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest() {
        given().log().all().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().get("/{keyId}")
                .then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        given().log().all().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().delete("/{keyId}")
                .then().statusCode(204).time(lessThan(5000L));
    }

}
