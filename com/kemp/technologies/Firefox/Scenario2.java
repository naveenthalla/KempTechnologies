package com.kemp.technologies.Firefox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		System.out.println("browser instantiation");
		
		//set Firefox driver path
		
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
	
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
