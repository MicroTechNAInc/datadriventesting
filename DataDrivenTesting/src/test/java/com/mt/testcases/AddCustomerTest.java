package com.mt.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mt.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@DataProvider
	public Object[][] getData(){
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount( sheetName );  //row=2
		int cols = excel.getColumnCount(sheetName); //col =3
		Object[][] data = new Object[rows-1][cols];
		
		for (int r=1; r<=rows-1; r++) {
			for (int c=0; c<=cols-1; c++) {
				data[r-1][c] = excel.getCellData(sheetName, c, r);
				log.debug(excel.getCellData(sheetName, c, r));
			}//col for
		}//row for
		return data;
	}//
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String msg) throws InterruptedException {
		
		log.debug(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		
		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
		
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		
		//Thread.sleep(5000);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(  alert.getText().contains(msg) );	
		
		alert.accept();
		
	}//
	
	
}//
