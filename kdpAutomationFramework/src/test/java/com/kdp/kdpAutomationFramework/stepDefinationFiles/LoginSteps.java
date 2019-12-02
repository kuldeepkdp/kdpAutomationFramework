package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.Selenium;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	Selenium sel;
	WebDriver driver;

	
	public LoginSteps (Selenium sel) {
		this.sel= sel;
		this.driver= sel.getDriver();

	}
	
	@Then("^user is shown validation error message stating xyz$")
	public void i_got_validation_error_message_for_mandatory_fields() throws Throwable {
		System.out.println("abc");
	}
	
	@When("^user navigates to LoginPage$")
	public void the_user_navigates_to_LoginPage() throws Throwable {

	}
}
