package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.CommonFunction;

public class GenericCaseTaskDefination {
	
	 public static String information = "//input[@id='SystemCaseTaskDefinitionModel_Information']";
	 public static String entityRequired = "//input[@id='SystemCaseTaskDefinitionModel_EntityRequired']";
	 public static String quickMenu = "//input[@id='quick-menu-button']";
	 public static String genericCase = "//a[@class='collapse-node'][contains(text(),'Generic Case')]";
	 public static String configuration = "/html[1]/body[1]/header[1]/div[5]/div[2]/div[1]/ul[1]/li[10]/ul[1]/li[1]/a[1]";
	 public static String genericCaseTaskDefinitions = "//a[@id='generic-case-task-definitions']";
	 

	 
	 public static String newCase = "//button[@id='cx-header-new-generic-case']";

	
	public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException{
		System.out.println("Navigate to Generic case method is excuted----> " + Page.currentPage);
		
		CommonFunction.click(driver, "quickMenu");
        CommonFunction.click(driver, "genericCase");
		CommonFunction.click(driver, "configuration");
		CommonFunction.click(driver, "genericCaseTaskDefinitions");
		
	}
	
	public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
	}
	
	public static void createGenericCase(WebDriver driver) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		CommonFunction.click(driver, "newCase");
	}
		 		
}
