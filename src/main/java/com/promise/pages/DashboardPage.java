package com.promise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.promise.base.TestBase;

public class DashboardPage extends TestBase{
	
	LogPromisePage logPromisePage;
	
	@FindBy(xpath = "//a[@href='promise/log_promise.php']")
	private WebElement logPromiseLink;

	public LogPromisePage clickOnLogPromiseLink() {
		logPromiseLink.click();
		return new LogPromisePage();
	}
	
	public String verifyDashboardPageTitle(){
		log.info("Verifying the dashboard Page Title...");
		return driver.getTitle();
	}

}
