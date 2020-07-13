package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;

public class ApplicationSpecificUserAction {
    
    
    public static void logInAsUser(WebDriver driver, String UserType) throws Exception {
        String userName = null;
        String password = null;
        UnitAction.setCurrentPage("CxLogin");
        
        if(UserType.equalsIgnoreCase("Admin")) {
            userName = UnitAction.GetData("$adminUserName");
            password = UnitAction.GetData("$adminPassword");          
        }
        
        if(UserType.equalsIgnoreCase("Customer")) {
            userName = UnitAction.GetData("$CustomerUserName");
            password = UnitAction.GetData("$CustomerPassword");          
        }
        
        if(UserType.equalsIgnoreCase("Super")) {
            userName = UnitAction.GetData("$superUserName");
            password = UnitAction.GetData("$superUserPassword"); 
        }
        
        UserAction.waitFor(2);
        UserAction.sendKeys(driver, "userName", userName);
        UserAction.sendKeys(driver, "password", password);
        UserAction.click(driver, "logIn");
    }

}
