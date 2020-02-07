package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.CommonFunction;
import com.kdp.kdpAutomationFramework.baseFunction.Selenium;
import com.kdp.kdpAutomationFramework.pages.GenericCaseTaskDefination;

import cucumber.api.java.en.When;

public class CreateCaseSteps {
	
	Selenium sel;
	WebDriver driver;

	public CreateCaseSteps(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
	}
	
	@When("user create generic case")
	public void createGenericCase() throws Throwable {
		GenericCaseTaskDefination.createGenericCase(driver);
	}

}
