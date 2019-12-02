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

import com.kdp.kdpAutomationFramework.pages.Page;

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

	public static void Click(WebDriver driver, String element)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		driver.findElement(By.xpath(getCurrentElementXpath(element))).click();
	}

	public static void SendKeys(WebDriver driver, String element, String value)
			throws SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		driver.findElement(By.xpath(getCurrentElementXpath(element))).sendKeys(value);
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

	public static void clickOnButton(WebDriver driver, String element) {

		driver.findElement(By.xpath("//input[@value='" + element + "' or contains(text(),'" + element + "')]")).click();

	}
}
