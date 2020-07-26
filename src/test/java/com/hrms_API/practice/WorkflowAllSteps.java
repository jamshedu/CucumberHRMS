package com.hrms_API.practice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.hrmsAPI.utils.APIConstance;
import com.hrmsAPI.utils.PayloadConstants;
public class WorkflowAllSteps {
	
	String BaseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	RequestSpecification request;
	Response response;
	static String emplID;
	
	
	
	
	@Given("a request is prepared to create an employee")
	public void a_request_is_prepared_to_create_an_employee() {
		
   request= given().header("Content-Type","application/json").header("Authorization",TokenGenerationSteps.token)
	 .body(PayloadConstants.createEmployeeBody());
	}

	@When("a POST call is made to create an employee")
	public void a_POST_call_is_made_to_create_an_employee() {
	 response=request.when().post(APIConstance.CREATE_EMPLOYEE_ENDPOINT);
	}

	@Then("the status code for creating an employee is {int}")
	public void the_status_code_for_creating_an_employee_is(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@Then("the employee is created and response contains key {string} and value {string}")
	public void the_employee_is_created_and_response_contains_key_and_value(String key, String value ) {
		response.then().assertThat().body(key, equalTo(value));
	}

	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
		 emplID=response.body().jsonPath().getString(empID);
		 System.out.println(emplID);
	}






}
