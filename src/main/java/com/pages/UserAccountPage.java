package com.pages;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.base.BaseClass;
import com.utility.configreader;

public class UserAccountPage extends BaseClass{
	
	Properties prop;
	
	@FindBy(xpath ="(//div[@class='rv review-action ng-enter-element']//*[name()='svg'])[1]") WebElement star1;
	@FindBy(xpath ="(//div[@class='rv review-action ng-enter-element']//*[name()='svg'])[2]") WebElement star2;
	@FindBy(xpath ="(//div[@class='rv review-action ng-enter-element']//*[name()='svg'])[3]") WebElement star3;
	@FindBy(xpath ="(//div[@class='rv review-action ng-enter-element']//*[name()='svg'])[4]") WebElement star4;
	@FindBy(xpath="(//span[@class='dropdown-placeholder'])[2]") WebElement sel;
	@FindBy(xpath="//div[@class='android']//textarea") WebElement Writetext;
	@FindBy(xpath="//div[text()='Submit']") WebElement SubmitButton;
	@FindBy(xpath="//a[text()='Login']") WebElement Logintab;
	@FindBy(xpath="//input[@name='em']") WebElement emailtext;
	@FindBy(xpath="//input[@type='password']") WebElement password;
	@FindBy(xpath="//button[@type='button']") WebElement LoginButton;
	@FindBy(xpath="//span[text()=' Your Review']") WebElement Text;
	
	
	public UserAccountPage(){
		PageFactory.initElements(getdriver(), this);
		
	}
	
	 
	public void enter_url(String url) {
		getdriver().get(url);
		getdriver().manage().window().maximize();
	}

	public void dofewfun() {
		Actions act = new Actions(getdriver());
		JavascriptExecutor js = (JavascriptExecutor)getdriver();
		js.executeScript("scroll(0,550);");
		act.moveToElement(star1).moveToElement(star2).moveToElement(star3).moveToElement(star4).click().build().perform();
		
	}

	public void cliclpolicyandchangevalue(String text)  {
		 sel.click();
		 List<WebElement> list = getdriver().findElements(By.xpath("(//span[@class='dropdown-placeholder'])[2]//..//li"));
		 list.get(1).click();
		 }
		
	

	public void cliclonlinkandwriterandomtext() {
		Writetext.click();
		Writetext.sendKeys("Hello this is WalletHub Test.This Test is to create the framework.Hello this is WalletHub Test.This Test is to create the framework.Hello this is WalletHub Test.This Test is to create the framework.Hello this is WalletHub Test.This Test is to create the framework.Hello this is WalletHub Test.This Test is to create the framework.");
				    
	}

	public void clickonsubmit() {
		try {
			SubmitButton.click();
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
	}

	public void verifyconfirmationscreen() throws InterruptedException, IOException {
		configreader cf = new configreader();
	    prop = cf.configread();
		waitfor(Logintab);
		Logintab.click();
		emailtext.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("password"));
		LoginButton.click();
		
	}

	public void navigatetourlandassert() {
		waitfor(Text);
		Assert.assertEquals(Text.getText(),"Your Review");
	}

}
