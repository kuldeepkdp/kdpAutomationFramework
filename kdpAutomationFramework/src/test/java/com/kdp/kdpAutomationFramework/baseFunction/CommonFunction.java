package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kdp.kdpAutomationFramework.pages.Page;

import junit.framework.Assert;

public class CommonFunction {

	// To get data from properties file
	public static String GetData(String e) throws IOException {
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resource//ObjectRepo.properties");
		Properties or = new Properties();
		or.load(fs);

		return (or.getProperty(e));
	}

	// To get data from excel sheet
	public static String getDataFromExcel(String tab, int row, int column) throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resource//TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(tab);
		Row r = sh.getRow(row);
		Cell cell = r.getCell(column);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		String cellval = cell.getStringCellValue();
		return cellval;

	}

	// To store run time result in excel sheet
	public static void storeResult(String result, int row, int column) throws IOException, InvalidFormatException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resource//RunTimeStoredValue.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Output");
		Cell cell = null; // declare a Cell object

		cell = sh.getRow(row).getCell(column); // Access the second cell in
												// second row to update the
												// value

		cell.setCellValue(result); // Get current cell value value and overwrite
									// the value

		fis.close(); // Close the InputStream
		FileOutputStream output_file = new FileOutputStream(
				System.getProperty("user.dir") + "//src//test//resource//RunTimeStoredValue.xls"); // Open
																									// FileOutputStream
																									// to
																									// write
																									// updates
		wb.write(output_file); // write changes
		output_file.close(); // close the stream

	}

	// To get run time stored value from excel sheet
	public static String getStoredResult(String tab, int row, int column) throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resource//RunTimeStoredValue.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(tab);
		Row r = sh.getRow(row);
		Cell cell = r.getCell(column);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		String cellval = cell.getStringCellValue();
		return cellval;

	}

	public static void waitFor(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}
	
	public static void waitForElementToBeClickable(WebDriver driver, String element) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		       WebDriverWait wait = new WebDriverWait(driver,30);
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getCurrentElementXpath(element))));
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getCurrentElementXpath(element))));
	}

	public static void openApplication(WebDriver driver) throws IOException {

		driver.manage().window().maximize();
		driver.get(GetData("url"));

	}

	// To generate unique value
	public static String generateString(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static String getCurrentElementXpath(String element)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		String xpath = null;
		String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + Page.getCurrentPage();

		Field[] fields = Class.forName(fullPathOfTheClass).newInstance().getClass().getDeclaredFields();

		for (Field field : fields) {

			String a = field.getName();
			if (a.equals(element)) {
				xpath = field.get(Class.forName(fullPathOfTheClass).newInstance()).toString();
				break;
			}
		}

		return xpath;
	}

	public static void click(WebDriver driver, String element)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		waitForElementToBeClickable(driver, element);
		try {
		driver.findElement(By.xpath(getCurrentElementXpath(element))).click();
		}catch(Exception e){
			Thread.sleep(2000);
			driver.findElement(By.xpath(getCurrentElementXpath(element))).click();
		}
	}

	public static void sendKeys(WebDriver driver, String element, String value)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		waitForElementToBeClickable(driver, element);
		try {
		driver.findElement(By.xpath(getCurrentElementXpath(element))).sendKeys(value);
		}catch(Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath(getCurrentElementXpath(element))).sendKeys(value);
		}
	}

	public static void navigateToPage(WebDriver driver, String pagename)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;

		Class cls = Class.forName(fullPathOfTheClass);
		Method method = cls.getDeclaredMethod("navigateToPage", WebDriver.class);
		method.invoke(null, driver);

		Page.setCurrentPage(pagename);
		System.out.println("current page is set to" + Page.getCurrentPage());
	}
	
	public static void assertOnPage(WebDriver driver, String pagename)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;

		Class cls = Class.forName(fullPathOfTheClass);
		Method method = cls.getDeclaredMethod("assertOnPage", WebDriver.class);
		method.invoke(null, driver);

		Page.setCurrentPage(pagename);
		System.out.println("current page is set to" + Page.getCurrentPage());
	}
	

	public static void clickOnButton(WebDriver driver, String buttonName) {

		try {
		driver.findElement(By.xpath("//input[@value='" + buttonName + "']")).click();
		}catch (Exception e) {
			
		      try {
		           driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")).click();
		      }catch (Exception e2) {
		    	  
		    	  driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
		      }
		}
	}
	
	public static void checkElementText(WebDriver driver,String element, String value) throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String actual= driver.findElement(By.xpath(getCurrentElementXpath(element))).getText();
		Assert.assertEquals(value, actual);
	}
}
