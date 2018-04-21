package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) 
	{
    System.setProperty("webdriver.chrome.driver", "D:\\SeleniumChromedriverexefile\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("http://www.spicejet.com");
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	Actions action=new Actions(driver);
			
	action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Hot Meals")).click();

//TakesScreenshot	SH=(TakesScreenshot) driver;

	}

}
