package com.promise.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.promise.base.TestBase;


public class LoginPage extends TestBase{
				
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	
	@FindBy(xpath=".//input[@name='txtPassword']")
	WebElement password;
	
	@FindBy(xpath=".//input[@type='Submit']")
	WebElement signInBtn;	
	
	
	public LoginPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	public void emptyLoginTest(){
		username.clear();
		password.clear();
		log.info("Empty credentials and click submit Button...");
		signInBtn.click();
	}

	public DashboardPage login(String un, String pwd) {
		log.info("Entering Username And Password...");
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		//loginBtn.click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", signInBtn);
		return new DashboardPage();
	}		
}
