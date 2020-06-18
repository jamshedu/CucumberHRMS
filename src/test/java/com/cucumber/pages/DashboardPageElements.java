package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utels.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	//14444
	@FindBy(xpath = "//a[@id='welcome']")
    public WebElement welCome;
	
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	public WebElement adminDashboard;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement pimClick;
	
	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveModule']")
	public WebElement leaveElements;
	
	@FindBy(xpath = "//a[@id='menu_time_viewTimeModule']")
	public WebElement timeElements;
	
	@FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']")
	public WebElement recruitmentElements;
	
	@FindBy(xpath = "//a[@id='menu__Performance']")
	public WebElement perfonmanceElements;
	
	@FindBy(xpath = "//a[@id='menu_dashboard_index']")
	public WebElement dashboardElement;
	
	@FindBy(xpath = "//a[@id='menu_directory_viewDirectory']")
	public WebElement diractoryElements;
	
	@FindBy(xpath = "//a[@id='menu_pim_Configuration']")
	public WebElement configurationElements;
	
	@FindBy(xpath = "//a[text()='Employee List']")
	public WebElement employeeList;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmployee;
	
	@FindBy(xpath = "//a[@id='menu_core_viewDefinedPredefinedReports']")
	public WebElement reportsElements;
	
	@FindBy(xpath = "//div[@class='menu']/ul/li")
	public List<WebElement> dashboardMenu;
	
	@FindBy(id = "firstName")
	public WebElement employeeFirstName;
	
	@FindBy(id = "middleName")
	public WebElement middleName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;
	
	
	
	
	
	
	
	@FindBy(xpath = "//a[@id='menu_core_viewDefinedPredefinedReports']")
	public WebElement reportElements;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
			
		}
	public void navigatToAddEmployee() {
		jsClick(pimClick);
		jsClick(addEmployee);
	}
		
		
	}


