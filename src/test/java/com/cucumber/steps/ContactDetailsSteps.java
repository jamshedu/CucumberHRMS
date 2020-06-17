package com.cucumber.steps;

import com.cucumber.utels.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ContactDetailsSteps extends CommonMethods{
	
	@Given("user login with valid {string} and {string}")
	public void user_login_with_valid_and(String userNM, String passWD) {
		sendText(loginPage.userName, userNM);
		sendText(loginPage.passWord, passWD);
		click(loginPage.loginBN);
	  
	}

	@Given("user navigate to employee list")
	public void user_navigate_to_employee_list() {
		click(dashboardPage.pimClick);
	  click(dashboardPage.employeeList);
	}

	@Given("user search with id and click on {string}")
	public void user_search_with_id_and_click_on(String idSend) {
		
		wait(1);
		sendText(contaceDetails.sendID, idSend);
		click(contaceDetails.searchButton);
		click(contaceDetails.serchByID);
		
	  
	}

	@Given("user click on contacts details")
	public void user_click_on_contacts_details() {
		click(contaceDetails.contacDetai);
	   
	}

	@When("user add {string},{string},{string},{string},{string},{string},{string},{string},")
	public void user_add(String address, String city, String state, String zipCode, String country, String phone, String cellPhone, String email1) {
	  click(contaceDetails.editButton);
	  sendText(contaceDetails.addressOne, address);
	  sendText(contaceDetails.cityElement, city);
	  //sendText(contaceDetails.stateElement, state);
	  selectDdValue(contaceDetails.stateElement, state);
	  sendText(contaceDetails.zipCodeElements, zipCode);
	   selectDdValue(contaceDetails.selectCountry, country);
	   sendText(contaceDetails.homePhone, phone);
	   sendText(contaceDetails.celphone, cellPhone);
	   sendText(contaceDetails.email, email1);
	  click(contaceDetails.saveBTN);
	}

	@Then("user verified")
	public void user_verified() {
		click(contaceDetails.editButton);
		String address = "3334 Artesia #41";
		//Assert.assertEquals(address, contaceDetails.addressOne.getText());
		System.out.println(contaceDetails.addressOne.getText());
	    
	}



}
