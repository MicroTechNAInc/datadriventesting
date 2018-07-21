package com.mt.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.mt.base.TestBase;

public class TestUtils extends TestBase {
	
	public static String screenShotName;
	
	public static void captureScreenshot() throws IOException {
		Date d=new Date();
		File scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenShotName=d.toString().replace(" ", "-").replace(":", "-") + ".jpg";
		
		FileUtils.copyFile(scrFile, new File( System.getProperty("user.dir")  + "\\target\\surefire-reports\\html\\" + screenShotName));
		
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){   //import java.lang
		String sheetName = m.getName();
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
	
	
}
