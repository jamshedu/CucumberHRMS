package com.cucumber.steps;

import org.junit.Assert;

import com.cucumber.utels.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps extends CommonMethods{
	
	@Given("user navigate to addEmployee page")
	public void user_navigate_to_addEmployee_page() {
		click(loginPage.loginBN);
		dashboardPage.navigatToAddEmployee();
	   
	}

	@Given("user enter employee {string} and {string} and {string}")
	public void user_enter_employee_and_and(String name, String middleNM, String lastname) {
		sendText(empAdd.firsName, name);
		sendText(empAdd.middleName,middleNM);
		sendText(empAdd.lastName, lastname);
	    
	}

	@Given("user enter save button")
	public void user_enter_save_button() {
		click(empAdd.saveButton);
	   
	}

	@Then("user successfully add employee")
	public void user_successfully_add_employee() {
		String expected="Orzu O Smith";
		String actual = empAdd.profilePic.getText();
		Assert.assertEquals("The name is not present ",expected,actual);
	    
	}
	
	@When("user enters employee {string} and {string}")
	public void user_enters_employee_and(String string, String string2) {
	   
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	   
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	 
	}

	@Then("{string} is added successfully")
	public void is_added_successfully(String string) {
	   
	}





}
