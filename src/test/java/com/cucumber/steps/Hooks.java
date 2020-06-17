package com.cucumber.steps;

import com.cucumber.utels.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {
	
	@Before
	public void start() {
		setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		byte[] pic;
		
		if(scenario.isFailed()) {
			pic = CommonMethods.takeScreenshot("Failed/"+scenario.getName());
		}else {
			pic= CommonMethods.takeScreenshot("Passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "image/png", scenario.getName());
		
		tearDown();
	}

}
