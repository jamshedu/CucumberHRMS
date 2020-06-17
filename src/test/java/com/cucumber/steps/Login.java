package com.cucumber.steps;


import org.junit.Assert;

import com.cucumber.utels.CommonMethods;
import com.cucumber.utels.ConfigsReader;

import io.cucumber.java.en.*;



public class Login extends CommonMethods{
	
	@Given("user enter {string} and {string}")
	public void user_enter_and(String userNM, String pass) {
		sendText(loginPage.userName, userNM);
	    sendText(loginPage.passWord, pass);
	}

	@When("user enter login button")
	public void user_enter_login_button() {
	   click(loginPage.loginBN);
	}

//	@When("user see {string}")
//	public void user_see(String string) {
//	   
//	}

	@Then("user successfully loged in")
	public void user_successfully_loged_in() {
		
		String expected ="Welcome Admin";
		String actual =dashboardPage.welCome.getText();
		Assert.assertEquals("Welcome message is not displayed",expected, actual);
	   
	}

}
