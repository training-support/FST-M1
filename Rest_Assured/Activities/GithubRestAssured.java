import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GithubRestAssured {
    RequestSpecification reqSpecification;
    String key;
    int keyID;

    @BeforeClass
    public void setUp()
    {
        reqSpecification = new RequestSpecBuilder().setBaseUri("https://api.github.com")
                .addHeader("Content-Type","application/json")
                .setAuth(RestAssured.oauth2("ghp_JKWpo8HCBSgzaXQZcGCyqxwCNY"))
                .build();

    }
    @Test(priority = 1)
    public void postMethod()
    {
        Map<String,Object> reqBody = new HashMap<String,Object>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key","ssh-ed25519 AAAAIH4ePovTjy5Xj297fIhMC9DG");

        Response response = given().spec(reqSpecification).basePath("/user/keys").body(reqBody).when().post();

        key = response.then().extract().path("keyId");
        //print body of the response
        System.out.println(response.getBody().print());

        response.then().statusCode(201);
    }
    @Test(priority  = 2)
    public void getMethod()
    {
        Response response = given().spec(reqSpecification).pathParam("keyId",keyID).
                when().get("/{keyId}");
        System.out.println(response.getBody().print());
        response.then().statusCode(200);
    }
    @Test(priority = 3)
    public void deleteMethod()
    {
        Response response = given().spec(reqSpecification).pathParam("keyId",keyID)
                .when().delete("/{keyId}");
        System.out.println(response.getBody().print());
        response.then().statusCode(204);

    }
}
