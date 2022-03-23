package com.crm.dummymaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {
	
	WebDriver driver=null;
	String browser =System.getProperty("browser");
	String url =System.getProperty("url");
	String username =System.getProperty("username");
	String password =System.getProperty("password");
	
	@Test
	public void getData()
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launched browser is"+browser);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launched browser is" +browser);
		}
		
		else
		{
			System.out.println("specify valid browser");
			
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(url);
		 
		    driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			WebElement wb =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			Actions action = new Actions(driver);
			action.moveToElement(wb).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
		
	}

}
