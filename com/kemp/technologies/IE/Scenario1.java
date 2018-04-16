package com.kemp.technologies.IE;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	public class Scenario1 {
		
		//Global declaration of WebDriver variable
		WebDriver driver;
		
		@Parameters({"driverPath"})
		
		@BeforeClass
		public void StartBrowser(String driverPath)
		{
			System.out.println("browser instantiation");
			
			//set IE driver path
			
			System.setProperty("webdriver.ie.driver", driverPath);
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			
				}
		@Parameters({"URL"})
		@Test(priority=1)
		public void OpenKempTechHomePage(String url)
		{
			System.out.println("Open Kemp technologies Home page of the application");
			driver.get(url);
						
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();
			String title=driver.getTitle();
			Assert.assertTrue(title.contains("Load Balancer"));
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a[@href='http://life.kemptechnologies.com/'][contains(text(),'JOBS AT KEMP')]")).click();
			//driver.findElement(By.linkText("JOBS AT KEMP")).click();
			
			
		}
		
		@Test(priority=1)
		
		public void scenario1() {
			driver.get("https://life.kemptechnologies.com//");
			System.out.println(driver.getTitle());
			
			Set<String>ids=driver.getWindowHandles();
			Iterator<String>iterator=ids.iterator();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//a[@href='http://life.kemptechnologies.com/'][contains(text(),'OPEN POSITIONS')]")).click();
			driver.findElement(By.linkText("OPEN POSITIONS")).click();
			System.out.println(driver.getTitle());
			System.out.println("User navigated to Open Positions page");
			
		}
		
	
		@Test(priority=2)
		public void Scenario2() {
			
			/*Ensure that listed position of QA engineer on the Current openings page contains 
			 * additional data “County Limerick, Ireland – Software Development
			 * 
			 */
			driver.get("https://kemp-technologies.workable.com/");
			String actual=driver.findElement(By.xpath("//li[@id='job_692332']//p[@class='meta']")).getText();
			String expected="County Limerick, Ireland · Software Development";
			Assert.assertEquals(actual, expected);
			System.out.println("QA Engineer position at" +expected +"text is Present");
			
		}
		@Test(priority=3)
		public void Scenario3() {
			driver.get("https://kemp-technologies.workable.com/");
			String source=driver.getPageSource();
			if(source.contains("Door security")) {
			    System.out.println("Door security position is present");
			} else {
			    System.out.println("Door security position not found");
			}
		}
		
		@Test(priority=4)
		public void Scenario4()
		{
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

		@Test(priority=5)
		public void Scenario5()
		{
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
	        System.out.println("Paragraph Characters Count including white space are  : "+WordCount);
	        

		}

		@Test(priority=6)
		public void Scenario6()
		{
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
		@Test(priority=7)
		public void Scenario7()
		{
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
		
		@Test(priority=8)
		public void Scenario8()
		{
			//Verify that the button “Apply for this job” will redirect a user to the application form window
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
		
		}
		@Test(priority=9)
		public void Scenario9()
		{
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
			//driver.findElement(By.linkText("Add education")).click();
			driver.findElement(By.xpath("//a[@class='add_nested_fields'][contains(text(),'Add education')]")).click();
			System.out.println("Add education field is present");
			
			
		}
		
		@Test(priority=10)
		public void Scenario10() {
			/*Scenario: Ensure that the application form validation is working when a user 
			clicks on “Submit your application” button without inserting any data into the form*/
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
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//section[@class='section section--cta']//input[@type='submit']")).click();
			String actual1=driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
			String expected1="Mandatory information has not been filled in";
			Assert.assertEquals(actual1, expected1);
			System.out.println("Validation 'Submit your application” button without inserting any data into the form' is working fine");
			
			
		}
		
		@AfterClass
		public void teardown()
		{
			System.out.println("Closing the Application");
			driver.close();
		}
		
			
	}

