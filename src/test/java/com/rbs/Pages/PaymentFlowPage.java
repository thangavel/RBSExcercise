package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class PaymentFlowPage extends LoadableComponent<PaymentFlowPage>

{
	
	private WebDriver driver;
	int intSeconds = 60;
	
	public PaymentFlowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using=".standard-checkout")
	 public static WebElement btnProceedToCheckOut;
	
	@FindBy(how=How.CSS, using="button.button:nth-child(4)")
	 public static WebElement btnProceedToCheckOut_Address;
	
	
	
	@FindBy(how=How.CSS, using="#uniform-cgv")//.checkbox > label:nth-child(2) //#cgv
	 public static WebElement chkAgree;
	
	@FindBy(how=How.CSS, using="button.button:nth-child(4)")
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
	
	
	
	
	
	
	

	
	public void clickProceedtoCheckout()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut);
		btnProceedToCheckOut.click();
	}
	
	public void clickProceedtoCheckoutAfterDeliveryAddress()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut_Address);
		btnProceedToCheckOut_Address.click();
	}
	
	public void SelectAgreeTermsAndConditions()
	{
		BasePage.waitForElement(driver, intSeconds, chkAgree);
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		///executor.executeScript("arguments[0].click();", chkAgree);
		chkAgree.click();
		
	}
	
	
	
	public void clickProceedtoCheckoutForShipping()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckOut_Shipping);
		btnProceedToCheckOut_Shipping.click();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", btnProceedToCheckOut_Shipping);
	}
	
	
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
	
	public void clickConfirmMyOrder()
	{
		BasePage.waitForElement(driver, intSeconds, btnConfirmMyOrder);
		btnConfirmMyOrder.click();
	}
	
	
	public void verifyOrderConfirmationMessage()
	{
		BasePage.waitForElement(driver, intSeconds, txtOrderConfirmation);
		String msg = txtOrderConfirmation.getAttribute("innerText");
		if(msg.length() <=0) msg = txtOrderConfirmation.getAttribute("textContent");
		System.out.println("Order Confirmation ==> " + msg.trim());
		assertEquals(msg.contains("Your order on My Store is complete"), true);
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
