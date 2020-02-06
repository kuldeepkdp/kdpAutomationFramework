package com.kdp.kdpAutomationFramework.baseFunction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppSpecificUiControl {
	
	public static void selectFromStandardDropbox(WebDriver driver, String element, String value) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		
		CommonFunction.click(driver, element);
		List<WebElement> option = driver.findElement(By.xpath(CommonFunction.getCurrentElementXpath(element))).findElements(By.xpath("//li[@role='option']"));
		for(WebElement e : option) {
			if(e.getText().equals(value)) {
				e.click();
			}
		}
	}

}
