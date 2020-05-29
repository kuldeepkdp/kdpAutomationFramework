package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.UnitAction;

public class Login {
	
    public String userName = "//input[@id='LoginModel_UserName']";
    public String password = "//input[@id='LoginModel_Password']";
    

	
	public static void navigateToPage(WebDriver driver) throws Exception{
		 try {
				driver.navigate().to(UnitAction.GetData("url"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}

}
