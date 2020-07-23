package com.hrms_API.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * Rest assured static packages
 */
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;
//import org.apache.hc.core5.http.ContentType;
/**
 * This @FixMethodOrder (MethodSortOrder.Name_Ascending)will execute @Test annotation in ascending 
 * alphabetical order
 * @author dzhamshedumarov
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)




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
	
	
	static String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU1MjUwNzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTU2ODI3MSwidXNlcklkIjoiNjQ1In0.WdByPg73viXoyVw1e-9lLmyqwJWkhpEOfW8vtWH0QI8";
	static String employeeID;
	
	
	
	
	
	
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
		
		/**
		 * Preparing request for / createEmployee.php
		 * 
		 */
	RequestSpecification createEmployeeRequest=	given().header("Content-Type","application/json")
			.header("Authorization",token).body("{\n" + 
					"  \"emp_firstname\": \"syntaxFirstName\",\n" + 
					"  \"emp_lastname\": \"syntaxLastName\",\n" + 
					"  \"emp_middle_name\": \"syntaxMiddleName\",\n" + 
					"  \"emp_gender\": \"F\",\n" + 
					"  \"emp_birthday\": \"2000-07-11\",\n" + 
					"  \"emp_status\": \"Employee\",\n" + 
					"  \"emp_job_title\": \"Cloud Architect\"\n" + 
					"}").log().all();
	
	
	Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
	
	/**
	 * 
	 * Storing response using prettyPrint()method
	 */
	createEmployeeResponse.prettyPrint();
	
	/**
	 * 
	 * jsonPath() to view response 
	 */
	
	 employeeID=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
	 
	 
	System.out.println(employeeID);
	
	/**
	 * Verifying response status code is 201
	 * 
	 */
	createEmployeeResponse.then().assertThat().statusCode(201);
	
	/**
	 * Verifying message using equalTo() method - manully import static package 
	 */
	
	createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
	
	createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("syntaxFirstName"));
	
	createEmployeeResponse.then().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");
	
	//createEmployeeResponse.then().assertThat().body("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));
	
	}

	@Test
	public void bGETcreatedEmployee() {

		
	RequestSpecification getCreatedEmployee=given().header("Content-Type","application/json")
			.header("Authorization",token).queryParam("employee_id", employeeID).log().all();
		
	/**
	 * Making call to created employee
	 * 
	 */
	Response getCreatedEmployeeResponse=getCreatedEmployee.when().get("/getOneEmployee.php");
		
	String response=getCreatedEmployeeResponse.prettyPrint();
	
	String empID=getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
	
	/**
	 * Storing respons employeeID into empID which will be used for verification 
	 * against stored
	 */
	boolean verifyingEmployeeID=empID.equalsIgnoreCase(employeeID);
	//boolean verifyingEmployeeID=empID.contentEquals(employeeID);
	//System.out.println("Employee ID is matchs"+verifyingEmployeeID=empID);
	/**
	 * Asserting employee ID's match
	 */
	Assert.assertTrue(verifyingEmployeeID);
	
	
	getCreatedEmployeeResponse.then().assertThat().statusCode(200);
	
	
	JsonPath js = new JsonPath(response);
	String emplID=js.getString("employee[0].employee_id");
	String firstName=js.getString("employee[0].emp_firstname");
	String midelName=js.getString("employee[0].emp_middle_name");
	String lastname=js.getString("employee[0].emp_lastname");
	String birthday=js.getString("employee[0].emp_birthday");
	String gender=js.getString("employee[0].emp_gender");
	String jobTitle=js.getString("employee[0].emp_job_title");
	String empStatus=js.getString("employee[0].emp_status");

	
	System.out.println(emplID);
	System.out.println(firstName);
	/**Verifying expected ID is match */
	Assert.assertTrue(emplID.contentEquals(employeeID));
	
	/** Verifying expected firstname matches actual name */
	Assert.assertTrue(firstName.contentEquals("syntaxFirstName"));
	
	/** Verifying exepected midelName matches actual niddle name */
	//Assert.assertTrue(midelName.contentEquals("syntaxMiddleNam"));
	
	Assert.assertTrue(midelName.contentEquals("syntaxMiddleName"));
	
	/** Verifying expected lastname matches actual lastname*/
	Assert.assertTrue(lastname.contentEquals("syntaxLastName"));
	
	/** Verifying expected birthday matches actual birthday */
	Assert.assertTrue(birthday.contentEquals("2000-07-11"));
	
	/**Verifying expected gender matches actual gender */
	Assert.assertTrue(gender.contentEquals("Female"));
	
	/** Verifying expected jobTitle matches actual jobTitle */
	Assert.assertTrue(jobTitle.contentEquals("Cloud Architect"));
	//Assert.assertTrue(empStatus.contentEquals("Cloud Architect"));
	}

	@Test
    public void cgetAllEmployees() {
		/**	
	     * 
	     * Preparing getAllEloyees request
	     */
	    	
	    RequestSpecification getAllEmployeesRequest=given().header("Content-Type","application/json").header("Authorization",token);
	    
	    
	   Response getAllEmployeesResponse=getAllEmployeesRequest.when().get("/getAllEmployees.php");
	    	
	   //getAllEmployeesResponse.prettyPrint();
	   
	   
	   String allEmployee=getAllEmployeesResponse.body().asString();
	   
	   /**
	    * The below will pass but incorect 
	    */
	  // allEmployee.contains(employeeID);
	   
	   /**
	    * -------DO Research--------
	    */
	   //allEmployee.matches(employeeID);
	   
	   
	   JsonPath js= new JsonPath(allEmployee);
	   
	   /**
	    * Retrieving size of Employees list
	    */
	  int sizeOfList= js.getInt("Employees.size()");
	   System.out.println(sizeOfList);
	   
	   /**
	    * Pring all the employeeys ID's
	    */
	   
	//   for(int i =0;i<sizeOfList;i++) {
//		   
	//   
	//  String allEmployeeIDs= js.getString("Employees["+i+"].employee_id");
	//  // System.out.println(allEmployeeIDs);
	//  
	//  /**
	//   * 
	//   */
	//  
	//  if(allEmployeeIDs.contentEquals(employeeID)) {
//		  System.out.println("Employee ID: "+employeeID +" is present inbody");
//		  
//		  String employeeFirstName= js.getString("Employees["+i+"].emp_firstname");
//		  System.out.println(employeeFirstName);
//		  break;
		
		
		}
		
	
	@Test
	public void dPUTupdateCreatedEmployee() {
		
		RequestSpecification updateCreatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token)
				.body("{\n" + 
						"  \"employee_id\": \""+employeeID+"\",\n" + 
						"  \"emp_firstname\": \"syntaxUpdatedFirstName\",\n" + 
						"  \"emp_lastname\": \"syntaxUpdatedLastName\",\n" + 
						"  \"emp_middle_name\": \"syntaxUpdatedMiddleName\",\n" + 
						"  \"emp_gender\": \"F\",\n" + 
						"  \"emp_birthday\": \"2000-07-11\",\n" + 
						"  \"emp_status\": \"Employee\",\n" + 
						"  \"emp_job_title\": \"Cloud Consultant\"\n" + 
						"}");
				
				Response updateCreatedEmployeeResponse=updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
				
				String response=updateCreatedEmployeeResponse.prettyPrint();
				}		

	@Test
	public void eGETupdatedEmployee() {
		
	RequestSpecification getUpdatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token)
			.queryParam("employee_id",employeeID ).log().all();
	
Response getUpdatedEmployeeRespone = getUpdatedEmployeeRequest.when().get("/getOneEmployee.php");
	
	
getUpdatedEmployeeRespone.prettyPrint();
	
getUpdatedEmployeeRespone.then().assertThat().statusCode(200);
	
	
	}
	
	public void fPATCHpartiallyEmployee() {
		
	 RequestSpecification patchPartiallyEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token)
		.body("{\n" + 
				"  \"employee_id\": \""+employeeID+"\",\n" + 
				"  \"emp_firstname\": \"syntaxPartiallyUpdatedFirstName\"\n" + 
				"}");
	 
	Response patchPartiallyEmployeeResponse= patchPartiallyEmployeeRequest.when().patch("/updatePartialEmplyeesDetails.php");
	
	
	patchPartiallyEmployeeResponse.prettyPrint();
	
	patchPartiallyEmployeeResponse.then().assertThat().statusCode(201);
	
	}

	
	public void gGETemployeeStatusEmployee() {
		
	RequestSpecification getEmployeeStatusRequest=	given().header("Content-Type","application/json").header("Authorization",token);
	
	Response getEmployeeStatusResponse=	getEmployeeStatusRequest.when().get("/employeeStatus.php");
	
	getEmployeeStatusResponse.prettyPrint();
	
	String employeeStatus=getEmployeeStatusResponse.body().asString();
	JsonPath js= new JsonPath(employeeStatus);
	int sizwOfEmployeeStatus=js.getInt("Status.size()");
	System.out.println(sizwOfEmployeeStatus);
	
	getEmployeeStatusResponse.then().assertThat().statusCode(200);
	
	}
	public void hGETJobTitleEmployee() {
		
		given().header("Content-Type","application/json").header("Authorization",token);
	}
	
}		
		
		
	
		
		
	
		
		
		

