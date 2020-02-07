package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class Home {
	
	 public String newCase = "//button[@id='cx-header-new-generic-case']";
	 public String caseType = "//*[@aria-owns='CreateNewCaseViewModel_CaseTypeId_listbox']";



	
	 public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
		}

}
