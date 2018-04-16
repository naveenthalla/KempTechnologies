package com.kemp.technologies.Firefox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Scenario9 {
	WebDriver driver;
	@Test
	public void scenario9()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
	
		//Verify that clicking on the link “Add education” in QA Engineer application 
		//form will open a new menu for Education details
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
		driver.findElement(By.xpath("//a[@class='add_nested_fields'][contains(text(),'Add education')]")).click();
		System.out.println("Add education field is present");
		//driver.findElement(By.linkText("Add education")).click();
		
	}
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	

}
