package com.kemp.technologies.Chrome;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Scenario1 {
		WebDriver driver;
		
		@BeforeClass
		public void StartBrowser()
		{
			System.out.println("browser instantiation");
			
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			// add parameter which will disable the extension
			options.addArguments("--disable-extensions");

			// Start the chrome session
			driver = new ChromeDriver(options);

		}
		
		@BeforeMethod()
		public void OpenKempTechHomePage()
		{
			System.out.println("Open Kemp technologies page of application");
			
			String url="https://kemptechnologies.com/";
			driver.get(url);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			String title=driver.getTitle();
			Assert.assertTrue(title.contains("Load Balancer"));
			System.out.println(driver.getTitle());
			
		}
		@Test
		public void scenario1() {
			driver.get("https://life.kemptechnologies.com//");
			System.out.println(driver.getTitle());
			
			Set<String>ids=driver.getWindowHandles();
			Iterator<String>iterator=ids.iterator();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//a[@href='http://life.kemptechnologies.com/'][contains(text(),'OPEN POSITIONS')]")).click();
			driver.findElement(By.linkText("OPEN POSITIONS")).click();
			driver.getWindowHandle();
			
			System.out.println(driver.getTitle());
			
			
		}
		@AfterClass
		public void teardown()
		{
			System.out.println("Closing the Application");
			driver.close();
		}
		


	}


