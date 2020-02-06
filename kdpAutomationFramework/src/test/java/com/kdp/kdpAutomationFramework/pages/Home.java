package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class Home extends Page {
	
	 public String newCase = "//button[@id='cx-header-new-generic-case']";
	 public String caseType = "//*[@aria-owns='CreateNewCaseViewModel_CaseTypeId_listbox']";
	
	public static void assertOnPage(WebDriver driver) throws InterruptedException {
		System.out.println("user is now on Home page----> " + Page.currentPage);
	}

}
