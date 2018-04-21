package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LoginFB 

{
	WebDriver driver;
	
	 @BeforeMethod
	  public void Setup() 
	   {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumChromedriverexefile\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com"); 
		EnterLoginDetailsTest("8008830532","sydulubabukadama");
		
	   }
	 
	 public void FacebookloginTest() throws IOException 
	   {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TakesScreenshot TS=(TakesScreenshot)driver;
		File Source= TS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("./Screenshots/FB.png"));
		System.out.println("Sucessfully screenshot captured");
		 
	   }
		 
	   
	 public void EnterLoginDetailsTest(String UserID, String Password)
	   {
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(UserID);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(Password);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@type='submit']")).click();
		 System.out.println("Successfully logined");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 
		  
	 }

	 @AfterMethod
	  public void finalSetup() 
	   {
	     driver.quit();
	 
	   }
	}

	


