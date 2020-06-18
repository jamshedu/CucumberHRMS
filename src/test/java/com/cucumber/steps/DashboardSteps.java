package com.cucumber.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.cucumber.utels.CommonMethods;
import com.cucumber.utels.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps extends CommonMethods{
	
	@When("user is logged in with valid admin credentials")
	public void user_is_logged_in_with_valid_admin_credentials() {
	  sendText(loginPage.userName, ConfigsReader.getProparty("userNM"));
	  sendText(loginPage.passWord, ConfigsReader.getProparty("passWORD"));
	  click(loginPage.loginBN);
	  
	}

	@Then("user see dashboard menu is displayed")
	public void user_see_dashboard_menu_is_displayed(DataTable dataTable) {
	  List<String>expectedMenu= dataTable.asList();
	  List<String>actualMenu=new ArrayList<>();
	  for (WebElement el : dashboardPage.dashboardMenu) {
		  actualMenu.add(el.getText());
		
	}
	  System.out.println(expectedMenu);
	  System.out.println(actualMenu);
	  Assert.assertTrue(actualMenu.equals(expectedMenu));
	  
	}


}
