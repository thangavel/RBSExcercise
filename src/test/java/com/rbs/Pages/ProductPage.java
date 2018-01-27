package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.rbs.CucumberTestNG.TestData;

public class ProductPage extends LoadableComponent<ProductPage>
{
	private WebDriver driver;
	int intSeconds = 60;
	
	/****************************************************************************************
	 * MethodName 		: ProductPage
	 * Arguments 		: WebDriver driver
	 * Description		: constructor to assign webdriver and initiate page objects
	 *
	 *****************************************************************************************/ 
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using=".product_list")
	 public static WebElement lstProductListGrid;
	
	@FindBy(how=How.XPATH, using="//a[contains(@title, 'Faded Short Sleeve T-shirts')]")
	 public static WebElement lnkPTShirt;
	
	@FindBy(how=How.CSS, using="#quantity_wanted")
	 public static WebElement inpQntyWanted;
	
	@FindBy(how=How.CSS, using="#group_1")
	 public static WebElement selSize;
	
	@FindBy(how=How.CSS, using="#uniform-group_1")
	 public static WebElement divSize;
	
	@FindBy(how=How.CSS, using="a[name='Orange']")//#color_to_pick_list > li:nth-child(1)")
	 public static WebElement lnkColorOrange;
	
	@FindBy(how=How.CSS, using="a[name='Blue']")//"#color_to_pick_list > li:nth-child(2)")
	 public static WebElement lnkColorBlue;//#color_to_pick_list > li:nth-child(2)
	
	
	
	@FindBy(how=How.CSS, using="button.exclusive")
	 public static WebElement btnExclusiveAddToCart;
	
	
	@FindBy(how=How.CSS, using=".continue")
	 public static WebElement btnContinueShopping;
	
	@FindBy(how=How.CSS, using="a[class='btn btn-default button button-medium']>span")//using="a.btn:nth-child(2)")
	 public static WebElement btnProceedToCheckout;
	
	
	 
	 
	/****************************************************************************************
	 * MethodName 		: getProductsFromGrid
	 * Arguments 		: NONE
	 * Description		: Method to get the available products from the list.
	 *
	 *****************************************************************************************/ 
	public List<WebElement> getProductsFromGrid()
	{
		//List<WebElement> lstProducts = lstProductListGrid.findElements((By.tagName("a")));//("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));

		BasePage.waitForElementPresent(driver, intSeconds, lstProductListGrid, "Verify element is present");
		List<WebElement> lstProducts = lstProductListGrid.findElements((By.xpath("//a[contains(@title, 'Faded Short Sleeve T-shirts')]")));
//		
		//		for	(int i=0;i<lstProducts.size();i++)
//		{
//			if()
//		}
		return lstProducts;
		//lnkPTShirt.toString();
	}
	
	/****************************************************************************************
	 * MethodName 		: findProductAndSelect
	 * Arguments 		: String pProductName
	 * Description		: Method to to select the product to place order
	 *
	 *****************************************************************************************/ 
	public void findProductAndSelect(String pProductName)
	{
		List<WebElement> lstProducts = getProductsFromGrid();
		WebElement tmpElement = null;
		if(lstProducts.size()>0)
		{
			for	(int i=0;i<lstProducts.size();i++)
				{
					if(lstProducts.get(i).getAttribute("title").equals(pProductName))
					{
						System.out.println("TITLE ==> " + lstProducts.get(i).getAttribute("title"));
						tmpElement = lstProducts.get(i);
						break;
					}
				}
		}
		else
		{
			Assert.fail("No PRoducts Found in the name of " + pProductName);
		}
		if(tmpElement!=null) 
			{
				//tmpElement.submit();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", tmpElement);
			}
		
	}
	
	/****************************************************************************************
	 * MethodName 		: enterQuantity
	 * Arguments 		: String pQuantity
	 * Description		: Method to enter the quantity of the TShirts
	 *
	 *****************************************************************************************/ 
	public void enterQuantity(String pQuantity) 
	{
		BasePage.waitForElement(driver, intSeconds, inpQntyWanted);
		//BasePage.waitForElementPresent(driver, intSeconds, inpQntyWanted, "Verify  inpQntyWanted element is present");
		inpQntyWanted.clear();
		inpQntyWanted.sendKeys(pQuantity);
		
	}
	/****************************************************************************************
	 * MethodName 		: selectSize
	 * Arguments 		: String pSize
	 * Description		: Method to select the size of the TSHirt
	 *
	 *****************************************************************************************/ 
	public void selectSize(String pSize) 
	{
		BasePage.waitForElement(driver, intSeconds, divSize);
		//BasePage.waitForElementPresent(driver, intSeconds, divSize, "Verify  selSize element is present");
		Select Size = new Select(selSize);
		if(pSize.equals("S"))
		{
			Size.selectByIndex(0);
		}else if(pSize.equals("M"))
		{
			Size.selectByIndex(1);
			
		}else
		{
			Size.selectByIndex(2);	
			System.out.println("Size ==> selected is ==> " + pSize);
		}
//		//Size.selectByValue(pSize);
//		divSize.click();
//		//selSize.click();
//		try {
//			driver.wait( 2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		divSize.sendKeys(pSize);
		
		
	}
	
	/****************************************************************************************
	 * MethodName 		: selectColour
	 * Arguments 		: String pColour
	 * Description		: Method to choose TShirt colour
	 *
	 *****************************************************************************************/ 
	public void selectColour(String pColour) 
	{
		if(pColour.equals("Blue"))
		{
			BasePage.waitForElement(driver, intSeconds, lnkColorBlue);
			lnkColorBlue.click();
		}
		else
		{
			BasePage.waitForElement(driver, intSeconds, lnkColorOrange);
			lnkColorOrange.click();
		}
			
		
	}
	
	/****************************************************************************************
	 * MethodName 		: clickExclusiveAddToCart
	 * Arguments 		: NONE
	 * Description		: Method to click Addto Cart button
	 *
	 *****************************************************************************************/ 
	public void clickExclusiveAddToCart()
	{
		BasePage.waitForElement(driver, intSeconds, btnExclusiveAddToCart);
		btnExclusiveAddToCart.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: clickContinueShoppingButton
	 * Arguments 		: NONE
	 * Description		: Method to click continue shopping button
	 *
	 *****************************************************************************************/ 
	public void clickContinueShoppingButton()
	{
		BasePage.waitForElement(driver, intSeconds, btnContinueShopping);
		btnContinueShopping.click();
	}
	
	/****************************************************************************************
	 * MethodName 		: clickProceedtoCheckout
	 * Arguments 		: NONE
	 * Description		: Method to click Proceed to checkout button
	 *
	 *****************************************************************************************/ 
	public void clickProceedToCheckout()
	{
		BasePage.waitForElement(driver, intSeconds, btnProceedToCheckout);
		btnProceedToCheckout.click();
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
		BasePage.isPageLoaded(driver, "My account - My Store");
		
	}
}
