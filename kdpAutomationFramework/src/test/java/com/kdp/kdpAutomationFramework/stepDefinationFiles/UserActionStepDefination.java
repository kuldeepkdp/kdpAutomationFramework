package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UiControl;
import com.kdp.kdpAutomationFramework.baseFunction.UnitAction;
import com.kdp.kdpAutomationFramework.baseFunction.UserAction;
import com.kdp.kdpAutomationFramework.baseFunction.Selenium;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserActionStepDefination {

	Selenium sel;
	WebDriver driver;

	public UserActionStepDefination(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
	}

	@When("user navigates to the '(.*)' (page|tab)")
	public void user_navigates_to_the_ABC_page_tab(String pageName, String ignore) throws Throwable {
	    UserAction.navigateToPage(driver, pageName);
	}

	@Then("user is now on the '(.*)' (page|tab)")
	public void nowOnThePage(String pageName, String ignore) throws Throwable {
	    UserAction.assertOnPage(driver, pageName);
	}

	@When("user sets the '(.*)' field as '(.*)'")
	public void setFieldValue(String element, String value) throws Throwable {
		UnitAction.sendKeys(driver, element, value);
	}

	@When("user clicks on the '(.*)' element")
	public void click(String element) throws Throwable {
	    UserAction.click(driver, element);
	}

	@When("user clicks on the '(.*)' button")
	public void clickOnButton(String buttonName) throws Throwable {
		UserAction.clickOnButton(driver, buttonName);
	}

	@When("user waits until the '(.*)' element is clickable")
	public void waitsUntilElementIsClickable(String element) throws Throwable {
		
	}

	@When("user select '(.*)' from dropbox '(.*)'")
	public void selectFromStandardDropbox(String value, String element) throws Throwable {
		UiControl.dropbox(driver, element, value);
	}

	@Then("user is shown '(.*)' element with '(.*)' text")
	public void checkElementText(String element, String value) throws Throwable {
		UserAction.checkElementText(driver, element, value);
		
	}
	
	@When("^user waits for (\\d+) miliseconds$")
	public void userWaitsForSeconds(int time) throws Throwable {
		
		UserAction.waitFor(time);

	}
	
	@When("^user waits until page is loaded$")
    public void applicationSpecificWaitsUntilPageIsLoaded() throws Throwable {
        
        UserAction.waitUntilPageIsLoaded(driver);

    }
	
	@When("^fills out the current form as follows$")
	public void fillOutCurrentForm(DataTable dt) throws Throwable {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		for (Map<String, String> map : list) 
		{ 
		   UserAction.setValue(driver, map.get("Element"), map.get("Type"), map.get("Value"), map.get("Alias"));
		}			
	}	
}