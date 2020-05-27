package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
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

	/*// To get data from properties file
	public static String GetData(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resource//ObjectRepo.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return (properties.getProperty(key));
	}*/

	// To get data from configuration.properties file
	public static String GetConfigData(String key) throws ConfigurationException {

		PropertiesConfiguration properties = new PropertiesConfiguration(
				System.getProperty("user.dir") + "//src//test//resource//configuration.properties");
		return properties.getString(key);
	}

	// To get data from environment mentioned in configuration.properties file
	public static String GetData(String key) throws Exception {
		PropertiesConfiguration properties;
		if(GetConfigData("getDataFromEnvironment").equals("testEnvironment")) {
          properties = new PropertiesConfiguration(
					System.getProperty("user.dir") + "//src//test//resource//testEnvironment.properties");
		}
		else if(GetConfigData("getDataFromEnvironment").equals("sandboxEnvironment")) {
	          properties = new PropertiesConfiguration(
						System.getProperty("user.dir") + "//src//test//resource//sandboxEnvironment.properties");
			}
		else {
			throw new Exception("mentioned environment is not iplemented to get data");
		}
		
		return properties.getString(key);
	}
	
	// To Get data from RunTimeDataRepo.properties file
		public static String GetRunTimeData(String key) throws IOException, ConfigurationException {

			PropertiesConfiguration properties = new PropertiesConfiguration(
					System.getProperty("user.dir") + "//src//test//resource//runTimeDataRepo.properties");
			return properties.getString(key);

		}

	// To Set data into RunTimeDataRepo.properties file
	public static void SetRunTimeData(String key, String value) throws IOException, ConfigurationException {

		PropertiesConfiguration properties = new PropertiesConfiguration(
				System.getProperty("user.dir") + "//src//test//resource//runTimeDataRepo.properties");
		properties.setProperty(key, value);
		properties.save();
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

	public static void waitForElementToBeClickable(WebDriver driver, String element) throws SecurityException,
			InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getCurrentElementXpath(element))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getCurrentElementXpath(element))));
	}

	public static void openApplication(WebDriver driver) throws Exception {

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

	public static void click(WebDriver driver, String element) throws SecurityException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, InterruptedException {
		waitForElementToBeClickable(driver, element);
		try {
			driver.findElement(By.xpath(getCurrentElementXpath(element))).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath(getCurrentElementXpath(element))).click();
		}
	}

	public static void sendKeys(WebDriver driver, String element, String value) throws SecurityException,
			InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		waitForElementToBeClickable(driver, element);
		try {
			driver.findElement(By.xpath(getCurrentElementXpath(element))).sendKeys(value);
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath(getCurrentElementXpath(element))).sendKeys(value);
		}
	}

	public static void navigateToPage(WebDriver driver, String pagename)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		Page.setCurrentPage(pagename);
		System.out.println("current page is set to" + Page.getCurrentPage());

		String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;

		Class cls = Class.forName(fullPathOfTheClass);
		Method method = cls.getDeclaredMethod("navigateToPage", WebDriver.class);
		method.invoke(null, driver);

	}

	public static void assertOnPage(WebDriver driver, String pagename)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		Page.setCurrentPage(pagename);
		System.out.println("current page is set to" + Page.getCurrentPage());

		String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + pagename;

		Class cls = Class.forName(fullPathOfTheClass);
		Method method = cls.getDeclaredMethod("assertOnPage", WebDriver.class);
		method.invoke(null, driver);

	}

	public static void clickOnButton(WebDriver driver, String buttonName) {

		try {
			driver.findElement(By.xpath("//input[@value='" + buttonName + "']")).click();
		} catch (Exception e) {

			try {
				driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")).click();
			} catch (Exception e2) {

				driver.findElement(By.xpath("//*[contains(text(),'" + buttonName + "')]")).click();
			}
		}
	}

	public static void checkElementText(WebDriver driver, String element, String value)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String actual = driver.findElement(By.xpath(getCurrentElementXpath(element))).getText();
		Assert.assertEquals(value, actual);
	}
	
	//This method will return value from properties file, random values or just the passed value as per value format
	public static String getValue(String value) throws Exception {
		if(value.startsWith("$")) {
			return CommonFunction.GetData(value);
		}
		if(value.startsWith("&")) {
			return CommonFunction.GetRunTimeData(value);
		}
		else return value;	
	}
	
	//This method will set alias on runTimeDataRepo file
	public static void setAlias(String alias, String value) throws ConfigurationException, IOException {
			if (!alias.equals("")) {
				CommonFunction.SetRunTimeData(alias, value);
			}
		}
	
	//Set the value on mentioned UI controls
	 public static void setValue(WebDriver driver, String element, String type, String value, String alias) throws Exception {
		String inputValue= getValue(value);

		if(type.equalsIgnoreCase("textbox")) {
			
			UiControl.textbox(driver, element, inputValue);
			
		}
        if(type.equalsIgnoreCase("dropbox")) {
        	UiControl.dropbox(driver, element, inputValue);
		}
        
		setAlias(alias,inputValue);
	}
}
