package com.cucumber.runners;


import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com/hrms_API/practice",
		dryRun = false,
	
		monochrome = true,
		strict = true,
		tags="@workflow",
		plugin = {"pretty",
				"html:target/cucumber-default-report",// create basic html report in specified locotion
				"json:target/cucumber.json",
		}
	//	System.out.println();
		
	)








public class PAIWorkflowRunner {
	
	


}
