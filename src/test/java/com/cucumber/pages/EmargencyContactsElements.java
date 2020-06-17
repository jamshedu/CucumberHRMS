package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;

public class EmargencyContactsElements {
	
	@FindBy(xpath = "//ul[@id='sidenav']/li[3]/a")
	public WebElement emargencyContact;
	
	@FindBy(id = "btnAddContact")
	public WebElement addButton;
	
	@FindBy(id = "emgcontacts_name")
	public WebElement emergencyName;
	
	@FindBy(id = "emgcontacts_relationship")
	public WebElement friendShip;
	
	@FindBy(id = "emgcontacts_homePhone")
	public WebElement homePhone;
	
	@FindBy(id = "emgcontacts_mobilePhone")
	public WebElement mobilePhone;
	
	@FindBy(id = "emgcontacts_workPhone")
	public WebElement workPhone;
	
	@FindBy(id="btnSaveEContact")
	public WebElement contactSaveButton;
	
	public EmargencyContactsElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	

}
