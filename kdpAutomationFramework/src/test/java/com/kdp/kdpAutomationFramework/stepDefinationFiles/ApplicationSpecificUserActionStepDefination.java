package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.ApplicationSpecificUserAction;
import com.kdp.kdpAutomationFramework.baseFunction.Selenium;
import com.kdp.kdpAutomationFramework.baseFunction.UserAction;

import cucumber.api.java.en.When;

public class ApplicationSpecificUserActionStepDefination {
    
    Selenium sel;
    WebDriver driver;

    public ApplicationSpecificUserActionStepDefination(Selenium sel) {
        this.sel = sel;
        this.driver = sel.getDriver();
    }
    
    @When("user login as '(.*)' user")
    public void logInAs(String userType) throws Throwable {
        ApplicationSpecificUserAction.logInAsUser(driver, userType);
    }

}
