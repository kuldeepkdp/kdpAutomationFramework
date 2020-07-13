package com.kdp.kdpAutomationFramework.pages;

import org.openqa.selenium.WebDriver;

public class GenericCaseTypeConfiguration {
    
    public String companies = "//*[@aria-owns='GenericCaseTypeModel_CompanyIds_listbox']";
    public String category = "//*[@aria-owns='CategoriesTypeId_listbox']";
    public String description = "//input[@id='GenericCaseTypeModel_Description']";
    public String entityType = "//*[@aria-owns='GenericCaseTypeModel_EntityType_listbox']";
    public String searchCaseType = "//input[@id='generic-case-type-search-6']";
    public String DescriptionValidationMessage = "//span[@id='GenericCaseTypeModel.Description_validationMessage']";

    public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {

    }

    public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException,
            IllegalAccessException, ClassNotFoundException, InterruptedException {

    }

}
