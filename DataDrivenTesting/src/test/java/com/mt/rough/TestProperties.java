package com.mt.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		String projectPath = System.getProperty("user.dir");
		FileInputStream fis;
		
		Properties config = new Properties(); 
		fis = new FileInputStream( projectPath+"\\src\test\\resources\\properties\\Config.properties"); 
		config.load(fis);  //add throws declaration
		
		Properties OR = new Properties(); 
		fis = new FileInputStream(projectPath+"\\src\test\\resources\\properties\\OR.properties"); 
		OR.load(fis);  //add throws declaration
		
		//Driver.findElement(By.cssSelector(OR.getProperty(“bmlBtn”))).click();

	}//main

}//Class
