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

	@When("user sets the (.*) field as (.*)")
	public void setFieldValue(String element, String value) throws Throwable {
		CommonFunction.SendKeys(driver, element, value);
	}
	
	@When("user clicks on the (.*) button")
	public void clickOnButton(String element) throws Throwable {
		CommonFunction.clickOnButton(driver, element);
	}

}
