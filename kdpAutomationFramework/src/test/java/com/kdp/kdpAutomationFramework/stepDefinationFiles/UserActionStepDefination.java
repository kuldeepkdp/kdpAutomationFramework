package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


	@Then("user is shown '(.*)' element with '(.*)' text")
	public void checkElementText(String element, String value) throws Throwable {
		UserAction.elementTextIsEqual(driver, element, value);
		
	}
	
	@Then("user is shown '(.*)' element containing '(.*)' text")
    public void checkElementContainingText(String element, String value) throws Throwable {
        UserAction.elementContainingText(driver, element, value);
        
    }
	
	@When("^user waits for '(.*)' seconds$")
	public void userWaitsForSeconds(int seconds) throws Throwable {
		
		UserAction.waitFor(seconds);

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
	
	@Then("^user is shown a '(.*)' list which is equal to following list$")
    public void ListEqualsToList(String element, DataTable dt ) throws Throwable {
	    List<String> rawRow = dt.asList(String.class);
	    List<WebElement> elements= UnitAction.getElements(driver, element);
	    List<String> actualRow = new ArrayList<String>();
	    List<String> expectedRow = new ArrayList<String>();
	    
	    for(String value : rawRow) {
	        expectedRow.add(UnitAction.getProcessedValue(value));
        }
	    
	    for(WebElement a : elements) {
	        actualRow.add(a.getText());
	    }
	    
	   assertTrue("Two lists are not equal", actualRow.equals(expectedRow));
    }
	
	@Then("^user is shown a '(.*)' list which contains following list$")
    public void listContainingSublist(String element, DataTable dt ) throws Throwable {
        List<String> rawRow = dt.asList(String.class);
        List<WebElement> elements= UnitAction.getElements(driver, element);
        List<String> actualRow = new ArrayList<String>();
        List<String> expectedRow = new ArrayList<String>();
        
        for(String value : rawRow) {
            expectedRow.add(UnitAction.getProcessedValue(value));
        }
        
        for(WebElement a : elements) {
            actualRow.add(a.getText());
        }
        
       assertTrue("List " + element + " does not contain expected column value", actualRow.containsAll(expectedRow));
          
    }
	
	@Then("^user is shown a '(.*)' list which contains following list in sequence$")
    public void listContainingSublistInSequence(String element, DataTable dt ) throws Throwable {
        List<String> rawRow = dt.asList(String.class);
        List<WebElement> elements= UnitAction.getElements(driver, element);
        List<String> actualRow = new ArrayList<String>();
        List<String> expectedRow = new ArrayList<String>();
        
        for(String value : rawRow) {
            expectedRow.add(UnitAction.getProcessedValue(value));
        }
        
        for(WebElement a : elements) {
            actualRow.add(a.getText());
        }
                
       int index=Collections.indexOfSubList(actualRow , expectedRow);
       assertFalse("List " + element + " does not contain expected column value in sequence", index== -1);
       
    }
	
	@Then("^user is shown '(.*)' element containing following text$")
    public void elementContainingFollowingText(String element, DataTable dt ) throws Throwable {
        List<String> rawRow = dt.asList(String.class);
        WebElement webElement= UnitAction.getElement(driver, element);
        String actualText = webElement.getText().replaceAll("\\s", "");
        
        List<String> expectedRow = new ArrayList<String>();
        for(String value : rawRow) {
            expectedRow.add(UnitAction.getProcessedValue(value));
        }
        
        String expectedValue= StringUtils.join(expectedRow, "").replaceAll("\\s", "");
         
        assertTrue("Element does not contain text " + expectedValue, actualText.contains(expectedValue));
    }
	
	@Then("^user is shown '(.*)' table containing following columns$")
    public void elementContainingFollowingColumns(String element, DataTable dt ) throws Throwable {
        List<String> rawRow = dt.asList(String.class);
        WebElement webElement= UnitAction.getElement(driver, element);
        String actualText = webElement.getText().replaceAll("\\s", "");
        
        List<String> expectedRow = new ArrayList<String>();
        for(String value : rawRow) {
            expectedRow.add(UnitAction.getProcessedValue(value));
        }
        
        String expectedValue= StringUtils.join(expectedRow, "").replaceAll("\\s", "");
         
        assertTrue("Element does not contain text " + expectedValue, actualText.contains(expectedValue));
    }
	
	@Then("^user is shown '(.*)' table containing following row$")
    public void elementContainingFollowingRow(String element, DataTable dt ) throws Throwable {
        List<String> rawRow = dt.asList(String.class);
        WebElement webElement= UnitAction.getElement(driver, element);
        String actualText = webElement.getText().replaceAll("\\s", "");
        
        List<String> expectedRow = new ArrayList<String>();
        for(String value : rawRow) {
            expectedRow.add(UnitAction.getProcessedValue(value));
        }
        
        String expectedValue= StringUtils.join(expectedRow, "").replaceAll("\\s", "");
         
        assertTrue("Element does not contain text " + expectedValue, actualText.contains(expectedValue));
    }
	
	@Then("^user is shown a '(.*)' element$")
    public void elementIsDisplayed(String element) throws Throwable {

        assertTrue("element is not displayed", UserAction.isElementDisplayed(driver, element));
    }
	
	@Then("^user is not shown a '(.*)' element$")
    public void elementIsNotDisplayed(String element) throws Throwable {

        assertFalse("element is displayed", UserAction.isElementDisplayed(driver, element));
    }
	
	@Then("^user is shown a '(.*)' element which is enabled$")
    public void elementIsEnabled(String element) throws Throwable {
	    WebElement webElement = UnitAction.getElement(driver, element);
	    assertTrue("element is not enabled", webElement.isEnabled());
    } 
	
	@Then("^user is shown a '(.*)' element which is disabled$")
    public void elementIsDisabled(String element) throws Throwable {
        WebElement webElement = UnitAction.getElement(driver, element);
        assertFalse("element is not disabled", webElement.isEnabled());
    }
}
