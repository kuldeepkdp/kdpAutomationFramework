package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kdp.kdpAutomationFramework.navigation.AssertOn;
import com.kdp.kdpAutomationFramework.navigation.Navigate;

import junit.framework.Assert;

public class UserAction {

    // User navigate to Page .It will set current page
    public static void navigateToPage(WebDriver driver, String pagename)
            throws ConfigurationException, IOException, ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (UnitAction.GetConfigData("elementRepoConifiguration").equalsIgnoreCase("file")) {
            UnitAction.setCurrentPage(pagename);
            Navigate.navigateToPage(pagename);
        }

        else {
            UnitAction.setCurrentPage(pagename);
            String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;
            Class cls = Class.forName(fullPathOfTheClass);
            Method method = cls.getDeclaredMethod("navigateToPage", WebDriver.class);
            method.invoke(null, driver);
        }
    }

    // User is directed to page.It will set current page
    public static void assertOnPage(WebDriver driver, String pagename)
            throws ConfigurationException, IOException, ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if (UnitAction.GetConfigData("elementRepoConifiguration").equalsIgnoreCase("file")) {
            UnitAction.setCurrentPage(pagename);
            AssertOn.assertOnPage(pagename);
        }

        else {
            UnitAction.setCurrentPage(pagename);
            String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;
            Class cls = Class.forName(fullPathOfTheClass);
            Method method = cls.getDeclaredMethod("assertOnPage", WebDriver.class);
            method.invoke(null, driver);
        }
    }
    
    //Static wait in milliseconds
    public static void waitFor(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    //Custom click method
    public static void click(WebDriver driver, String element) throws ConfigurationException, SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
           
           WebElement webElement = UnitAction.getElement(driver, element);
           webElement.click();          
    }

    
    // Set the value on mentioned UI controls
    public static void setValue(WebDriver driver, String element, String type, String value, String alias)
            throws Exception {
        String processedValue = UnitAction.getValue(value);

        if (type.equalsIgnoreCase("textbox")) {

            UiControl.textbox(driver, element, processedValue);

        }
        if (type.equalsIgnoreCase("dropbox")) {
            UiControl.dropbox(driver, element, processedValue);
        }

        UnitAction.setAlias(alias, processedValue);
    }
    
    public static void clickOnButton(WebDriver driver, String buttonName) {

        try {
            driver.findElement(By.xpath("//input[@value='" + buttonName + "']")).click();
        } catch (Exception e) {

            try {
                driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")).click();
            } catch (Exception e2) {

                driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
            }
        }
    }

    public static void checkElementText(WebDriver driver, String element, String value)
            throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, ConfigurationException, IOException, InterruptedException {
        
        WebElement webElement = UnitAction.getElement(driver, element);
        String actual = webElement.getText();
        Assert.assertEquals(value, actual);
    }
}
