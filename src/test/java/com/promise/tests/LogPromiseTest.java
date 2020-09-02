package com.promise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.promise.base.TestBase;
import com.promise.pages.DashboardPage;
import com.promise.pages.LogPromisePage;
import com.promise.pages.LoginPage;
import com.promise.util.TestUtil;

public class LogPromiseTest extends TestBase {

	LoginPage loginPage;
	TestUtil testUtil;
	DashboardPage dashboardPage;
	LogPromisePage logPromisePage;

	public LogPromiseTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		logPromisePage=dashboardPage.clickOnLogPromiseLink();
	}

	@Test(priority = 1)
	public void addPromiseTest() {
		logPromisePage.PromiseDropDown();
		logPromisePage.enterAddPromiseDetails();
		log.info("Step 3 executed...");

	}

	@Test(priority = 2)
	public void addPromiseTest1() {
		logPromisePage.selectPromiser();
		logPromisePage.clickOnSearchButton();
		String name = logPromisePage.verifyNameInTable();
		Assert.assertEquals(name, "Sonali test", "Sonali Test is present in the table");
		log.info("Step 4 executed...");
	}

	@Test(priority = 3)
	public void logout() {
		logPromisePage.logout();
		log.info("Step 5 executed...");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
