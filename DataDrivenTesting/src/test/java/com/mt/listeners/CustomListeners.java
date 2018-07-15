package com.mt.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.mt.base.TestBase;
import com.mt.utilities.TestUtils;
import com.relevantcodes.extentreports.LogStatus;



public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extentReportObject.startTest(result.getName().toUpperCase());

		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		
		
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false"); 
		Reporter.log("<a target=_blank href=" + TestUtils.screenShotName + " > Login Screen shot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=_blank href=" + TestUtils.screenShotName + " > <img src=" + TestUtils.screenShotName + " width=30 height=30  ></img></a>");
		
		
		//here test is TestBase class member
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		extentReportObject.endTest(test); //to close the test
		extentReportObject.flush(); //to generate the report

		
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
