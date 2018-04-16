package com.kemp.technologies.Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Scenario7 {
	
	WebDriver driver;
	@Test
	public void scenario7()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");

		// Start the chrome session
		WebDriver driver = new ChromeDriver(options);

		//Ensure that the word “Miso” is not included in the section Benefits
		driver.get("https://kemp-technologies.workable.com/j/A0DD8E7C10");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		
		WebElement Para = driver.findElement(By.xpath("//p[contains(text(),'We value our employee’s commitment to KEMPs succes')]"));
        String ParaCon = Para.getText();
        System.out.println(ParaCon);
        //verify the word "Miso"
        	if(ParaCon.contains("Miso"))
        	{
        		System.out.println("The word Miso present in the system");
        	}
        	else {
        		System.out.println("The Word \"Miso\" is Not present");
        	}
	}
	@AfterClass
	public void teardown()
	{
		System.out.println("Closing the Application");
		driver.close();
	}
	

}
