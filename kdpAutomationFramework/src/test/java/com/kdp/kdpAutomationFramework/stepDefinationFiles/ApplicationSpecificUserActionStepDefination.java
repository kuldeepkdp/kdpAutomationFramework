package com.kdp.kdpAutomationFramework.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.Selenium;

public class ApplicationSpecificUserActionStepDefination {
    
    Selenium sel;
    WebDriver driver;

    public ApplicationSpecificUserActionStepDefination(Selenium sel) {
        this.sel = sel;
        this.driver = sel.getDriver();
    }

}
