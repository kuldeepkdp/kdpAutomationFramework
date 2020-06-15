package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UserAction;

public class SensitivitiesAndAllergies {

    public String sensitivitiesAndAllergiesTab = "//a[@id='sensitivitiesAndAllergiesNavItem']";
    public String header = "//h3[contains(text(),'Sensitivities And Allergies History')]";
    public String drug = "//input[@id='DrugFreeText']";
    public String category = "//label[contains(text(),'Category')]/following-sibling::div/select";
    public String sourceOfInfo = "//label[contains(text(),'Source of Info')]/following-sibling::div/select";
    public String checkedBy = "//input[@id='auto-comp-user-checked-by']";
    public String checkedDate = "//input[@id='checkedDate']";
    public String sourceNotes = "//textarea[@id='SourceNotes']";
    public String sensitivitiesAndAllergiesHistory = "//table[@id='allergysearchresult']";
    public String ok = "//button[@id='allergyOkButton']";
    public String yes = "//div[@id='confirm_modal_record_drug_free_text']//button[@class='btn btn-primary'][contains(text(),'Yes')]";

    public static void assertOnPage(WebDriver driver) throws InterruptedException, SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("assert on page ->user is now on Home page----> " + Page.currentPage);
    }

    public static void navigateToPage(WebDriver driver) throws SecurityException, InstantiationException,
            IllegalAccessException, ClassNotFoundException, InterruptedException, ConfigurationException, IOException {
        UserAction.click(driver, "sensitivitiesAndAllergiesTab");
    }

}
