package com.cucumber.steps;

import com.cucumber.utels.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EmargencyContactsSteps extends CommonMethods{
	
	
	@Given("user click on emrgency contacts")
	public void user_click_on_emrgency_contacts() {
	   click(emargencyContacts.emargencyContact);
	}

	@Given("user click on add button")
	public void user_click_on_add_button() {
		click(emargencyContacts.addButton);
	   
	}

	@Given("user fill uot emergency contacts {string},{string},{string},{string},{string}")
	public void user_fill_uot_emergency_contacts(String friendName, String friends, String homeTelephone, String celphon, String workContact) {
	  sendText(emargencyContacts.emergencyName, friendName);
	  sendText(emargencyContacts.friendShip, friends);
	  sendText(emargencyContacts.mobilePhone, homeTelephone);
	  sendText(emargencyContacts.mobilePhone,celphon );
	  sendText(emargencyContacts.workPhone,workContact );
	}

	@Then("user click on save botton")
	public void user_click_on_save_botton() {
		click(emargencyContacts.contactSaveButton);
	   
	}


}
