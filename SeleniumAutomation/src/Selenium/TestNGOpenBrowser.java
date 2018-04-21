package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGOpenBrowser {
	
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
	
   }
 
 @Test(priority=1)
  public void pageTiteVerifyTest() 
   {
     String title=driver.getTitle();
     System.out.println("The title of page is "+ title);
     Assert.assertEquals(title,"Facebook – log in or sign up");
     System.out.println("Title matched succesfully");
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }
 @Test(priority=2)
 public void pageElementsVerifyTest()
   {
	 driver.findElement(By.xpath(".//*[@id='email']")).isDisplayed();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='pass']")).isDisplayed();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 System.out.println("User ID and Password elements are present");
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 
   }
 @Test(priority=3)
 public void EnterLoginDetailsTest()
   {
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("8008830532");
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("sydulubabukadama");
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@type='submit']")).click();
	 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 System.out.println("Successfully logined"); 
	  
 }

 @AfterMethod
  public void finalSetup() 
   {
     driver.quit();
 
   }
}
