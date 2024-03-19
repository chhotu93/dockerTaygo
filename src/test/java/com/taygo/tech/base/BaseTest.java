package com.taygo.tech.base;

import java.util.Properties;

import com.taygo.tech.pages.AccountsPage;
import com.taygo.tech.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.taygo.tech.factory.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accPage;

	protected SoftAssert softAssert;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.initProp();

		if (browserName != null) {
			prop.setProperty("browser", browserName);

		}

		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	//test

}
