package com.promise.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.promise.base.TestBase;
import com.promise.pages.DashboardPage;
import com.promise.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		log.info("Launching the Chrome...");
		loginPage = new LoginPage();
		log.info("Opening Browser...");

	}

	@Test(priority = 1)
	public void verifyemptyloginfun() {

		loginPage.emptyLoginTest();
		Assert.assertTrue(true);
		log.info("Step 1 executed...");

	}

	@Test(priority = 2)
	public void verifyLoginFunctionslityTest() {

		dashboardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		log.info("Step 2 executed...");
	}

	@AfterClass
	public void tearDown() {
		log.info("Closing Browser...");
		driver.quit();
	}
}
