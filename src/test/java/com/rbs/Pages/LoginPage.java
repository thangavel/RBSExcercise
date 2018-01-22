package com.rbs.Pages;

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
	
	
	
	public LoginPage(WebDriver driver)
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
//		
//		 //super(driver);
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
	
	public void enterPassword(String pPassWd)
	{
		inpPassWd.sendKeys(pPassWd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void loginIntoApplication()
	{
		enterEmail(TestData.Login.getUserName());//Test data is defined in the TestData.Class
		
		enterPassword(TestData.Login.getPassword());//Test data is defined in the TestData.Class
		
		clickSubmit();
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
