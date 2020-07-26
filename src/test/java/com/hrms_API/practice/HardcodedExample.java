package com.hrms_API.practice;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * Rest assured static packages
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/**
 * importing JUnit packages
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.hrmsAPI.utils.PayloadConstants;

//import org.junit.apache.hc.core5.http.ContentType;
/**
 * Rest Assured 
 * given -prepare your request when - you are making the call to the enpoint
 * then - validating 
 * @author dzhamshedumarov
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExample {
	
	/**
	 * Rest Assured
	 * given - prepare your request
	 * when - you are making the call to the enpoint
	 * then validation  
	 * 
	 * 
	 * @param args
	 */
	static String baseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
	static String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU3ODIwMjYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTgyNTIyNiwidXNlcklkIjoiNjQ1In0._kTw0y2FgvfRLtfaVhp_p8k6_mhk4y_B0PIDwiNBNlk";
	 public static String  employeeID;

	
	public void sampleTestNotes() {
		/**
		 * BaseURI for all calls
		 */
		
		RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
		
		/**
		 * 
		 * JWT required for all calls -expires every 12 hours
		 */
		String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU3ODIwMjYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTgyNTIyNiwidXNlcklkIjoiNjQ1In0._kTw0y2FgvfRLtfaVhp_p8k6_mhk4y_B0PIDwiNBNlk";
		
		/**
		 * Preparing getOneEmployee
		 * 
		 */
RequestSpecification	getOneEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token)
.queryParam("employee_id", "20436A").log().all();
		/**
		 * Storing response
		 */
 Response getOneEmployeeResponse=getOneEmployeeRequest.when().get("/getOneEmployee.php");
		/**
		 * Two ways print response
		 * Prityprint() method  converts JSON object int string and print - no need SOP
		 */
       getOneEmployeeResponse.prettyPrint();
		//String response = getOneEmployeeResponse.body().asString();
         //System.out.println(getOneEmployeeResponse);
		/**
		 * Verifying respons status code is 200
		 */
       getOneEmployeeResponse.then().assertThat().statusCode(200);
		
	}

	@Test
	public void aPostcreateEmployee() {
		
		/**
		 * Preparing request for / createdEmployee.php
		 */
		
RequestSpecification createdEmployeeRequest=	given().header("Content-Type","application/json").header("Authorization",token)
.body("{\n" + 
		"  \"emp_firstname\": \"syntaxFirstName\",\n" + 
		"  \"emp_lastname\": \"syntaxLastName\",\n" + 
		"  \"emp_middle_name\": \"syntaxMiddleName\",\n" + 
		"  \"emp_gender\": \"F\",\n" + 
		"  \"emp_birthday\": \"2000-07-11\",\n" + 
		"  \"emp_status\": \"Employee\",\n" + 
		"  \"emp_job_title\": \"Cloud Architect\"\n" + 
		"}");
/**
 * Storing Response into createdEmployee
 */
    Response createdEmployeeResponse  =createdEmployeeRequest.when().post("/createEmployee.php");
/**
 * Printing response using prettyPrit() method
 */
    createdEmployeeResponse.prettyPrint();
    /**
     * jsonPath() to view response body which lets us get the employee ID We stored 
     * employee ID as a globale so that we may we use it with other calls 
     */
  employeeID  =createdEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

System.out.println(employeeID);
/**
 * Verifying response status code is 201
 */
createdEmployeeResponse.then().assertThat().statusCode(201);
 /**
  * Verifying message using equalTo() method - manually import static package 
  * import statiac org.hamcrest.Matchers.*;
  */

createdEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
/**
 * Verifying created employee  firstname
 */
createdEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname",equalTo("syntaxFirstName"));
/**
 * verifying employee middle name
 */
createdEmployeeResponse.then().assertThat().body("Employee[0].emp_middle_name",equalTo("syntaxMiddleName"));
/**
 * Verifying server using then().header()
 */
createdEmployeeResponse.then().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
/**
 * Verifying Content-Type using assertThat().header()
 */
createdEmployeeResponse.then().assertThat().header("Content-Type", "application/json");


}
	@Test
	public void bGETcreatedEmployee() {
		/**
		 * Preparing request for /getOneEmployee.php
		 */
	
	RequestSpecification getCreatedEmployeeRequest=	given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id", employeeID).log().all();
		/**
		 * Making call to retrieve created employee
		 */
		
	 Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		
	 String response=getCreatedEmployeeResponse.prettyPrint();
		
	 String empID=getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		boolean verifyinEmployeeIDsMatch=empID.equalsIgnoreCase(employeeID);
		
		Assert.assertTrue(verifyinEmployeeIDsMatch);
		
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		JsonPath js = new JsonPath(response);
		String emplID=js.getString("employee[0].employee_id");
		String firstName=js.getString("employee[0].emp_firstname");
		String middleName=js.getString("employee[0].emp_syntaxMiddleName");
		String lastName=js.getString("employee[0].emp_lastname");
		String birthday=js.getString("employee[0].emp_birthday");
		String gender=js.getString("employee[0].emp_gender");
		String job=js.getString("employee[0].emp_job_title");
		String status=js.getString("employee[0].emp_status");
		System.out.println(emplID);
		
		
		Assert.assertTrue(emplID.contentEquals(employeeID));
		/**Verifying expected firstname matches actual first name */
		Assert.assertTrue(firstName.contentEquals("syntaxFirstName"));
		/** Verifying last name matches actual last name*/
		Assert.assertTrue(lastName.contentEquals("syntaxLastName"));
		
		/** Verifying employee birthday matches actual birthday*/
		Assert.assertTrue(birthday.contentEquals("2000-07-11"));
		
		/** Verifying expected gender matches actual gender*/
		Assert.assertTrue(gender.contentEquals("Female"));
		
		Assert.assertTrue(job.contentEquals("Cloud Architect"));
		Assert.assertTrue( status.contentEquals("Employee"));
		
		
		
	}

	@Test
	public void cGETallEmployees() {

		/**
		 * Preparing /getAllEmployees.php request
		 */
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/**
		 * Storing response into getAllEmployeesResponse
		 */
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		/**
		 * Printing all employees
		 */
		 //getAllEmployeesResponse.prettyPrint();
	
		 String allEmployees = getAllEmployeesResponse.body().asString();

			/**
			 * The below will pass but incorrect
			 */
			// allEmployees.contains(employeeID);
			/**
			 * ----------- DO RESEARCH ------------
			 */
			// allEmployees.matches(employeeID);

			JsonPath js = new JsonPath(allEmployees);

			/**
			 * Retrieving size of Employees list
			 */
			int sizeOfList = js.getInt("Employees.size()");

			System.out.println(sizeOfList);

//			/**
//			 * Print out all employee ID's
//			 */
//
//			for (int i = 0; i < sizeOfList; i++) {
//	//
//				/**
//				 * Printing all employee IDs
//				 */
//				String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//				// System.out.println(allEmployeeIDs);
//	//
//				/**
//				 * If statement inside for loop to find stored employee ID and break the loop
//				 * when found 
//				 */
//	
//				if (allEmployeeIDs.contentEquals(employeeID)) {
//	
//					System.out.println("Employee ID: " + employeeID + " is present in body");
//					String employeeFirstName = js.getString("Employees[" + i + "].emp_firstname");
//					System.out.println(employeeFirstName);
//					
//					
//					break;
//	
//				}
//	
//			}
	}
	
	@Test
	public void dPUTupdateCreatedEmployee() {
		
		/**
		 * Preparing request to update created employee
		 * calling static method updateCtreatedEmpBody() from HardcodedConstants class
		 */

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body(PayloadConstants.updateCreatedEmpBody());

		/**
		 * Storing response into updateCreatedEmployeeResponse
		 */
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/**
		 * Storing response into a String
		 */
		String response = updateCreatedEmployeeResponse.prettyPrint();
		
		/**
		 * Asserting using hamcrest matchers equalTo() method to verify employee is updated
		 */
		updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
		
		/**
		 * Retrieving response body employee ID using jsontPath()
		 */
		String empID = updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		/**
		 * Asserting that response body employee ID matches globally stored employee ID 
		 */
		Assert.assertTrue(empID.contentEquals(employeeID));
		
	}
	
	
	@Test
	public void eGETUpdatedEmployee() {
		
		/**
		 * Preparing request to get updated employee
		 */
	RequestSpecification getUpdatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
	/**
	 * Storing response into getUpdatedEmployeeResponse
	 */
	Response getUpdatedEmployeeResponse = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
	
	/**
	 * Printing response 
	 */
	//getUpdatedEmployeeResponse.prettyPrint();
		
	/**
	 * Asserting expected first name 
	 */
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname", equalTo("syntaxUpdatedFirstName"));
		
	/**
	 * Verifying response employee ID is equal to globally stored employee ID 
	 */
	getUpdatedEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(employeeID));
	
	}
	@Test
	public void fPATCHpartiallyUpdateEmployee() {
		
	RequestSpecification partiallyUpdatingEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).body("{\n" + 
				"  \"employee_id\": \""+ employeeID +"\",\n" + 
				"  \"emp_firstname\": \"syntaxPartiallyUpdatedFirstName\"\n" + 
				"}");
		
	Response partiallyUpdatingEmployeeResponse = partiallyUpdatingEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
		
	//partiallyUpdatingEmployeeResponse.prettyPrint();
	
	partiallyUpdatingEmployeeResponse.then().assertThat().statusCode(201);
		
	partiallyUpdatingEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
	}
	@Test
	public void gDELETEemployee() {
		
	RequestSpecification deleteEmployeeRequest = given().header("Content-Type","application/json").header("Authorization", token).queryParam("employee_id", employeeID);
		
	Response deleteEmployeeResponse = deleteEmployeeRequest.when().delete("/deleteEmployee.php");
	
	deleteEmployeeResponse.prettyPrint();
	
	deleteEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
	
	}

	
	
}
