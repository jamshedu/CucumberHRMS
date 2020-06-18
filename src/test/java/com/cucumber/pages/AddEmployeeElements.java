package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeeElements {
	
	
	@FindBy(xpath ="//input[@id='firstName']" )
	public WebElement firsName;
	
	@FindBy(xpath = "//input[@id='middleName']")
	public WebElement middleName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@id='employeeId']")
	public WebElement idEmployee;
	
	@FindBy(xpath = "personal_txtLicenNo")
	public WebElement driverLicenseNumber;
	
	@FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
	public WebElement licensExpireDate;
	
	@FindBy(xpath = "//input[@id='personal_txtNICNo']")
	public WebElement ssNumber;
	
	@FindBy(xpath ="//input[@id='personal_txtSINNo']" )
	public WebElement sinNumber;
	
	@FindBy(xpath = "//label[text()='Male']")
	public WebElement maleRadioButton;
	
	@FindBy(xpath = "//label[text()='Female']")
	public WebElement femaleRadioPutton;
	
	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	public WebElement maritalStatus;
	
	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	public WebElement nationalty;
	
	@FindBy(xpath = "//input[@id='personal_DOB']")
	public WebElement dateOfBirthday;
	
	@FindBy(xpath = "//input[@id='personal_txtEmpNickName']")
	public WebElement nickName;
	
	@FindBy(xpath = "//input[@id='personal_chkSmokeFlag']")
	public WebElement smokerCheck;
	
	@FindBy(xpath = "//input[@id='personal_txtMilitarySer']")
	public WebElement militaryService;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement editButton;

}
