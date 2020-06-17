package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;

public class ContactDetailsElements {
	
	
	
	@FindBy(xpath = "//input[@id='empsearch_id']")
	public WebElement sendID;
	
	@FindBy(xpath = "//input[@id='searchBtn']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='14444']")
	public WebElement serchByID;
	
	@FindBy(xpath = "//a[text()='Contact Details']")
	public WebElement contacDetai;
	
	@FindBy(id = "btnSave")
	public WebElement editButton;
	
	@FindBy(xpath = "//input[@id='contact_street1']")
	public WebElement addressOne;
	
	@FindBy(xpath = "//input[@id='contact_street2']")
	public WebElement addressTwo;
	
	@FindBy(xpath = "//input[@id='contact_city']")
	public WebElement cityElement;
	
	@FindBy(id = "contact_state")
	public WebElement stateElement;
	
	@FindBy(xpath = "//input[@id='contact_emp_zipcode']")
	public WebElement zipCodeElements;
	
	@FindBy(xpath = "//select[@id='contact_country']")
	public WebElement selectCountry;
	
	@FindBy(xpath = "//input[@id='contact_emp_hm_telephone']")
	public WebElement homePhone;
	
	@FindBy(xpath = "//input[@id='contact_emp_mobile']")
	public WebElement celphone;
	
	@FindBy(xpath = "//input[@id='contact_emp_work_telephone']")
	public WebElement workPhone;
	
	@FindBy(xpath = "//input[@id='contact_emp_work_email']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@id='contact_emp_oth_email']")
	public WebElement otherEmail;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement saveBTN;
	
	public ContactDetailsElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
