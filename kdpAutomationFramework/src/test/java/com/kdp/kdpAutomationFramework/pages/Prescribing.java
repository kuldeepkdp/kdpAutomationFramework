package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UnitAction;
import com.kdp.kdpAutomationFramework.pages.Page;

public class Prescribing {

	public String surname = "//input[@id='Surname']";
	public String forename = "//input[@id='Forename']";
	public String search = "//button[@id='searchButton']";
	public String postCode = "//input[@id='Postcode']";
	public String description = "//input[@name='SystemCaseTaskDefinitionModel.Description']";
	public String information = "//input[@id='SystemCaseTaskDefinitionModel_Information']";
	public String entityRequired = "//input[@id='SystemCaseTaskDefinitionModel_EntityRequired']";
	public String quickMenu = "//input[@id='quick-menu-button']";
	public String genericCase = "//a[@class='collapse-node'][contains(text(),'Generic Case')]";
	public String configuration = "/html[1]/body[1]/header[1]/div[5]/div[2]/div[1]/ul[1]/li[10]/ul[1]/li[1]/a[1]";
	public String genericCaseTaskDefinitions = "//a[@id='generic-case-task-definitions']";
	public String newCase = "//button[@id='cx-header-new-generic-case']";
	public String firstName = "//input[@id='FirstName']";
	public String lastName = "//input[@id='LastName']";
	public String termsOfService = "//div[@class='col-md-12 terms']//p//input";
	public String tryCrmFree = "//button[@class='thin-btn']";
	public String userName = "//input[@id='LoginModel_UserName']";
	public String password = "//input[@id='LoginModel_Password']";
	public String companies = "//*[@aria-owns='CompanyId_listbox']";
	public String notes = "//*[@id='VisitsCaseDetailViewModel_Notes']";
	public String visitType = "//*[@aria-owns='VisitsCaseDetailViewModel_VisitTypeId_listbox']";
	public String targetVisitDate = "//*[@id='VisitsCaseDetailViewModel_VisitDate']";
	public String createVisitCasePopup = "//div[contains(text(),'Create Visit Case - Select Entity')]";
	public String postCodea = "//input[@id='Postcode']";
	public String descriptiona = "//input[@name='SystemCaseTaskDefinitionModel.Description']";
	public String informationa = "//input[@id='SystemCaseTaskDefinitionModel_Information']";
	public String entityRequireda = "//input[@id='SystemCaseTaskDefinitionModel_EntityRequired']";
	public String quickMenua = "//input[@id='quick-menu-button']";
	public String genericCasea = "//a[@class='collapse-node'][contains(text(),'Generic Case')]";
	public String configurationa = "/html[1]/body[1]/header[1]/div[5]/div[2]/div[1]/ul[1]/li[10]/ul[1]/li[1]/a[1]";
	public String genericCaseTaskDefinitionsa = "//a[@id='generic-case-task-definitions']";
	public String newCasea = "//button[@id='cx-header-new-generic-case']";
	public String firstNamea = "//input[@id='FirstName']";
	//Below elements are related to prescribing page
	public String sensitivitiesAndAllergies = "//a[@id='sensitivitiesAndAllergiesNavItem']";
    //	
	public String lastNamea = "//input[@id='LastName']";
	public String termsOfServicea = "//div[@class='col-md-12 terms']//p//input";
	public String tryCrmFreea = "//button[@class='thin-btn']";
	public String userNamea = "//input[@id='LoginModel_UserName']";
	public String passworda = "//input[@id='LoginModel_Password']";
	public String companiesa = "//*[@aria-owns='CompanyId_listbox']";
	public String notesa = "//*[@id='VisitsCaseDetailViewModel_Notes']";
	public String recordAllergy = "//button[@id='recordAllergy']";
	public String visitTypea = "//*[@aria-owns='VisitsCaseDetailViewModel_VisitTypeId_listbox']";
	public String targetVisitDatea = "//*[@id='VisitsCaseDetailViewModel_VisitDate']";
	public String createVisitCasePopupa = "//div[contains(text(),'Create Visit Case - Select Entity')]";
	public String searchUsing = "//select[@id='searchUsingDropdown']";
	public String gender = "//select[@id='genderTypeDropdown']";
	public String firstRecordFromSearchResult = "//table[@id='searchresult']/tbody/tr[1]";


	

	public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException,
			InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
	}

	public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, InterruptedException {

	}

}
