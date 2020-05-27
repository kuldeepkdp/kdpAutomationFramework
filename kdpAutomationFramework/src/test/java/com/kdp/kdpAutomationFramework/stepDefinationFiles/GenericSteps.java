package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UiControl;
import com.kdp.kdpAutomationFramework.baseFunction.CommonFunction;
import com.kdp.kdpAutomationFramework.baseFunction.Selenium;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GenericSteps {

	Selenium sel;
	WebDriver driver;

	public GenericSteps(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
	}

	@When("user navigates to the '(.*)' (page|tab)")
	public void user_navigates_to_the_ABC_page_tab(String pageName, String ignore) throws Throwable {
		CommonFunction.navigateToPage(driver, pageName);
	}

	@Then("user is now on the '(.*)' (page|tab)")
	public void nowOnThePage(String pageName, String ignore) throws Throwable {
		CommonFunction.assertOnPage(driver, pageName);
	}

	@When("user sets the '(.*)' field as '(.*)'")
	public void setFieldValue(String element, String value) throws Throwable {
		CommonFunction.sendKeys(driver, element, value);
	}

	@When("user clicks on the '(.*)' element")
	public void click(String element) throws Throwable {
		CommonFunction.click(driver, element);
	}

	@When("user clicks on the '(.*)' button")
	public void clickOnButton(String buttonName) throws Throwable {
		CommonFunction.clickOnButton(driver, buttonName);
	}

	@When("user waits until the '(.*)' element is clickable")
	public void waitsUntilElementIsClickable(String element) throws Throwable {
		CommonFunction.waitForElementToBeClickable(driver, element);
	}

	@When("user select '(.*)' from dropbox '(.*)'")
	public void selectFromStandardDropbox(String value, String element) throws Throwable {
		UiControl.dropbox(driver, element, value);
	}
/*
	@When("^fills out the current form as follows$")
	public void fillOutCurrentForm(DataTable dt) throws Throwable {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("Type").equals("dropbox")) {
				AppSpecificUiControl.selectFromStandardDropbox(driver, list.get(i).get("Element"),
						list.get(i).get("Value"));
				if (list.get(i).get("Alias") != null) {
					System.out.println("Set the alias");
				}
			} else if (list.get(i).get("Type").equals("textbox")) {
				
				String inputValue = list.get(i).get("Value");
				
				if(list.get(i).get("Value").startsWith("$")) {
					
					inputValue=CommonFunction.GetData(list.get(i).get("Value"));
				}
				if(list.get(i).get("Value").startsWith("&")) {
					
					inputValue=CommonFunction.GetRunTimeData(list.get(i).get("Value"));
				}
				
				if (!list.get(i).get("Alias").equals("")) {
					System.out.println("Set the alias");
					CommonFunction.SetRunTimeData(list.get(i).get("Alias"), inputValue);
				}
				
				CommonFunction.sendKeys(driver, list.get(i).get("Element"), inputValue);
			}

			else if (list.get(i).get("Type").equals("date")) {
				CommonFunction.sendKeys(driver, list.get(i).get("Element"), list.get(i).get("Value"));
			} else {
				CommonFunction.click(driver, list.get(i).get("Element"));
			}
		}

	}*/
	
	@Then("user is shown '(.*)' element with '(.*)' text")
	public void checkElementText(String element, String value) throws Throwable {
		CommonFunction.checkElementText(driver, element, value);
		
	}
	
	@When("^user waits for (\\d+) miliseconds$")
	public void userWaitsForSeconds(int time) throws Throwable {
		
		Thread.sleep(time);

	}
	
	@When("^fills out the current form as follows$")
	public void fillOutCurrentForm(DataTable dt) throws Throwable {

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		
		for (Map<String, String> map : list) 
		{ 
		   CommonFunction.setValue(driver, map.get("Element"), map.get("Type"), map.get("Value"), map.get("Alias"));
		}			
	}
	
	
}
