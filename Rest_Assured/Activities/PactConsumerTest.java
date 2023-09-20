package project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class PactConsumerTest {

    // Create Map for the headers
    Map<String, String> headers = new HashMap<String, String>();
    // Set resource URI
    String createUser = "/api/users";

    // Create Pact contract
    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {
        // Add headers
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        // Create request and response JSON
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id", 1)
                .stringType("firstName", "Sayani")
                .stringType("lastName", "Aich")
                .stringType("email", "sayaniaich@test.com");
        // Create rules for request and response
        return builder.given("A request to create a user")
                .uponReceiving("A request to create a user")
                .path(createUser)
                .method("POST")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void runTest() {
        // Mock url
        RestAssured.baseURI = "http://localhost:8080";
        // Create request specification
        RequestSpecification rq = RestAssured.given().headers(headers).when();

        // Create request body
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("firstName", "Sayani");
        map.put("lastName", "Aich");
        map.put("email", "sayaniaich@test.com");

        // Send POST request
        Response response = rq.body(map).post(createUser);
        // Assertion
        assert (response.getStatusCode() == 201);
    }
}
