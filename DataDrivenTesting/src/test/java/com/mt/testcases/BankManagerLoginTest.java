package com.mt.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.mt.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class BankManagerLoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException {
		//System.out.println(OR.getProperty("bmlBtn"));
		
		System.out.println("Test case started");
		log.debug("testing ");
		
		test.log(LogStatus.INFO, "We are going to click  Bank manager login");
		
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		click("bmlBtn_CSS");
		Thread.sleep(3000); //for the time being
		
		log.debug("Login successfully executed.");
		
		//checking the lement is present or not
		//Assert.assertTrue(  isElementPresent(By.cssSelector("button[ng-class='btnClass1']")) , ""    );
		
		
		Assert.assertTrue( isElementPresent(OR.getProperty("addCustBtn_CSS")), "Did not find the Element");
		
		
		/*
		System.setProperty("org.uncommons.reportng.escape-output", "false"); 
		Reporter.log("<a target=_blank href=mypic.jpg > Login Screen shot from BM</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=_blank href=mypic.jpg > <img src=mypic.jpg width=30 height=30  >BM</img></a>");
		*/

//		try {
//			driver.findElement(By.cssSelector("button[ng-class='btnClass1']"));
//			Assert.assertTrue(true,"Pass oooo");
//			log.debug("in try");
//		}
//		catch (NoSuchElementException nn) {
//			Assert.assertTrue(false,"Fail mmmm");
//			log.debug("in catch");
//		}
//		
		
		
	}
}//class
