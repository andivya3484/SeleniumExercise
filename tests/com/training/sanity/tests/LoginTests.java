package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class LoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static String adminURL;

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
	
	@Test(enabled=false)
	public void validLoginTest() {
		loginPOM.clickAccount();
		loginPOM.sendUserName("divya.a.3484@gmail.com");
		loginPOM.sendPassword("Apr2020");
		loginPOM.clickLoginBtn(); 
		loginPOM.hoverAccount();
		//loginPOM.accountLinks();
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
	
	@Test(enabled=false)
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
	
	@Test(enabled=false)
	public void pwdreset() {
		loginPOM.changePwd();
		loginPOM.pwd("May2020");
		loginPOM.pwdConfirm("May2020");
		loginPOM.submit();
		loginPOM.pwdsuccessMsg();
		screenShot.captureScreenShot("Third");
	}
	
	@Test(priority = 0)
	public void itemReturn() {
		validLoginTest();  //can i give priority as 0 for this method?
		loginPOM.clickReturn();
		loginPOM.verifyReturnPage();
		loginPOM.selectReason();
		Assert.assertTrue(loginPOM.radioOpened());
		loginPOM.faultReason();
		loginPOM.returnSubmit();
		loginPOM.returnSuccess();
		screenShot.captureScreenShot("Fourth");
	}
	
	/*
	@Test(priority=0)
	public void invalidLogin() {
		driver.navigate().to(adminURL);
		String[] userName = {"admin", "admin", "manzoor", "admin@123"};
		String[] pwd = {"123456", "admin", "admin@123", "admin@123"};
		String[] num = {"fifth-one","fifth-two", "fifth-three","fifth.four"};
		loginPOM.clickAccount();
		for(int i=0; i<4;i++) {
			loginPOM.sendUserName(userName[i]);
			loginPOM.sendPassword(pwd[i]);
			loginPOM.clickLoginBtn(); 
			loginPOM.errMsg();
			System.out.println("'"+userName[i]+"' & '"+pwd[i]+"'");
			screenShot.captureScreenShot(num[i]);
		}
	}*/
	/* INCLUDED IN "LoginMulitpleValues.Java" CLASS
	@Test(enabled=false, dataProvider = "testdata")
	public void invalidLogin(String userName, String pwd, String screenshotName) {
		driver.navigate().to(adminURL);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(pwd);
		loginPOM.adminSubmit(); 
		loginPOM.errMsg();
		System.out.println("'"+userName+"' & '"+pwd+"'");
		screenShot.captureScreenShot(screenshotName);	
	}
	
	@DataProvider(name="testdata")  
	public static Object[][] returnData() {
		return new Object[][] {
		{"admin", "123456", "fifth-one"},
		{"admin", "admin", "fifth-two"},
		{"manzoor", "admin@123", "fifth-three"},
		{"admin@123", "admin@123", "fifth-four"}		
		}
		;	
	}*/
	
	@Test(priority=1, enabled=true)
	public void addCategory() {
		driver.navigate().to(adminURL);
		loginPOM.adminuserName("admin");
		loginPOM.adminPassword("admin@123");
		loginPOM.adminSubmit();
		loginPOM.hoverCatalog();
		loginPOM.clickAttribute();
		loginPOM.verifycatalogLinks();
		loginPOM.clickCategory();
		loginPOM.webTableCategory();
		loginPOM.webtableCategoryName();
		loginPOM.webtableSortOrder();
		loginPOM.webtableAction();
		loginPOM.clickNew();
		loginPOM.addCategoryName("ORNAMENTS");
		loginPOM.addDesc("ornaments for ladies");
		loginPOM.addtagTitle("ORNAMENTS");
		loginPOM.addTagDesc("ornaments for ladies");
		loginPOM.saveCategory();
		loginPOM.verifysaveCategory();
		screenShot.captureScreenShot("Sixth");	
	}
	
	/*Question to Roshan - 
	 * 1. Why is the execution sequence sixth, fifth, Seventh and Eighth? After AddCategory, it goes to invalid login and comes back again and continue edit category.
	 * 2. Can i comment all the starting common steps and execute unique steps from the test cases.
	 * 3. in test case RTTC_036, step 1, App is showing as 3 values but inspect mode is showing  4 values.
	 */
	
	@Test(priority=2, enabled=true)
	public void editCategory() {
		//driver.navigate().to(adminURL);
		//loginPOM.adminuserName("admin");
		//loginPOM.adminPassword("admin@123");
		//loginPOM.adminSubmit();
		//loginPOM.hoverCatalog();
		//loginPOM.verifycatalogLinks();
		//loginPOM.clickCategory();
		loginPOM.clickEdit();
		loginPOM.verifyEditCategory();
		loginPOM.addtagTitle("New Ornaments");
		loginPOM.addTagDesc("New Ornaments for ladies");
		loginPOM.saveCategory();
		loginPOM.verifysaveCategory();
		screenShot.captureScreenShot("Seventh");	
	}
	
	@Test(priority=3, enabled=true)
	public void deleteCategory() throws InterruptedException {
		//driver.navigate().to(adminURL);
		//loginPOM.adminuserName("admin");
		//loginPOM.adminPassword("admin@123");
		//loginPOM.adminSubmit();
		//loginPOM.hoverCatalog();
		//loginPOM.verifycatalogLinks();
		//loginPOM.clickCategory();
		loginPOM.selectCategory();
		loginPOM.deleteCategory();	
		loginPOM.verifyConfirmation();
		screenShot.captureScreenShot("Eighth");
	}
}
