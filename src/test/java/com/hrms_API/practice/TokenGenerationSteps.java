package com.hrms_API.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class TokenGenerationSteps {
	/**
	 * Stoking token as static varible 
	 */
	public static String token;
	String BaseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
	RequestSpecification generateTokenRequest=given().header("Content-Type","application/json").body("{\n" + 
				"  \"email\": \"Jamshed1988@gmail.com\",\n" + 
				"  \"password\": \"01061988\"\n" + 
				"}");
		
		
	Response generateTokenResponse=generateTokenRequest.when().post("/generateToken.php");
		
	//generateTokenResponse.prettyPrint();
		/**
		 * Retrieving token from generate response body and concatenating  "Bearer"
		 */
	token="Bearer "+generateTokenResponse.body().jsonPath().getString("token");
	System.out.println(token);
		
	   
	}

}
