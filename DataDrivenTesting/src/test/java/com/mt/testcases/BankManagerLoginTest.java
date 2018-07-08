package com.mt.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mt.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException {
		//System.out.println(OR.getProperty("bmlBtn"));
		
		System.out.println("Test case started");
		log.debug("Test case Startedqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000); //for the time being
		
		log.debug("Login successfully executed.");
		
		//checking the lement is present or not
		//Assert.assertTrue(  isElementPresent(By.cssSelector("button[ng-class='btnClass1']")) , ""    );
		

		Assert.assertTrue( isElementPresent(OR.getProperty("addCustBtn")), "Did not find the Element");
		
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
