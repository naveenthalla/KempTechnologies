package com.kemp.technologies.Firefox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Scenario10 {
	WebDriver driver;
	@Test
	public void scenario10() {
		/*Scenario: Ensure that the application form validation is working when a user 
		clicks on �Submit your application� button without inserting any data into the form*/
		
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
	
		driver.get("https://kemp-technologies.workable.com/");
		driver.findElement(By.xpath("//a[@href='/j/A0DD8E7C10']")).click();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>iterator=ids.iterator();
		
		driver.getWindowHandle();
		
		String parentId=iterator.next();
		//String childId=iterator.next();
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Apply for this job")).click();
		String actual=driver.getTitle();
		String expected="QA Engineer";
		if(actual.contains(expected)) {
		System.out.println("Correct page is displayed for QA Engineer position");
		}
		
		driver.findElement(By.xpath("//section[@class='section section--cta']//input[@type='submit']")).click();
		String actual1=driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
		String expected1="Mandatory information has not been filled in";
		Assert.assertEquals(actual1, expected1);
		System.out.println("Validation is working fine");
		
		
	}
	
	@AfterTest
	public void ExitWindow()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	
		
}

