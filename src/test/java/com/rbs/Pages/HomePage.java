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
	
	@FindBy(how=How.CSS, using=".sf-menu > li:nth-child(1)")
	 public static WebElement lnk_Women;
	@FindBy(how=How.CSS, using=".sf-menu > li:nth-child(2)")
	 public static WebElement lnk_Dresses;
	@FindBy(how=How.CSS, using=".sf-menu > li:nth-child(3)") 
	 public static WebElement lnk_TShirts;
	
	//.sf-menu > li:nth-child(3) > a:nth-child(1)
	//div[.//span[contains(text(), 'Today')] 
	 
	public void navigateToLoginPage()
	{
		//WebElement eleSignIn = webDriver.findElement(lnk_SignIn);
		//BasePage.waitForElementPresent(driver, intSeconds, lnk_SignIn, "Verify element is present");
//		new WebDriverWait(driver, intSeconds)
//        .until(ExpectedConditions.visibilityOf(lnk_SignIn));
		BasePage.waitForElement(driver, intSeconds, lnk_SignIn);
		lnk_SignIn.click();
	}
	
	public void navigateToWomenTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_Women);
		lnk_Women.click();
	}
	
	public void navigateToDressesTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_Dresses);
		lnk_Dresses.click();
	}
	
	public void navigateToTShirtsTab()
	{
		BasePage.waitForElement(driver, intSeconds, lnk_TShirts);
		lnk_TShirts.click();
	}

	public void LaunchBrowser() 
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
		
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
