package com.kemp.technologies.Firefox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Scenario6 {
	
	WebDriver driver;
	@Test
	public void scenario6()
	{
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
		
		//Ensure that the number of characters excluding white space in the ‘Description’ section equals 511
		WebElement Para = driver.findElement(By.xpath("//p[contains(text(),'The QA Engineer will contribute to KEMP’s QA funct')]"));
        String ParaCount = Para.getText();

        System.out.println("Paragraph Content : "+ParaCount);

       // String a = ParaCount.trim();
        String ab=ParaCount.replace(" ","");
        int size=ab.length();
        System.out.println("Number of Characters with out white spaces are: "+size);
	}
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	
}
