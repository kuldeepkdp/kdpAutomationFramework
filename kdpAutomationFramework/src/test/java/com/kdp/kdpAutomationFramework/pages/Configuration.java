package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UnitAction;
import com.kdp.kdpAutomationFramework.baseFunction.UserAction;

public class Configuration {
	
    public static String description = "//input[@name='SystemCaseTaskDefinitionModel.Description']";
	
	
	public static void navigateToPage(WebDriver driver) throws Exception{
		System.out.println("Navigate to configuration method is excuted----> " + Page.currentPage);
		UserAction.sendKeys(driver, "description", "This is automated test");

	}
	
	public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
	}

}
