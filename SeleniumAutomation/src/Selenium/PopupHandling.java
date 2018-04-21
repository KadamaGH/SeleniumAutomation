package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupHandling {

	public static void main(String[] args)
	
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumChromedriverexefile\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#signin_info>a")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("proceed")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		
		
		//Uploading the document by clicking on browse/upload buttons
		driver.get("http://maxdesign.com.au/jobs/sample-accessibility/05-forms/input-file.html");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.name("a")).sendKeys("C:\\Users\\user\\Desktop");
		


	}

}
