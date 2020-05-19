package com.training.pom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
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
	
	//i[@class='fa fa-user-o']
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
	
	//xpath="//i[@class='fa fa-eye']
	@FindBy(xpath="//i[@class='fa fa-eye']")
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
	
	@FindBy(xpath="//a[@title='Return']")
	private WebElement clickReturn;
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']")
	private WebElement verifyReturnPage;
	
	@FindBy(xpath="//fieldset[legend=\"Product Information\"]//div[@class=\"form-group required\"][3]//input[@value='1']")
	private WebElement selectReason;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
	private WebElement radioOpened;
	
	@FindBy(xpath="//textarea[@id='input-comment']")
	private WebElement faultReason;
	
	@FindBy(xpath="//input[@value=\"Submit\"]")
	private WebElement returnSubmit;
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']//p")
	private List<WebElement> returnSuccess;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement errMsg;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement adminuserName;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement adminPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminSubmit;
	
	@FindBy(xpath="//li[@id='menu-catalog']")
	private WebElement hoverCatalog;
	
	@FindBy(xpath="//li[@id='menu-catalog']//ul//li//a")
	private List<WebElement> verifycatalogLinks;
	
	@FindBy(xpath="//li[@id='menu-catalog']//ul//li//a[text()='Categories']")
	private WebElement clickCategory;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//thead//tr//td")
	private List<WebElement> webTableCategory;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//thead//tr//td[2]")
	private WebElement webtableCategoryName;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//thead//tr//td[3]")
	private WebElement webtableSortOrder;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//thead//tr//td[4]")
	private WebElement webtableAction;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement clickNew;

	@FindBy(xpath="//h3[contains(text(), ' Add Category')]")
	private WebElement verifyAddCategory;
	
	@FindBy(xpath="//input[@name='category_description[1][name]']")
	private WebElement addCategoryName;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement addDesc;
	
	@FindBy(xpath="//input[@name='category_description[1][meta_title]']")
	private WebElement addtagTitle;
	
	@FindBy(xpath="//textarea[@name='category_description[1][meta_description]']")
	private WebElement addTagDesc;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveCategory;
	
	@FindBy(xpath="//div[text()=' Success: You have modified categories!      ']")
	private WebElement verifysaveCategory;
	
	@FindBy(xpath="//i[@class='fa fa-pencil']")
	private WebElement clickEdit;
	
	@FindBy(xpath="//h3[contains(text(), ' Edit Category')]")
	private WebElement verifyEditCategory;
	
	@FindBy(xpath="//tbody//tr//td//input[@type='checkbox']")
	private WebElement selectCategory;
	
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement deleteCategory;
	
	@FindBy(xpath="//div[text()=\" Success: You have modified categories!      \"]")
	private WebElement verifyConfirmation;
	
	private WebDriver webDriver;
	
	//LoginPage
	
	public void hoverAccount() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverAccount).perform();
	}
	
	@FindBy(xpath="//li[@class='tb_link dropdown tb_menu_system_account_account tb_selected']//ul//li//a")
	private List<WebElement> accountLinks;
	
	public void accountLinks() {
		String[] expmsg = {"LOGIN / REGISTER", "MY ACCOUNT","MY ORDERS"};
		int linkCount = accountLinks.size();
		String actmsg1=accountLinks.get(1).getText();
		System.out.println(actmsg1);
		String actmsg2=accountLinks.get(2).getText();
		System.out.println(actmsg2);
		String actmsg3=accountLinks.get(3).getText();
		System.out.println(actmsg3);
		System.out.println(linkCount+" number of links are available under Account menu.");
		for(int i=0;i<linkCount;i++) {
			String actmsg = accountLinks.get(i).getText();
			Assert.assertTrue((actmsg).contains(expmsg[i]));
			System.out.print(actmsg+" , ");
		}
		System.out.print(" links are displayed under Account menu.");
		System.out.println();
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
	
	//Item Return
	
	public void clickReturn() {
		clickReturn.click();
	}
	
	public void verifyReturnPage() {
		String expectedmsg = "Please complete the form below to request an RMA number.";
		String actualmsg = verifyReturnPage.getText();
		Assert.assertTrue(actualmsg.contains(expectedmsg));
	}
	
	public void selectReason() {
		selectReason.click();
		Assert.assertTrue(selectReason.isSelected());
	}
	
	public boolean radioOpened() {
		radioOpened.click();
		return radioOpened.isSelected();
	}
	
	public void faultReason() {
		faultReason.click();
		faultReason.sendKeys("product is faulty");
	}
	
	public void returnSubmit() {
		returnSubmit.click();
	}
	
	public void returnSuccess() {
		String expectedmsg1 = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
		String expectedmsg2 = "You will be notified via e-mail as to the status of your request.";
		String actualmsg1 = returnSuccess.get(0).getText();
		String actualmsg2 = returnSuccess.get(1).getText();
		Assert.assertTrue(actualmsg1.contains(expectedmsg1));
		Assert.assertTrue(actualmsg2.contains(expectedmsg2));
	}
	
	//Invalid Login
	
	public void adminSubmit() {
		adminSubmit.click();
	}
	
	public void errMsg() {
		String expectedmsg = "No match";
		String actualmsg = errMsg.getText();
		System.out.println(actualmsg);
		Assert.assertTrue(actualmsg.contains(expectedmsg));
	}
	
	//AddCategory
	
	public void adminuserName(String userName) {
		adminuserName.clear();
		adminuserName.sendKeys(userName);
	}
	
	public void adminPassword(String pwd) {
		adminPassword.clear();
		adminPassword.sendKeys(pwd);
	}
	
	public void hoverCatalog() {
		Actions action = new Actions(driver);
		action.moveToElement(hoverCatalog).perform();
	}
	
	@FindBy(xpath = "//li[@id='menu-catalog']//ul//li//a[text()=\"Attributes\"]")
	private WebElement clickAttribute;
	
	public void clickAttribute() {
		clickAttribute.click();
	}
	
	public void verifycatalogLinks() {
		//String expmsg2 = "Categories";
		//String expmsg2 = "Products";
		//String expmsg3 = "Recurring Profiles";
		String[] expmsg = {"Categories", "Products","Recurring Profiles","Filters","Attributes","Attributes","Attribute Groups","Options","Manufacturers","Downloads","Reviews","Information"};
		int linkCount = verifycatalogLinks.size();
		System.out.println(linkCount+" number of links are available under Catalog section.");
		for(int i=0;i<linkCount;i++) {
			String actmsg = verifycatalogLinks.get(i).getText();
			Assert.assertTrue((actmsg).contains(expmsg[i]));
			System.out.print(actmsg+" , ");
		}
		System.out.print(" links are displayed under Catalog menu.");
		System.out.println();
		//String actmsg1 = verifycatalogLinks.get(0).getText();
		//String actmsg2 = verifycatalogLinks.get(1).getText();
		//String actmsg3 = verifycatalogLinks.get(2).getText();
		//Assert.assertTrue((actmsg1).contains(expmsg1));
		//Assert.assertTrue((actmsg2).contains(expmsg2));
		//Assert.assertTrue((actmsg3).contains(expmsg3));
		//System.out.println(actmsg1+" , "+actmsg2+" , "+actmsg3+" links are displayed under Catalog menu.");
	}
	
	public void clickCategory() {
		clickCategory.click();
	}
	
	public void webTableCategory() {
		int noofRows = webTableCategory.size();
		System.out.println("Number of columns in the page are : "+noofRows);
	}
	
	public void webtableCategoryName() {
		String expText = "Category";
		String actText = webtableCategoryName.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}
	
	public void webtableSortOrder() {
		String expText = "Sort";
		String actText = webtableSortOrder.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" , ");
	}

	public void webtableAction() {
		String expText = "Action";
		String actText = webtableAction.getText();
		Assert.assertTrue(actText.contains(expText));	
		System.out.print(actText+" columns are displayed.");
}

	public void clickNew() {
		clickNew.click();
	}
	
	public void verifyAddCategory() {
		String expmsg = "Category";
		String actmsg = verifyAddCategory.getText();
		Assert.assertTrue(actmsg.contains(expmsg));
		System.out.println(actmsg + "page is displayed.");
	}
	
	public void addCategoryName(String categoryName) {
		addCategoryName.sendKeys(categoryName);
	}
	
	public void addDesc(String Desc) {
		addDesc.sendKeys(Desc);
	}
	
	public void addtagTitle(String tagTitle) {
		addtagTitle.clear();
		addtagTitle.sendKeys(tagTitle);
	}
	
	public void addTagDesc(String tagDesc) {
		addTagDesc.clear();
		addTagDesc.sendKeys(tagDesc);
	}
	
	public void saveCategory() {
		saveCategory.click();
	}
	
	public void verifysaveCategory() {
		String expmsg = "Success";
		String actmsg = verifysaveCategory.getText();
		Assert.assertTrue(actmsg.contains(expmsg));
		System.out.println(actmsg+"\t"+"-->Category modified successfully in this test case.");
	}
	
	//Edit Category
	
	public void clickEdit() {
		clickEdit.click();
	}
	
	public void verifyEditCategory() {
		String expmsg = "Category";
		String actmsg = verifyEditCategory.getText();
		Assert.assertTrue(actmsg.contains(expmsg));
		System.out.println(actmsg+"\t"+"--> page is displayed.");
	}
	
	//Delete Category
	
	public void selectCategory() {
		selectCategory.click();
	}
	
	public void deleteCategory() throws InterruptedException {
		deleteCategory.click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		alert.accept();
	}
	
	public void verifyConfirmation() {
		String expmsg = "Success";
		String actmsg = verifyConfirmation.getText();
		Assert.assertTrue(actmsg.contains(expmsg));
		System.out.println(actmsg+"\t"+"-->Category deleted successfully in this test case.");
	}
}
