package com.kemp.technologies.Chrome;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Scenario5 {
	
	WebDriver driver;
	@Test
	public void scenario5()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");

		// Start the chrome session
		WebDriver driver = new ChromeDriver(options);

		//Ensure that the total number of characters in the Description section is 593
		driver.get("https://kemp-technologies.workable.com/");
		driver.findElement(By.xpath("//a[@href='/j/A0DD8E7C10']")).click();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>iterator=ids.iterator();
		
		driver.getWindowHandle();
		
		String parentId=iterator.next();

		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
					
		WebElement Para = driver.findElement(By.xpath("//p[contains(text(),'The QA Engineer will contribute to KEMP’s QA funct')]"));
        String ParaCount = Para.getText();
        int WordCount = ParaCount.length();
        System.out.println("Paragraph Characters Count : "+WordCount);
        

	}
	@AfterClass
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	

}
