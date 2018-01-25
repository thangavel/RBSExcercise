package com.rbs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

//import com.rbs.CucumberTestNG.WebDriverFactory;

public class HomePage extends LoadableComponent<HomePage>// extends BasePage
{
	private WebDriver driver;
	int intSeconds = 60;
	//URL remoteURL ;
	public HomePage()
	{
		//this.driver=super(driver);
	}
	
	public HomePage(WebDriver driver)
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
//		
//		 //super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="div.header_user_info a.login")
	 public static WebElement lnk_SignIn;
	
	@FindBy(how=How.CSS, using="ul[class*='enabled']>li>a[title='Women'][href*='id_category']")
	 public static WebElement lnk_Women;
	@FindBy(how=How.CSS, using="ul[class*='enabled']>li>a[title='Dresses'][href*='id_category']")
	 public static WebElement lnk_Dresses;
	@FindBy(how=How.CSS, using="ul[class*='enabled']>li>a[title='T-shirts'][href*='id_category']") 
	 public static WebElement lnk_TShirts;
	
	

	/****************************************************************************************
	 * MethodName 		: navigateToLoginPage
	 * Arguments 		: NONE
	 * Description		: to navigate to Login page from Landing page
	 *
	 *****************************************************************************************
	 */
	public void navigateToLoginPage()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_SignIn);
		lnk_SignIn.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: navigateToWomenTab
	 * Arguments 		: NONE
	 * Description		: to navigate to women tab from Account page
	 *
	 *****************************************************************************************
	 */
	public void navigateToWomenTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_Women);
		lnk_Women.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: navigateToDressesTab
	 * Arguments 		: NONE
	 * Description		: to navigate to Dresses tab from Account page
	 *
	 *****************************************************************************************
	 */
	public void navigateToDressesTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_Dresses);
		lnk_Dresses.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: navigateToTShirtsTab
	 * Arguments 		: NONE
	 * Description		: to navigate to TShirts tab from Account page
	 *
	 *****************************************************************************************
	 */
	public void navigateToTShirtsTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_TShirts);
		lnk_TShirts.click();
	}

	//TODO
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
