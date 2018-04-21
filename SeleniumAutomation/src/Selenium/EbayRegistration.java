package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EbayRegistration {

	public static void main(String[] args) 
	
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumChromedriverexefile\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ebay.com");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String Title=driver.getTitle();
    	System.out.println(Title);
		Assert.assertEquals(Title, "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
		System.out.println("Title matched sucessfully");
	
    	driver.findElement(By.cssSelector("#gh-ug-flex>a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Sydulu");
		driver.findElement(By.name("lastname")).sendKeys("Kadama");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Unable to locate the email address field
		//driver.findElement(By.xpath(".//*[@id='suggestion']")).sendKeys("kadamasydulu2011");
		
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys("12345S");
		driver.findElement(By.linkText("User Agreement")).click();
		
		driver.findElement(By.cssSelector(".gspr.chk-on")).click();
		
		//Just checked the dropdown value selection  in facebook sign in page
		
		Select day=new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		
		day.selectByVisibleText("2");
		
		driver.switchTo().alert().accept();
		
		
		
		
		

	}

}
