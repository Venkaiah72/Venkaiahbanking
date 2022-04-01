package com.inetbanking.testCases;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.intebanking.utilities.ReadConfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String BaseURL = readconfig.getApplicationURL();

	public String username = readconfig.getuserName();

	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	// @Parameters("browser")
	@BeforeSuite
	public void setup() {
	String	browser = "chrome";
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getchromePath());
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.firefoxpath());
			driver = new FirefoxDriver();
		}
		driver.get(readconfig.getApplicationURL());
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
