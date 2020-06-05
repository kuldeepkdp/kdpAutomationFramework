package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UiControl {
    
 // handling standard dropbox
    public static void dropbox(WebDriver driver, String element, String value) throws ConfigurationException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {

        UserAction.click(driver, element);
        List<WebElement> option = driver.findElement(By.xpath(UnitAction.getXPath(element)))
                .findElements(By.xpath("//option"));
        for (WebElement e : option) {
            if (e.getText().equals(value)) {
                e.click();
            }
        }
    }

    // handling list dropbox
    public static void dropbox2(WebDriver driver, String element, String value) throws ConfigurationException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {

        UserAction.click(driver, element);
        List<WebElement> option = driver.findElement(By.xpath(UnitAction.getXPath(element)))
                .findElements(By.xpath("//li[@role='option']"));
        for (WebElement e : option) {
            if (e.getText().equals(value)) {
                e.click();
            }
        }
    }

    // handling textbox
    public static void textbox(WebDriver driver, String element, String value) throws Exception {
            UserAction.sendKeys(driver, element, value);
    }
    
    // handling date
    public static void date(WebDriver driver, String element, String value) throws Exception {
            UserAction.sendKeys(driver, element, value);
    }
    
 // handling lookup
    public static void lookup(WebDriver driver, String element, String value) throws Exception {
        
        WebElement ele = UnitAction.getElement(driver, element);
        ele.sendKeys(value);
        Thread.sleep(4000);
        ele.sendKeys(Keys.TAB);
        ele.sendKeys(Keys.ENTER);
    }
}
