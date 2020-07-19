package com.hrms_API.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Test;
public class HardcodeExamples{

	/**
	 * Rest Assured
	 * Given --> prepare your request 
	 * When  --> you are makinng the call to the endpoint 
	 * Then  -->validating 
	 * 
	 * @param args
	 */
	
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	
	String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNDE0ODMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTE4NDY4MywidXNlcklkIjoiNjc3In0.y-ZGC1bKyflCdc7DesjRIOHWaVzr6bjWD5pdHo0UXtI";
	
	
	
	public void sampleTest() {
		

		
		/**
		 * BaseURI for all calls
		 */
		
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		
		/**
		 * JWT required for all calls - expiresevery 12 hours
		 */
		
		String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNDE0ODMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTE4NDY4MywidXNlcklkIjoiNjc3In0.y-ZGC1bKyflCdc7DesjRIOHWaVzr6bjWD5pdHo0UXtI";
		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id","16490A").log().all();;
		
		/**
		 * Storing response
		 */
		 Response getOneEmployeeResponse =getOneEmployeeRequest.when().get("/getOneEmployee.php");
		     /**
			 * 
			 * Two way to print response
			 * prityPrint() method 
			 */
			getOneEmployeeResponse.prettyPrint();
			//String response=getOneEmployeeResponse.body().asString();
			
			/**
			 * 
			 * verifying response status code is 200
			 */
			getOneEmployeeResponse.then().assertThat().statusCode(200);
			
		
	}
	
	
	@Test
	public void aPOSTcreateEmployee() {	
	RequestSpecification createEmployeeRequest=	given().header("Content-Type","application/json")
			.header("Authorization",token).body("{\n" + 
					"  \"emp_firstname\": \"syntaxFirstName\",\n" + 
					"  \"emp_lastname\": \"syntaxLastName\",\n" + 
					"  \"emp_middle_name\": \"syntaxMiddleName\",\n" + 
					"  \"emp_gender\": \"F\",\n" + 
					"  \"emp_birthday\": \"2000-07-11\",\n" + 
					"  \"emp_status\": \"Employee\",\n" + 
					"  \"emp_job_title\": \"Cloud Architect\"\n" + 
					"}");
	
	
	Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
	
	createEmployeeResponse.prettyPrint();
	
	
	
	}
		
}
	
		
		
		
		
		
		
	
		
		
		

