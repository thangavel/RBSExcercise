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
	
	/****************************************************************************************
	 * MethodName 		: OrderHistoryPage
	 * Arguments 		: NONE
	 * Description		: Constructor to initialise the page objects and driver
	 *
	 *****************************************************************************************
	 */
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
	
	@FindBy(how=How.CSS, using="#order-list > tbody > tr.first_item")
	 public static WebElement trFirstRowOfOrderList;//Latest Order details
	
	@FindBy(how=How.CSS, using="tr.first_item a[href*='order-detail'][class*='default']>span")
	 public static WebElement btnViewDetails;//Latest Order details
	
	@FindBy(how=How.CSS, using="#order-detail-content > table > tbody > tr > td.bold > label")
	 public static WebElement tblProductDetails;//get product details Name, color, size
	
	@FindBy(how=How.CSS, using=" tr.first_item a.color-myaccount")
	 public static WebElement tdOrderReference;
	
	
	
	/****************************************************************************************
	 * MethodName 		: navigateBackToOrderHistory
	 * Arguments 		: NONE
	 * Description		: Method to navigate back to Order history from Order confirmation page
	 *
	 *****************************************************************************************
	 */
	public void navigateBackToOrderHistory()
	{
		BasePage.waitForElement(driver, intSeconds, btnBackToOrder);
		btnBackToOrder.click();
	}

	/****************************************************************************************
	 * MethodName 		: getOrderList
	 * Arguments 		: NONE
	 * Description		: Method to get the number of orders from the order history page and return as a list of web elements
	 *
	 *****************************************************************************************
	 */
	public List<WebElement> getOrderList()
	{
		//List<WebElement> lstProducts = lstProductListGrid.findElements((By.tagName("a")));//("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));
		BasePage.waitForElement(driver, intSeconds, tblOrderHistory);
		List<WebElement> lstOrders = tblOrderHistory.findElements((By.tagName("tr")));
		return lstOrders;
		//lnkPTShirt.toString();
	}
	
	/****************************************************************************************
	 * MethodName 		: getOrdersCount
	 * Arguments 		: NONE
	 * Description		: Method to return the total number of orders in the order history page
	 *
	 *****************************************************************************************
	 */
	public int getOrdersCount()
	{
		return (getOrderList().size()-1); //excluding header row 
	}

	/****************************************************************************************
	 * MethodName 		: getLatestOrderDetails
	 * Arguments 		: NONE
	 * Description		: Method to return the order details from the latest order row
	 *
	 *****************************************************************************************
	 */
	public List<WebElement> getLatestOrderDetails()
	{
		//List<WebElement> lstProducts = lstProductListGrid.findElements((By.tagName("a")));//("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));
		BasePage.waitForElement(driver, intSeconds, trFirstRowOfOrderList);
		//BasePage.waitForElementPresent(driver, intSeconds, trFirstRowOfOrderList, "Verify trFirstRowOfOrderList element is present");
		List<WebElement> lstOrderDetails = trFirstRowOfOrderList.findElements((By.tagName("td")));
		return lstOrderDetails;
		//lnkPTShirt.toString();
	}
	
	/****************************************************************************************
	 * MethodName 		: ViewOrderDetails
	 * Arguments 		: NONE
	 * Description		: Method to view the Latest order details by clicking the View Details button
	 *
	 *****************************************************************************************
	 */
	public void ViewOrderDetails()
	{
		BasePage.waitForElement(driver, intSeconds, btnViewDetails);
		btnViewDetails.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: VerifyProductDetailsAndOrder
	 * Arguments 		: NONE
	 * Description		: Method to verify the product details of the confirmed order
	 *
	 *****************************************************************************************
	 */
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
