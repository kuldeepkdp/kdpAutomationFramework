package com.kdp.kdpAutomationFramework.baseFunction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kdp.kdpAutomationFramework.pages.Page;

import junit.framework.Assert;

public class UnitAction {

    // To get data from configuration.properties file
    public static String GetConfigData(String key) throws ConfigurationException {

        PropertiesConfiguration properties = new PropertiesConfiguration(
                System.getProperty("user.dir") + "//src//test//resource//dataRepo//configuration.properties");
        return properties.getString(key);
    }

    // To get data from environment mentioned in configuration.properties file
    public static String GetData(String key) throws Exception {
        PropertiesConfiguration properties;
        if (GetConfigData("getDataFromEnvironment").equals("testEnvironment")) {
            properties = new PropertiesConfiguration(
                    System.getProperty("user.dir") + "//src//test//resource//dataRepo//testEnvironment.properties");
        } else if (GetConfigData("getDataFromEnvironment").equals("sandboxEnvironment")) {
            properties = new PropertiesConfiguration(
                    System.getProperty("user.dir") + "//src//test//resource//dataRepo//sandboxEnvironment.properties");
        } else {
            throw new Exception("mentioned environment is not iplemented to get data");
        }

        return properties.getString(key);
    }

    // To Get data from RunTimeDataRepo.properties file
    public static String GetRunTimeData(String key) throws IOException, ConfigurationException {

        PropertiesConfiguration properties = new PropertiesConfiguration(
                System.getProperty("user.dir") + "//src//test//resource//dataRepo//runTimeDataRepo.properties");
        return properties.getString(key);

    }

    // To Set data into RunTimeDataRepo.properties file
    public static void SetRunTimeData(String key, String value) throws IOException, ConfigurationException {

        PropertiesConfiguration properties = new PropertiesConfiguration(
                System.getProperty("user.dir") + "//src//test//resource//dataRepo//runTimeDataRepo.properties");
        properties.setProperty(key, value);
        properties.save();
    }

    // To Get data from elementRepo files
    public static String GetElementRepoData(String filename, String key) throws IOException, ConfigurationException {

        PropertiesConfiguration properties = new PropertiesConfiguration(
                System.getProperty("user.dir") + "//src//test//resource//elementRepo//" + filename + ".properties");
        return properties.getString(key);
    }

    // To Get Current Page
    public static String getCurrentPage() throws ConfigurationException, IOException {
        return GetRunTimeData("currentPage");
    }

    // To Set Current Page
    public static void setCurrentPage(String page) throws ConfigurationException, IOException {
        SetRunTimeData("currentPage", page);
    }

    // To get XPath
    public static String getXPath(String element) throws ConfigurationException, IOException, SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {

        String xPath = null;
        if (GetConfigData("elementRepoConifiguration").equalsIgnoreCase("file")) {
            String filename = getCurrentPage();
            xPath = GetElementRepoData(filename, element);
        } else {

            String fullPathOfTheClass = "com.kdp.kdpAutomationFramework.pages." + getCurrentPage();

            Field[] fields = Class.forName(fullPathOfTheClass).newInstance().getClass().getDeclaredFields();

            for (Field field : fields) {

                String a = field.getName();
                if (a.equals(element)) {
                    xPath = field.get(Class.forName(fullPathOfTheClass).newInstance()).toString();
                    break;
                }
            }

        }
        return xPath;
    }

    // To get JavascriptExecutor object
    public static JavascriptExecutor getJavascriptExecutor(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor;
    }

    //Wait until Document is Ready
    public static void waitUntilDocumentIsReady(WebDriver driver) throws InterruptedException {

        for (int i = 0; i < 30; i++) {         
            // To check page ready state.
            if (getJavascriptExecutor(driver).executeScript("return document.readyState").toString()
                    .equals("complete")) {
                break;
            }
            else {
                Thread.sleep(1000);
            }
        }
    }
    
    //To get WebElement
    public static WebElement getElement(WebDriver driver, String element)
            throws ConfigurationException, SecurityException, InstantiationException, IllegalAccessException,
            ClassNotFoundException, IOException, InterruptedException {
        String xPath = getXPath(element);
        waitUntilDocumentIsReady(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xPath))));
        return driver.findElement(By.xpath(xPath));
    }

    // //To get WebElement list
    public static List<WebElement> getElements(WebDriver driver, String element) throws ConfigurationException,
            SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
        String xPath = getXPath(element);
        waitUntilDocumentIsReady(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath(xPath))));
        return driver.findElements(By.xpath(xPath));
    }

    public static void waitUntilElementToBeClickable(WebDriver driver, WebElement element) throws SecurityException,
            InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // To generate random string
    public static String generateString(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    
    // To get date
    public static String getCurrentDate() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return strDate;

    }
        

    // This method will return value from properties file, random values or just the
    // passed value as per value format
    public static String getProcessedValue(String value) throws Exception {
        if (value.startsWith("$")) {
            return UnitAction.GetData(value);
        }
        else if (value.startsWith("&")) {
            return UnitAction.GetRunTimeData(value);
        } 
        
        else if (value.equals("RANDOM_STRING")) {
            return UnitAction.generateString(8);
        } 
        
        else if (value.equals("CURRENT_DATE")) {
            return UnitAction.getCurrentDate();
        } 
        
        
        else
            return value;
    }

    // This method will set alias on runTimeDataRepo file
    public static void setAlias(String alias, String value) throws ConfigurationException, IOException {
        if (!alias.equals("")) {
            UnitAction.SetRunTimeData(alias, value);
        }
    }
}
