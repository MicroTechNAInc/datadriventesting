package com.mt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mt.utilities.ExcelReader;
import com.mt.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	public static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver; 
	public static Properties config = new Properties(); 
	public static Properties OR = new Properties(); 
	public static FileInputStream fis;
	
	public static ExcelReader excel;
	              
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static WebDriverWait wait;
	
	public ExtentReports extentReportObject = ExtentManager.getInstance(); 
	public static ExtentTest test;

	
	
	@BeforeSuite
	public void setUp() throws IOException  {
		if (driver==null) {
				fis = new FileInputStream(projectPath+"\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis);
				log.debug("config file loaded.");
			
				fis = new FileInputStream(projectPath+"\\src\\test\\resources\\properties\\OR.properties");
				OR.load(fis);
			
			//Browser Specific Code
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome launched...");
			} else if (config.getProperty("browser").equals("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver", projectPath+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
				WebDriver driver = new InternetExplorerDriver();
			}
			
			//Driver initializing code
			driver.get(config.getProperty("testsiteurl"));
			log.debug("navigated to test site: " + config.getProperty("testsiteurl") );
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt( config.getProperty("implicit.wait") ), TimeUnit.SECONDS);
			
			wait = new WebDriverWait(driver, 5);
			
			excel = new ExcelReader(projectPath + "\\src\\test\\resources\\excel\\testdata.xlsx");
			
		}//if (driver == null)	
	}//setUp
	
	public void click(String locator) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}
	public void type(String locator, String value) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in : "+locator + " with value: " + value);
	}
	
	

	public boolean isElementPresent(String css) {
		try {
			driver.findElement(By.cssSelector(css));
			return true;
		}
		catch (NoSuchElementException nn) {
			return false;
		}
	}//
	

	
	@AfterSuite
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}//tearDown()

}
