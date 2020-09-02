package com.promise.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.promise.base.TestBase;
import com.promise.pages.DashboardPage;
import com.promise.pages.LoginPage;
import com.promise.util.TestUtil;


public class DashboardPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testUtil;
	DashboardPage dashboardPage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void clickOnLogPromiseLink() {
		dashboardPage.clickOnLogPromiseLink();
		log.info("click on promise link...");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}
	
}
