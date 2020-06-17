package com.cucumber.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.utels.ConfigsReader;
import com.cucumber.utels.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	
	public static WebDriver driver;
	
	public static WebDriver setUp() {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		ConfigsReader.readProparties(Constants.CONFIGURATION_FILEPATH);
		switch (ConfigsReader.getProparty("browser").toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}
		
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProparty("url"));
		
		
		PageInitializer.initialize();
		return driver;

	}
	
	public static void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}
	
	

}
