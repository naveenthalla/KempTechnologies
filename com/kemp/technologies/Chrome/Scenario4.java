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

public class Scenario4 {
		
	WebDriver driver;
	
	@Test
		
		public void scenario4()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");

		// Start the chrome session
		WebDriver driver = new ChromeDriver(options);

		//Ensure that the section ‘Description’ in QA engineer position contains 83 words
		driver.get("https://kemp-technologies.workable.com/j/A0DD8E7C10");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		
		driver.get("https://kemp-technologies.workable.com/");
		driver.findElement(By.xpath("//a[@href='/j/A0DD8E7C10']")).click();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>iterator=ids.iterator();
		
		driver.getWindowHandle();
		
		String parentId=iterator.next();
		//String childId=iterator.next();
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		
		
		WebElement Para = driver.findElement(By.xpath("//p[contains(text(),'The QA Engineer will contribute to KEMP’s QA funct')]"));
        String ParaCount = Para.getText();

        System.out.println("Paragraph Content : "+ParaCount);

        String a[] = ParaCount.split(" ");
        int size = a.length;
        System.out.println("Paragraph Words Count : "+size);
       


       		}
	@AfterClass
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	

}
