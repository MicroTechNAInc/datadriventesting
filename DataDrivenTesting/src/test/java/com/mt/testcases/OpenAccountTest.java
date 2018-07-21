package com.mt.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mt.base.TestBase;
import com.mt.utilities.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

public class OpenAccountTest extends TestBase {
	
	/*
	@Test(dataProviderClass=TestUtils.class, dataProvider="dp")
	public void openAccountTest(String firstName, String lastName, String postCode, String msg) throws InterruptedException {
		
		test.log(LogStatus.INFO, "open account");
		Assert.assertTrue( true );
	}//
	*/
	
	@Test
	public void myTest() {
		test.log(LogStatus.INFO, "open account");
		Assert.assertTrue( true );
	}
	
	
}//
