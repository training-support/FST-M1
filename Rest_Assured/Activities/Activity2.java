package activities;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2Test{
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority=1)
    public void addNewUserFromFile() throws IOException {
         FileInputStream inputJSON = new FileInputStream("userinfo.json");
        String reqBody = new String(inputJSON.readAllBytes());

        Response response = 
            given().contentType(ContentType.JSON) 
            .body(reqBody) 
            .when().post(ROOT_URI); 

        inputJSON.close();

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("11111"));
    }
    
    @Test(priority=2)
    public void getUserInfo() {
        File outputJSON = new File("src/test/java/activities/userGETResponse.json");

        Response response = 
            given().contentType(ContentType.JSON) 
            .pathParam("username", "Himan012") 
            .when().get(ROOT_URI + "/{username}"); 
       
        String resBody = response.getBody().asPrettyString();

        try {

            outputJSON.createNewFile();
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        
        // Assertion
        response.then().body("id", equalTo(11111));
        response.then().body("username", equalTo("Himan012"));
        response.then().body("firstName", equalTo("Hima"));
        response.then().body("lastName", equalTo("Bindu"));
        response.then().body("email", equalTo("hima@amail.com"));
        response.then().body("password", equalTo("hima123"));
        response.then().body("phone", equalTo("1234567891"));
    }
    
    @Test(priority=3)
    public void deleteUser() throws IOException {
        Response response = 
            given().contentType(ContentType.JSON) 
            .pathParam("username", "justinc") 
            .when().delete(ROOT_URI + "/{username}"); 

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("Himan012"));
    }
}