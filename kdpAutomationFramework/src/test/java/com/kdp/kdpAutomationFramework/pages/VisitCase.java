package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class VisitCase {
	
	public String companies = "//*[@aria-owns='CompanyId_listbox']";
	public String notes = "//*[@id='VisitsCaseDetailViewModel_Notes']";
	
	public String visitType = "//*[@aria-owns='VisitsCaseDetailViewModel_VisitTypeId_listbox']";
	public String targetVisitDate = "//*[@id='VisitsCaseDetailViewModel_VisitDate']";
	public String createVisitCasePopup = "//div[contains(text(),'Create Visit Case - Select Entity')]";

	public static void assertOnPage(WebDriver driver) throws InterruptedException {
		System.out.println("user is now on Home page----> " + Page.currentPage);
	}

}
