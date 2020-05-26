package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class InsightlyAccount {
	
	public String firstName = "//input[@id='FirstName']";
	public String lastName = "//input[@id='LastName']";
	public String termsOfService = "//div[@class='col-md-12 terms']//p//input";
	

	 public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
		}
	 
	 public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException{
		 		 
	}

}
