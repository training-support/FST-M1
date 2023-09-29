package activities;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class PackConsumerTest {

    // Create Map for the headers
    Map<String, String> headers = new HashMap<String, String>();
    // Set resource URI
    String createUser = "/api/users";

    // Create Pact contract
    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        // Add headers



        // Create request JSON
        DslPart bodySentCreateUser = new PactDslJsonBody()
                .numberType("id", 1)
                .stringType("firstName", "string")
                .stringType("lastName", "string")
                .stringType("email", "string");


        // Create response JSON
        DslPart bodyReceivedCreateUser = new PactDslJsonBody()
                .numberType("id", 1)
                .stringType("firstName", "string")
                .stringType("lastName", "string")
                .stringType("email", "string");

// Create rules for request and response
        return builder.given("A request to create a user")
                .uponReceiving("A request to create a user")
                .path(createUser)
                .method("POST")
                .headers(headers)
                .body(bodySentCreateUser)
                .willRespondWith()
                .status(201)
                .body(bodyReceivedCreateUser)
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
        map.put("firstName", "Justin");
        map.put("lastName", "Case");
        map.put("email", "justincase@mail.com");

        Response response = rq.body(map).post(createUser);
        // Assertion
        assert (response.getStatusCode() == 201);
    }



    @Provider("UserProvider")
    @PactFolder("target/pacts")
    public class PactProviderTest {
        @BeforeEach
        void before(PactVerificationContext context) {
            // Set target for provider to send request to
            context.setTarget(new HttpTestTarget("localhost", 8585));
        }

        @TestTemplate
        @ExtendWith(PactVerificationInvocationContextProvider.class)
        void pactTestTemplate(PactVerificationContext context) {
            // Verify the interaction between Consumer and Provider
            // using the contract generated in target/pacts
            context.verifyInteraction();
        }
        // State to send the call to consumer
        @State("A request to create a user")
        public void sampleState() {}



    }







}
