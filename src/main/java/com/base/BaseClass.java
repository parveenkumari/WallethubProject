package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

 

public class BaseClass {
	
 static ThreadLocal<WebDriver> tdriver;

	 
 public WebDriver init(String browser) {
		
		tdriver = new ThreadLocal<WebDriver>();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver(option));

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver(option));

		}
		
		return getdriver();
		
	}
	
	public static WebDriver getdriver () {
		return tdriver.get();
	}
	
	 
	public void waitfor(WebElement e) {
		WebDriverWait wait = new WebDriverWait(getdriver(),150);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	 
	

}
