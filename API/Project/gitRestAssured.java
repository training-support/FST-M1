package com.ibm.Rest.GitHub_RestAssured_Project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class gitRestAssured {
	RequestSpecification requestSpec;
	int id;
	String ssh="removing it for safety concerns while uploading";
	@BeforeClass
	public void setUp() {
		String token ="removing it for safety concerns while uploading";
		
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer "+token)
				.setBaseUri("https://api.github.com")
				.build();
	}
	@Test(priority=1)

	public void post() {
		String reqBody = "{"
				+ "\"title\": \"TestAPIKey\","
				+ "\"key\":\""+ssh+"\""
				+ "}";
		Response response = given().spec(requestSpec) // Use requestSpec
				.body(reqBody) // Send request body
				.when().post("/user/keys"); // Send POST request

		id = response.then().extract().path("id");
		System.out.println(id);
		response.then()
		.statusCode(201);
	}
	@Test(priority=2)
	public void get() {
		Response response = given().spec(requestSpec) 
				.when().get("/user/keys"); 

		System.out.println( response.then().log().all());
	
		response.then()
		.statusCode(200);
	}
	@Test(priority=3)
	public void delete() {
		Response response = given().spec(requestSpec) 
				.when().delete("/user/keys"); 

		System.out.println( response.then().log().all());
	
		response.then()
		.statusCode(200);
	}

}
