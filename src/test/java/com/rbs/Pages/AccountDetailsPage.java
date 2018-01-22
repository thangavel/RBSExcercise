package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.rbs.CucumberTestNG.TestData;




/**
 * @author Thangavel
 *
 *Page object for Account information page.
 */

public class AccountDetailsPage extends LoadableComponent<AccountDetailsPage>// extends BasePage
{
	private WebDriver driver;
	int intSeconds = 60;
	//URL remoteURL ;
	public AccountDetailsPage()
	{
		//this.driver=super(driver);
	}
	
	public AccountDetailsPage(WebDriver driver)
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
//		
//		 //super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.CSS, using="div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(1)")
	 public static WebElement lnkMyOrderHistoryAndDetails;
	
	@FindBy(how=How.CSS, using="div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(2)")
	 public static WebElement MyCreditSlips;
	
	@FindBy(how=How.CSS, using="div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(3)")
	 public static WebElement MyAddresses;
	
	@FindBy(how=How.CSS, using="div.col-sm-6:nth-child(1) > ul:nth-child(1) > li:nth-child(4)")
	 public static WebElement lnkMyPersonalInformation;
	
	@FindBy(how=How.CSS, using="#firstname")
	 public static WebElement inpFirstName;
	
	@FindBy(how=How.CSS, using="#old_passwd")
	 public static WebElement inpOldPassword;
	
	@FindBy(how=How.CSS, using="button.btn:nth-child(1)")
	 public static WebElement btnSave;
	
	@FindBy(how=How.CSS, using=".alert")
	 public static WebElement txtAlertMessage;
	
	@FindBy(how=How.CSS, using=".account")
	 public static WebElement txtAccountName;
	
	@FindBy(how=How.CSS, using=".footer_links > li:nth-child(1) > a:nth-child(1)")
	 public static WebElement btnBackToYourAccount;
	
	
	
	
	/****************************************************************************************
	 * MethodName 		: navigateToMyOrderhistoryAndDetailsPage
	 * Arguments 		: 0 
	 * Description		: To Navigate to Order History page from Account page
	 *
	 *****************************************************************************************
	 */
	
	public void navigateToMyOrderhistoryAndDetailsPage()
	{
		BasePage.waitForElementPresent(driver, intSeconds, lnkMyOrderHistoryAndDetails, "Verify lnkMyOrderHistoryAndDetails element is present");
		lnkMyOrderHistoryAndDetails.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: navigateToMyCreditSlips
	 * Arguments 		: 0 
	 * Description		: To Navigate to Credit Slips page from Account page
	 *
	 *****************************************************************************************
	 */
	public void navigateToMyCreditSlips()
	{
		BasePage.waitForElementPresent(driver, intSeconds, MyCreditSlips, "Verify MyCreditSlips element is present");
		MyCreditSlips.click();
	}
	
	
	public void navigateToMyAddresses()
	{
		BasePage.waitForElementPresent(driver, intSeconds, MyAddresses, "Verify MyAddresses element is present");
		MyAddresses.click();
	}
	
	
	public void navigateToMyAccountInformation()
	{
		BasePage.waitForElementPresent(driver, intSeconds, lnkMyPersonalInformation, "Verify lnkMyPersonalInformation element is present");
		lnkMyPersonalInformation.click();
	}
	
	public void navigateBackToMyAccount()
	{
		BasePage.waitForElementPresent(driver, intSeconds, btnBackToYourAccount, "Verify btnBackToYourAccount element is present");
		btnBackToYourAccount.click();
	}
	
	public void updateFirstName(String pFirstName)
	{
		BasePage.waitForElementPresent(driver, intSeconds, inpFirstName, "Verify inpFirstName element is present");
		inpFirstName.clear();
		inpFirstName.sendKeys( pFirstName);
	}
	
	
	
	public void revertFirstName(String pFirstName)
	{
		BasePage.waitForElementPresent(driver, intSeconds, inpFirstName, "Verify inpFirstName element is present");
		inpFirstName.clear();
		inpFirstName.sendKeys( pFirstName);
	}
	
	public void enterOldPassword(String pOldPassword)
	{
		BasePage.waitForElement(driver, intSeconds, inpOldPassword);
		inpOldPassword.clear();
		inpOldPassword.sendKeys( pOldPassword);
	}
	
	public void clickSaveAccountInfo()
	{
		BasePage.waitForElement(driver, intSeconds, btnSave);//, "Verify btnSave element is present");
		btnSave.click();
	}
	
	public void updateFirstNameAndSave(String pFirstName)
	{
		updateFirstName(pFirstName);
		enterOldPassword(TestData.Login.getPassword());
		clickSaveAccountInfo();
	}
	
	public void revertFirstNameAndSave()
	{
		updateFirstName(TestData.AccountInfo.getOriginalFirstName());
		enterOldPassword(TestData.Login.getPassword());
		clickSaveAccountInfo();
	}
	
	public void verifyAccountInfoUpdated()
	{
		BasePage.waitForElement(driver, intSeconds, txtAccountName);//, "Verify txtAccountName element is present");
		String strAccountName = txtAccountName.getAttribute("innerText");
		
		System.out.println("Account name ==> " + strAccountName);
		boolean isAccountUpdated = false;
		isAccountUpdated = strAccountName.toLowerCase().contains(TestData.AccountInfo.getUpdatedFirstName().toLowerCase());
		
		
		assertEquals(isAccountUpdated, true);
	}
	
	
	
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
}
