package com.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.testbase.BaseClass;
import com.cucumber.utels.CommonMethods;

public class LoginPaigeElements extends CommonMethods{
	
	
	@FindBy(id = "txtUsername")
	public WebElement userName;
	
	@FindBy(id = "txtPassword")
	public WebElement passWord;
	
	@FindBy(id = "btnLogin")
	public WebElement loginBN;
	
	@FindBy(xpath = "//a[text()='Welcome Admin']")
	public WebElement welcomeAdmin;
	
	
	public LoginPaigeElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void loginPage(String uid,String psw) {
		sendText(userName, uid);
		sendText(passWord, psw);
		click(loginBN);
		
	}

}
