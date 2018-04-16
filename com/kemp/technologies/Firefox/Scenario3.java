package com.kemp.technologies.Firefox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Scenario3 {

	WebDriver driver;
	
	@Test
	public void scenario3() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	
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
