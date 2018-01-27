package com.rbs.Pages;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;

//package com.testerstories.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rbs.CucumberTestNG.TestData;


/****************************************************************************************
 * Class Name 		: BasePage 
 * Description	: To Maintain Page objects oriented methods and steps, Further enhancements required,
 *
 *****************************************************************************************
 */
public class BasePage 
{
	public WebDriver driver;
	
		
	public BasePage (WebDriver driver, WebDriverWait wait)
	{
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }
	
	/****************************************************************************************
	 * MethodName 		: waitForElementPresent
	 * Arguments 		: WebDriver driver, int seconds, WebElement elementTocheck, String msg 
	 * Description		: to wait for a given element until the timeout is reached. And check if the element is present 
	 * ex:- if you pass 60 seconds then it will wait for 60 seconds for the given element. if not identified then it will throw error
	 *
	 *****************************************************************************************
	 */
	public static void waitForElementPresent(WebDriver driver, int seconds, WebElement elementTocheck, String msg) 
	{
        (new WebDriverWait(driver, seconds).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class, StaleElementReferenceException.class).withMessage(msg)).until(ExpectedConditions.visibilityOf(elementTocheck));

    }
	
	/****************************************************************************************
	 * MethodName 		: waitForElement
	 * Arguments 		: WebDriver driver,int intSeconds,WebElement element 
	 * Description		: to wait for a given element until the timeout is reached. 
	 * ex:- if you pass 60 seconds then it will wait for 60 seconds for the given element. if not identified then it will throw error
	 *
	 *****************************************************************************************
	 */
	public static  void  waitForElement(WebDriver driver,int intSeconds,WebElement element)
	{
		new WebDriverWait(driver, intSeconds)
        .until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void isPageLoaded(WebDriver driver, String title)
	{
		waitForPageLoad(driver,TestData.waitTime);
		
		if(driver.getTitle().toLowerCase().trim().contains(title.toLowerCase()))
			TestData.isPageLoaded = true;
	}
	
	public static void waitForPageLoad(WebDriver driver,int waitTime) 
	{

	    Wait<WebDriver> wait = new WebDriverWait(driver, waitTime);
	    wait.until(new Function<WebDriver, Boolean>() 
	    {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}	
	
}
