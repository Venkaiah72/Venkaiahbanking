package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {

	@Test
	public void Login() {
		logger.info("Url is Opened");
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			logger.info("Login test is failed");
		}

	}
}
