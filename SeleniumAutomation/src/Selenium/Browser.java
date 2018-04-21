package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
  
		System.setProperty("webdriver.gecko.driver", "D:\\downloads\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		
	TakesScreenshot TS=(TakesScreenshot)driver;
    File source=TS.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source,new File("./Screenshots/Google.png"));
		
		driver.close();
		
	}

}
