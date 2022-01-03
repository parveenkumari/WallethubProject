package com.pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.base.BaseClass;

public class FBLoginPage extends BaseClass {
	

	@FindBy(id = "email") WebElement UsernameField;
	@FindBy(id = "pass") WebElement passwordField;
	@FindBy(name = "login") WebElement loginbutton;
	@FindBy(xpath="//div[@class='m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b']//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']") WebElement postclick;
	@FindBy(xpath= "//div[@class='_1mf _1mj']") WebElement entertext;
	@FindBy(xpath="(//div[@class='bp9cbjyn j83agx80 taijpn5t c4xchbtz by2jbhx6 a0jftqn4'])[2]") WebElement PostButton;
	@FindBy(xpath="//div[@class='s45kfl79 emlxlaya bkmhp75w spb7xbtv oaz4zybt pmk7jnqg j9ispegn kr520xx4']") WebElement FBHome;
	
	
	 public FBLoginPage() {
		 
	      PageFactory.initElements(getdriver(), this);
	 }
  

	public void navigatetofacebook(String url) {
		
		getdriver().get(url);
		getdriver().manage().window().maximize();
		getdriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	public void enterdata(String username, String password) throws Exception  {

		try {
			UsernameField.sendKeys(username);
			passwordField.sendKeys(password);
		} catch (Exception e) {
			throw new Exception("Value passing failed for username or password");
		}

	}

	public void clickonbutton() throws Exception {
		
		try {
			loginbutton.click();
			waitfor(FBHome);
		} catch (Exception e) {
			throw new Exception("Unable to click login button");
		}
	}

	public void verifytitle() {
	
		 Assert.assertEquals(getdriver().getTitle(),"Facebook");
		
	}

	public void postmsg(String msg) throws Exception {
		
		try {
			postclick.click(); 
			waitfor(entertext);
			entertext.sendKeys(msg);
		} catch (Exception e) {

			throw new Exception("Failure while posting message");
		}
		//PostButton.click();
		
	}

 
}
