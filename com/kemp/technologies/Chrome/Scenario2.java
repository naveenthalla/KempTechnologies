package com.kemp.technologies.Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Scenario2 {
	
	WebDriver driver;
	@Test
	public void scenario2() {
		
		/*Ensure that listed position of QA engineer on the Current openings page contains 
		 * additional data “County Limerick, Ireland – Software Development
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");

		// Start the chrome session
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://kemp-technologies.workable.com/");
		String actual=driver.findElement(By.xpath("//li[@id='job_692332']//p[@class='meta']")).getText();
		String expected="County Limerick, Ireland · Software Development";
		Assert.assertEquals(actual, expected);
		System.out.println("QA Engineer position at" +expected +"text is Present");
		
	}
	@AfterClass
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	
}
