package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Selenium {
	
	public WebDriver driver;

	@Before
	public void beforeScenario() throws IOException, InterruptedException, ConfigurationException {
		
		System.out.println("Before method is called");

		String browser = CommonFunction.GetConfigData("browser");
		String IE;
		String Firefox;
		String Chrome;
		System.out.println("browser check");

		if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//Drivers//IEDriver//IEDriverServer");
			driver = new InternetExplorerDriver();

		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();

		}

		else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		}
		   driver.manage().window().maximize();
	       driver.navigate().to(CommonFunction.GetConfigData("url"));

	}

	public WebDriver getDriver() {

		return driver;
	}

	@After
	public void afterScenario() {
		
		/*driver.quit();
		System.out.println("Exectuing After Statement");*/
		
	}
}
