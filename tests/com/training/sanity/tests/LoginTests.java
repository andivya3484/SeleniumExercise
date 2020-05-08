package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
    /*
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void validLoginTest() {
		loginPOM.clickAccount();
		loginPOM.sendUserName("divya.a.3484@gmail.com");
		loginPOM.sendPassword("Apr2020");
		loginPOM.clickLoginBtn(); 
		loginPOM.hoverAccount();
		loginPOM.clickOrder();
		loginPOM.webTable();
		loginPOM.webTableOrderId();
		loginPOM.webTableCustomer();
		loginPOM.webTablenoofProducts();
		loginPOM.webTableStatus();
		loginPOM.webTableTotal();
		loginPOM.webTableDateAdded();
		loginPOM.viewIcon();
		loginPOM.orderDetails();
		screenShot.captureScreenShot("First");
	}
	
	@Test(priority=1)
	public void accountUpdate() {
		loginPOM.clickAccount();
		loginPOM.editAccount();
		loginPOM.fName("New First Name");
		loginPOM.lName("New Last Name");
		loginPOM.email("divya.a.3484@gmail.com");
		loginPOM.tPhone("7138250429");
		loginPOM.submit();
		loginPOM.acctsuccessMsg();
		screenShot.captureScreenShot("Second");
	}
	
	@Test(priority=2)
	public void pwdreset() {
		loginPOM.changePwd();
		loginPOM.pwd("May2020");
		loginPOM.pwdConfirm("May2020");
		loginPOM.submit();
		loginPOM.pwdsuccessMsg();
		screenShot.captureScreenShot("Third");
	}
}
