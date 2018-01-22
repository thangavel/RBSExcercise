package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.rbs.CucumberTestNG.TestData;

public class OrderHistoryPage extends LoadableComponent<OrderHistoryPage>

{
	
	private WebDriver driver;
	int intSeconds = 60;
	
	public OrderHistoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Order History
		@FindBy(how=How.CSS, using=".button-exclusive")
		 public static WebElement btnBackToOrder;
		
		@FindBy(how=How.CSS, using="#order-list")
		 public static WebElement tblOrderHistory;
		
		@FindBy(how=How.CSS, using="#order-list > tbody:nth-child(2) > tr:nth-child(1)")
		 public static WebElement trFirstRowOfOrderList;//Latest Order details
		
		@FindBy(how=How.CSS, using="#order-list > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7) > a:nth-child(1)")
		 public static WebElement btnViewDetails;//Latest Order details
	
		@FindBy(how=How.CSS, using="#order-detail-content > table:nth-child(1) > tbody:nth-child(3)")
		 public static WebElement tblProductDetails;//get product details Name, color, size
		
		@FindBy(how=How.CSS, using="#order-list > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(2)")
		 public static WebElement tdOrderReference;
		
		
		
		//#order-detail-content > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > label:nth-child(1)
		//#order-detail-content > table:nth-child(1) > tbody:nth-child(3)
		public void navigateBackToOrderHistory()
		{
			BasePage.waitForElement(driver, intSeconds, btnBackToOrder);
			btnBackToOrder.click();
		}
	
	public List<WebElement> getOrderList()
	{
		//List<WebElement> lstProducts = lstProductListGrid.findElements((By.tagName("a")));//("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));

		BasePage.waitForElement(driver, intSeconds, tblOrderHistory);
		List<WebElement> lstOrders = tblOrderHistory.findElements((By.tagName("tr")));
		return lstOrders;
		//lnkPTShirt.toString();
	}
	
	public int getOrdersCount()
	{
		return (getOrderList().size()-1); //excluding header row 
	}

	public List<WebElement> getLatestOrderDetails()
	{
		//List<WebElement> lstProducts = lstProductListGrid.findElements((By.tagName("a")));//("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));
		BasePage.waitForElement(driver, intSeconds, trFirstRowOfOrderList);
		//BasePage.waitForElementPresent(driver, intSeconds, trFirstRowOfOrderList, "Verify trFirstRowOfOrderList element is present");
		List<WebElement> lstOrderDetails = trFirstRowOfOrderList.findElements((By.tagName("td")));
		return lstOrderDetails;
		//lnkPTShirt.toString();
	}
	
	public void ViewOrderDetails()
	{
		BasePage.waitForElement(driver, intSeconds, btnViewDetails);
		btnViewDetails.click();
	}
	
	public void VerifyProductDetailsAndOrder()
	{
		BasePage.waitForElement(driver, intSeconds, tblProductDetails);
		//BasePage.waitForElementPresent(driver, intSeconds, tblProductDetails, "Verify tblProductDetails element is present");
		String strDetails = tblProductDetails.getAttribute("innerText");
		boolean IsOrderDetailsMatching=false;
		IsOrderDetailsMatching = strDetails.contains(TestData.Product.getProductName()) && 
				strDetails.contains(TestData.Product.getColor()) && 
				strDetails.contains(TestData.Product.getSize());
		System.out.println("Product Details - Order: ==> " + strDetails);
		System.out.println("ORDER REFERENCE NUMBER: ==> " + tdOrderReference.getAttribute("innerText"));
		TestData.Payment.setOrderReference(tdOrderReference.getAttribute("innerText"));
		assertEquals(IsOrderDetailsMatching, true);
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
