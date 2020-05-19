package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginMultipleValuesTest {
	private static WebDriver driver; 
	private static String baseUrl; 
	private static LoginPOM loginPOM; 
	private static Properties properties; 
	private static ScreenShot screenShot; 
	private static String adminURL;


	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"admin", "123456", "fifth-one"},
			{"admin", "admin", "fifth-two"},
			{"manzoor", "admin@123", "fifth-three"},
			{"admin@123", "admin@123", "fifth-four"}		
			}
			;	
	}

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}
/*
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}*/
	
	//@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider="inputs")
	public void testMethod1(String userName, String pwd, String screenshotName) {
		//driver.navigate().to(adminURL);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pwd);
		loginPOM.adminSubmit(); 
		loginPOM.errMsg();
		System.out.println("'"+userName+"' & '"+pwd+"'");
		screenShot.captureScreenShot(screenshotName);	
	}
	
}