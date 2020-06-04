package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class CesLogin {
    
    public String userName = "//input[@id='Username']";
    public String password = "//input[@id='Password']";
    public String logIn = "//button[@id='loginBtn']";

    public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
    }

    public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException,
            IllegalAccessException, ClassNotFoundException, InterruptedException {

    }

}
