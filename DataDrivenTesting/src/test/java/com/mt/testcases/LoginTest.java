package com.mt.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.mt.base.TestBase;

public class LoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException {
		//System.out.println(OR.getProperty("bmlBtn"));
		log.debug("inside login Test");  
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000); //for the time being
		log.debug("Login successfully executed.");
		

	}
}//class
