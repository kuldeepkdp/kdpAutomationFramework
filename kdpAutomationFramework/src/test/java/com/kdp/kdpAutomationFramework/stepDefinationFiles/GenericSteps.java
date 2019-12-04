package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.CommonFunction;
import com.kdp.kdpAutomationFramework.baseFunction.Selenium;


import cucumber.api.java.en.When;

public class GenericSteps {
	
	Selenium sel;
	WebDriver driver;

	
	public GenericSteps (Selenium sel) {
		this.sel= sel;
		this.driver= sel.getDriver();
	}
		
	@When("user navigates to the (.*) (page|tab)")
	public void user_navigates_to_the_ABC_page_tab(String pageName, String ignore) throws Throwable {
        CommonFunction.navigateToPage(driver,pageName);
	}
	
	@When("user is now on the (.*) (page|tab)")
	public void nowOnThePage(String pageName, String ignore) throws Throwable {
        CommonFunction.assertOnPage(driver,pageName);
	}

	@When("user sets the (.*) field as (.*)")
	public void setFieldValue(String element, String value) throws Throwable {
		CommonFunction.sendKeys(driver, element, value);
	}
	
	@When("user clicks on the (.*) element")
	public void click(String element) throws Throwable {
		CommonFunction.click(driver, element);
	}
	
	@When("user clicks on the (.*) button")
	public void clickOnButton(String buttonName) throws Throwable {
		CommonFunction.clickOnButton(driver, buttonName);
	}
	
	@When("user waits until the (.*) element is clickable")
	public void waitsUntilElementIsClickable(String element) throws Throwable {
		CommonFunction.waitForElementToBeClickable(driver, element);
	}
}
