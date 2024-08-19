package project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //Set the headers
    Map<String, String> headers = new HashMap<>();


    //Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Set headers
        headers.put("Content-Type","application/json");

        //Create JSON Body
        DslPart reqResBody = new PactDslJsonBody()
                .numberType("id", 123)
                .stringType("firstName", "Avani")
                .stringType("lastName", "Maheshwari")
                .stringType("email", "avani@example.com");

        //Create the contract(Pact)
        return builder.given("POST Request")
                .uponReceiving("A request to create a User")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqResBody)
                .willRespondWith()
                .status(201)
                .body(reqResBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest(){
        Map<String , Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Avani");
        reqBody.put("lastName", "Maheshwari");
        reqBody.put("email", "avani@example.com");

        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().log().all().
                when().post().
                then().statusCode(201).body("email", equalTo("avani@example.com")).log().all();

    }

}
