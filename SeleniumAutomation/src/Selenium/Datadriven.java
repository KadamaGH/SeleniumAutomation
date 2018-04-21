package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import junit.framework.Assert;



public class Datadriven 
{

	
WebDriver driver;

  @Test(dataProvider="Testdata")
  public void datadriven(String username, String password) throws InterruptedException
    {
	
	 System.setProperty("webdriver.chrome.driver", "D:\\SeleniumChromedriverexefile\\chromedriver_win32\\chromedriver.exe");
 
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.get("https://www.facebook.com");
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(".//*[@type='submit']")).click();
	 
	 Assert.assertTrue(driver.getTitle().contains("Facebook"),"Test case failed");
	 
	 
    }
  
  @AfterMethod
  public void teardown() {
	  
	  driver.quit();
  }

  @DataProvider(name="Testdata")
  public Object[][] Testdata() 
{
	Object[][] data=new Object[2][2];
	
	data[0][0]="sydulu";
	data[0][1]="Babu";
	
	data[1][0]="8008830532";
	data[1][1]="sydulubabukadama";
	
	return data;
	  
	
}
}