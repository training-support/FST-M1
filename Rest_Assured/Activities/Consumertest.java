package pactPackage;
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
    Map<String, String> headers = new HashMap<>();
    // Set resource URI
    String createUser = "/api/users";

    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        DslPart bodySentCreateUser = new PactDslJsonBody()
                .numberType("id", 100)
                .stringType("firstName", "Vinoda")
                .stringType("lastName", "Jaganatha")
                .stringType("email", "vinoda.j@ibm.com");
        return builder.given("POST Request")
                .uponReceiving(" request to create a user")
                .method("POST")
                .path(createUser)
                .headers(headers)
                .body(bodySentCreateUser)
                .willRespondWith()
                .status(201)
                .body(bodySentCreateUser)
                .toPact();


    }


    @Test
    @PactTestFor(providerName="UserProvider",port="8282")
    public void ConsumerTest(){
        Map<String,Object> reqBody=new HashMap<>();
        reqBody.put("id",100);
        reqBody.put("firstName","Vinoda");
        reqBody.put("lastName","Jaganatha");
        reqBody.put("email","vinoda.j@ibm.com");
        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then()
                .statusCode(201)
                .body("email",equalTo("vinoda.j@ibm.com"))
                .log().all();



    }





}
