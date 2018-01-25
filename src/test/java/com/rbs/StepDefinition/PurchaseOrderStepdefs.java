package com.rbs.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.rbs.CucumberTestNG.TestData;
import com.rbs.Pages.HomePage;
import com.rbs.Pages.LoginPage;
import com.rbs.Pages.OrderHistoryPage;
import com.rbs.Pages.PaymentFlowPage;
import com.rbs.Pages.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PurchaseOrderStepdefs 
{
	
	WebDriver driver;
	//String strURL = "http://automationpractice.com/index.php";
	//BasePage basePage;
	HomePage homePage ;
	LoginPage loginPage ;
	ProductPage productPage;
	PaymentFlowPage paymentFlowPage;
	OrderHistoryPage orderHistoryPage;
	//AccountDetailsPage accountDetailsPage;
	
	@Before
    public void initializeTest()
 	{
		//System.setProperty("webdriver.gecko.driver", "/home/user/bin");
		//basePage = new BasePage(driver);
		if(TestData.ConfigDetails.Browser.equals("firefox"))
			launchFireFoxAndOpenURL();
		else if(TestData.ConfigDetails.Browser.equals("chrome"))
			launchChromeAndOpenURL();
		//driver = BasePage.driver;
		homePage = new HomePage(TestData.driver);
		loginPage = new LoginPage(TestData.driver);
		productPage = new ProductPage(TestData.driver);
		paymentFlowPage = new PaymentFlowPage(TestData.driver);
		orderHistoryPage = new OrderHistoryPage(TestData.driver);
		//accountDetailsPage = new AccountDetailsPage(TestData.driver);
	}


	private void launchChromeAndOpenURL() 
	{
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(TestData.ConfigDetails.getURL());
		driver.manage().window().maximize();
		TestData.driver = driver;
	}
    
	private void launchFireFoxAndOpenURL() {
		System.out.println("Browser Name ==>" + System.getProperty("browser"));
		System.out.println("URL ==>" + System.getProperty("browser"));
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver-64.exe");
		driver = new FirefoxDriver();
		driver.get(TestData.ConfigDetails.getURL());
		driver.manage().window().maximize();
		TestData.driver = driver;
	}
    
 	
	@After
    public void CleanTest()
 	{
		if (driver != null)
			driver.quit();
 	}
	 
	@Given("^The user logged into the application$")
	public void The_user_logged_into_the_application()
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		homePage.navigateToLoginPage();
		loginPage.loginIntoApplication();
	}

	@When("^navigate to the TShirts tab, select a TShirt$")
	public void navigate_to_the_TShirts_tab_select_a_TShirt()
	{
	    homePage.navigateToTShirtsTab();
	    productPage.findProductAndSelect(TestData.Product.getProductName());
	}

	@When("^He enter quantiy, size, proceed checkout$")
	public void he_enter_quantiy_size_proceed_checkout()
	{
	    productPage.enterQuantity(TestData.Product.getQuantity());
	    productPage.selectSize(TestData.Product.getSize());
	    productPage.selectColour(TestData.Product.getColor());
	    productPage.clickExclusiveAddToCart();
	    productPage.clickProceedtoCheckout();//Product page
	    
	    paymentFlowPage.clickProceedtoCheckout();//Payment PAge
	    
	}
	
	@When("^he select billing address$")
	public void he_select_billing_address()
	{
		paymentFlowPage.clickProceedtoCheckoutAfterDeliveryAddress();
	}

	@When("^he select the Payment Type$")
	public void he_select_the_Cheque()
	{
		paymentFlowPage.SelectAgreeTermsAndConditions();
		paymentFlowPage.clickProceedtoCheckoutForShipping();		
	}

	@When("^proceed to checkout$")
	public void proceed_to_checkout()
	{
		paymentFlowPage.selectPaymentMethod(TestData.Payment.getOrderReference());
	}
	
	@When("^he confirm the order$")
	public void he_confirm_the_order()
	{
		paymentFlowPage.clickConfirmMyOrder();
		
	}

	@Then("^the order should get succeed$")
	public void the_order_should_get_succeed()
	{
		paymentFlowPage.verifyOrderConfirmationMessage();
	}

	@Then("^the user can find the latest order listed in the Order History$")
	public void the_user_can_find_the_latest_order_listed_in_the_Order_History()
	{
		orderHistoryPage.navigateBackToOrderHistory();
		orderHistoryPage.ViewOrderDetails();
		orderHistoryPage.VerifyProductDetailsAndOrder();
	}
}
