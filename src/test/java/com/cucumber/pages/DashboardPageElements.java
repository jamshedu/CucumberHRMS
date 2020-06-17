package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utels.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	//14444
	@FindBy(xpath = "//a[@id='welcome']")
    public WebElement welCome;
	
	@FindBy(xpath = "//div[@class='menu']/ul/li[2]/a")
	public WebElement pimClick;
	
	@FindBy(xpath = "//a[text()='Employee List']")
	public WebElement employeeList;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmployee;
	
	@FindBy(id = "firstName")
	public WebElement employeeFirstName;
	
	@FindBy(id = "middleName")
	public WebElement middleName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
			
		}
	public void navigatToAddEmployee() {
		jsClick(pimClick);
		jsClick(addEmployee);
	}
		
		
	}


