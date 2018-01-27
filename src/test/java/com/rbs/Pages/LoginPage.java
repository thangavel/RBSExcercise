package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.rbs.CucumberTestNG.TestData;

public class LoginPage extends LoadableComponent<LoginPage>
{
	private WebDriver driver;
	int intSeconds = 60;
	
	
	/****************************************************************************************
	 * MethodName 		: LoginPage
	 * Arguments 		: NONE
	 * Description		: Constructor to initialize the driver object
	 *
	 *****************************************************************************************
	 */
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="#email")
	 public static WebElement inpEmail;

	@FindBy(how=How.CSS, using="#passwd")
	 public static WebElement inpPassWd;

	@FindBy(how=How.CSS, using="#SubmitLogin")
	 public static WebElement btnSubmit;

	public void enterEmail(String pUserName)
	{
		BasePage.waitForElement(driver, intSeconds, inpEmail);
		inpEmail.sendKeys(pUserName);
	}
	
	/****************************************************************************************
	 * MethodName 		: enterPassword
	 * Arguments 		: String pPassWd
	 * Description		: Method to enter password in the login page
	 *
	 *****************************************************************************************
	 */
	public void enterPassword(String pPassWd)
	{
		inpPassWd.sendKeys(pPassWd);
	}
	
	/****************************************************************************************
	 * MethodName 		: clickSubmit
	 * Arguments 		: NONE
	 * Description		: Method to click submit button in the login page
	 *
	 *****************************************************************************************
	 */
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: loginIntoApplication
	 * Arguments 		: NONE
	 * Description		: Method to enter username, password and click submit button in the login page
	 *
	 *****************************************************************************************
	 */
	public void loginIntoApplication()
	{
		enterEmail(TestData.Login.getUserName());//Test data is defined in the TestData.Class
		
		enterPassword(TestData.Login.getPassword());//Test data is defined in the TestData.Class
		
		clickSubmit();
	}

	@Override
	protected void isLoaded() throws Error 
	{
		assertEquals(
	            TestData.isPageLoaded,true,
	            "Page is not loaded/ Title is mismatching");
		
	}

	@Override
	protected void load() 
	{
		BasePage.isPageLoaded(driver, "Login - My Store");
		
	}
}
