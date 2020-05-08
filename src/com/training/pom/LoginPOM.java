package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.collect.ImmutableList;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	////span[contains(text(), 'ACCOUNT')]
	@FindBy(xpath = "//li[@class='tb_link dropdown tb_menu_system_account_account']")
	private WebElement account;
	
	@FindBy(name="email")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//li[@class='tb_link dropdown tb_menu_system_account_account tb_selected']")
	private WebElement hoverAccount;
	
	@FindBy(xpath = "//span[contains(text(), 'ORDERS')]")
	private WebElement clickOrder;
	
	@FindBy(xpath= "//table[@class='table table-hover']/tbody/tr")
	private List<WebElement> webTable;
	
	@FindBy(xpath = "//a[contains(text(),'Edit your account information')]")
	private WebElement editAccount;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[1]")
	private WebElement webTableOrderId;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[2]")
	private WebElement webTableCustomer;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[3]")
	private WebElement webTablenoofProducts;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[4]")
	private WebElement webTableStatus;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[5]")
	private WebElement webTableTotal;
	
	@FindBy(xpath = "//table[@class='table table-hover']/thead/tr/td[6]")
	private WebElement webTableDateAdded;
	
	@FindBy(xpath="//a[@href='http://retail.upskills.in/account/order/info?order_id=361']")
	private WebElement viewIcon;
	
	@FindBy(xpath="//td[contains(text(),'Order Details')]")
	private WebElement orderDetails;
	
	@FindBy(id="input-firstname")
	private WebElement fName;
	
	@FindBy(id="input-lastname")
	private WebElement lName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement tPhone;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[contains(text(),' Success: Your account has been successfully updated.')]")
	private WebElement acctsuccessMsg;
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changePwd;
	
	@FindBy(id="input-password")
	private WebElement pwd;
	
	@FindBy(id="input-confirm")
	private WebElement pwdConfirm;
	
	@FindBy(xpath="//div[contains(text(),' Success: Your password has been successfully updated.')]")
	private WebElement pwdsuccessMsg;
	
	//LoginPage
	
	public void hoverAccount() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverAccount).perform();
	}
	
	public void clickAccount() {
		this.account.click();
	}

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	//Order Details Page
	public void clickOrder() {
		this.clickOrder.click();
	}
	
	public void webTable() {
		int noofRows = webTable.size();
		System.out.println("Number of Records displayed are : " +noofRows);
	}
	
//	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/thead/tr/td[1]")
//	private WebElement webTableOrderId1;
//	
//	public void webTableOrderId1() {
//		String expText = "Order ID";
//		String actText = webTableOrderId1.getText();
//		Assert.assertTrue(actText.contains(expText));	
//		System.out.print(actText+" , ");
//	}
	
	public void webTableOrderId() {
		String expText = "Order ID";
		String actText = webTableOrderId.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webTableCustomer() {
		String expText = "Customer";
		String actText = webTableCustomer.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webTablenoofProducts() {
		String expText = "No. of Products";
		String actText = webTablenoofProducts.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webTableStatus() {
		String expText = "Status";
		String actText = webTableStatus.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webTableTotal() {
		String expText = "Total";
		String actText = webTableTotal.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webTableDateAdded() {
		String expText = "Date Added";
		String actText = webTableDateAdded.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.println(actText+" columns are displayed");
	}
	
	public void viewIcon() {
		viewIcon.click();
	}
	
	public void orderDetails() {
		String expText = "Order Details";
		String actText = orderDetails.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.println(actText+" page is displayed");
	}
	//Edit Account Page
	
	public void editAccount() {
		editAccount.click();
	}
	
	public void fName(String firstName) {
		fName.clear();
		fName.sendKeys(firstName);
	}
	
	public void lName(String lastName) {
		lName.clear();
		lName.sendKeys(lastName);
	}
	
	public void email(String inputemail) {
		email.clear();
		email.sendKeys(inputemail);
	}
	
	public void tPhone(String inputPhone) {
		tPhone.clear();
		tPhone.sendKeys(inputPhone);
	}
	
	public void submit() {
		submit.click();
	}
	
	public void acctsuccessMsg() {
		String expectedmsg = "Success";
		String actualmsg = acctsuccessMsg.getText();
		Assert.assertTrue(actualmsg.contains(expectedmsg));
	}
	
	//Password Change
	
	public void changePwd() {
		changePwd.click();
	}
	
	public void pwd(String newPwd) {
		pwd.sendKeys(newPwd);
	}
	
	public void pwdConfirm(String newpwdConfirm) {
		pwdConfirm.sendKeys(newpwdConfirm);
	}
	
	public void pwdsuccessMsg() {
		String expectedmsg = "Success";
		String actualmsg = pwdsuccessMsg.getText();
		Assert.assertTrue(actualmsg.contains(expectedmsg));
	}
	
}
