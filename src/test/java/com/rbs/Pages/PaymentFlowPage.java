package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.rbs.CucumberTestNG.TestData;

public class PaymentFlowPage extends LoadableComponent<PaymentFlowPage>

{
	
	private WebDriver driver;
	int intSeconds = 60;
	
	/****************************************************************************************
	 * MethodName 		: PaymentFlowPage
	 * Arguments 		: NONE
	 * Description		: Constructor to initialise the web driver and page objects
	 *
	 *****************************************************************************************
	 */
	public PaymentFlowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using=".standard-checkout")
	 public static WebElement btnProceedToCheckOut;
	
	@FindBy(how=How.CSS, using="button[name='processAddress']")//a[class*='standard-checkout']>span")//button.button:nth-child(4)")
	 public static WebElement btnProceedToCheckOut_Address;
	
	
	
	@FindBy(how=How.CSS, using="#uniform-cgv")//.checkbox > label:nth-child(2) //#cgv
	 public static WebElement chkAgree;
	
	@FindBy(how=How.CSS, using="button[name='processCarrier']")//"button.button:nth-child(4)")
	 public static WebElement btnProceedToCheckOut_Shipping;
	
	@FindBy(how=How.CSS, using=".cheque")
	 public static WebElement lnkPayByCheque;
	
	@FindBy(how=How.CSS, using=".bankwire")
	 public static WebElement lnkPayByBankWire;
	
	@FindBy(how=How.CSS, using="button.button-medium")
	 public static WebElement btnConfirmMyOrder;
	
	//Order confirmation
	@FindBy(how=How.CSS, using=".box")
	 public static WebElement txtOrderConfirmation;
	//Your order on My Store is complete
	
	
	/****************************************************************************************
	 * MethodName 		: clickProceedtoCheckout
	 * Arguments 		: NONE
	 * Description		: Method to click Procedd to checkout button
	 *
	 *****************************************************************************************/ 
	public void clickProceedtoCheckout()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut);
		btnProceedToCheckOut.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: clickProceedtoCheckoutAfterDeliveryAddress
	 * Arguments 		: NONE
	 * Description		: Method to click proceed to check out after entering addresses
	 *
	 *****************************************************************************************/
	public void clickProceedtoCheckoutAfterDeliveryAddress()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut_Address);
		btnProceedToCheckOut_Address.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: SelectAgreeTermsAndConditions
	 * Arguments 		: NONE
	 * Description		: Method to agree the terms and conditions by selecting check box
	 *
	 *****************************************************************************************/
	public void SelectAgreeTermsAndConditions()
	{
		BasePage.waitForElement(driver, intSeconds, chkAgree);
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		///executor.executeScript("arguments[0].click();", chkAgree);
		chkAgree.click();
		
	}
	
	
	/****************************************************************************************
	 * MethodName 		: clickProceedtoCheckoutForShipping
	 * Arguments 		: NONE
	 * Description		: Method to click proceed to check out button after entering shipping address details
	 *
	 *****************************************************************************************/
	public void clickProceedtoCheckoutForShipping()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut_Shipping);
		btnProceedToCheckOut_Shipping.click();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", btnProceedToCheckOut_Shipping);
	}
	
	/****************************************************************************************
	 * MethodName 		: selectPaymentMethod
	 * Arguments 		: NONE
	 * Description		: Method to select differrent payment type during payment process
	 *
	 *****************************************************************************************/
	public void selectPaymentMethod(String pMethod)
	{
		if(pMethod.equals("Cheque"))
		{
			BasePage.waitForElement(driver, intSeconds, lnkPayByCheque);
			lnkPayByCheque.click();
		}
		else
		{
			BasePage.waitForElement(driver, intSeconds, lnkPayByBankWire);
			lnkPayByBankWire.click();
		}
	}
	
	/****************************************************************************************
	 * MethodName 		: clickConfirmMyOrder
	 * Arguments 		: NONE
	 * Description		: Method to click on the confirm order button
	 *
	 *****************************************************************************************/
	public void clickConfirmMyOrder()
	{
		BasePage.waitForElement(driver, intSeconds, btnConfirmMyOrder);
		btnConfirmMyOrder.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: verifyOrderConfirmationMessage
	 * Arguments 		: NONE
	 * Description		: Method to click verify the order confirmation message
	 *
	 *****************************************************************************************/
	public void verifyOrderConfirmationMessage()
	{
		BasePage.waitForElement(driver, intSeconds, txtOrderConfirmation);
		String msg = txtOrderConfirmation.getAttribute("innerText");
		if(msg.length() <=0) msg = txtOrderConfirmation.getAttribute("textContent");
		System.out.println("Order Confirmation ==> " + msg.trim());
		assertEquals(msg.contains("Your order on My Store is complete"), true);
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
		BasePage.isPageLoaded(driver, "My Store");
		
	}

}
