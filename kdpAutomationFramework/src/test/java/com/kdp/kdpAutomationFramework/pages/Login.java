package com.kdp.kdpAutomationFramework.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.kdp.kdpAutomationFramework.baseFunction.CommonFunction;

public class Login extends Page{
	
    public String userName = "//input[@id='LoginModel_UserName']";
    public String password = "//input[@id='LoginModel_Password']";
    
	public static void navigateToPage(WebDriver driver){
		
		 try {
			driver.navigate().to(CommonFunction.GetData("url"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

}
