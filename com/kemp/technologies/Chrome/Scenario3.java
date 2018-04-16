package com.kemp.technologies.Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Scenario3 {

	WebDriver driver;
	@Test
	public void scenario3() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");

		// Start the chrome session
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://kemp-technologies.workable.com/");
		String source=driver.getPageSource();
		if(source.contains("Door security")) {
		    System.out.println("Door security position is present");
		} else {
		    System.out.println("Door security position not found");
		}
	}
	@AfterClass
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	
}
