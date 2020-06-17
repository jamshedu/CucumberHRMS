package com.cucumber.testbase;

import com.cucumber.pages.ContactDetailsElements;
import com.cucumber.pages.DashboardPageElements;
import com.cucumber.pages.EmargencyContactsElements;
import com.cucumber.pages.LoginPaigeElements;

public class PageInitializer extends BaseClass {
	
	public static ContactDetailsElements contaceDetails;
	public static DashboardPageElements dashboardPage;
	public static EmargencyContactsElements emargencyContacts;
	public static LoginPaigeElements loginPage;
	
	
	
	public static void initialize() {
		 contaceDetails=new ContactDetailsElements();
		 dashboardPage =new DashboardPageElements();
		 emargencyContacts =new EmargencyContactsElements();
		 loginPage =new LoginPaigeElements();
	}

}
