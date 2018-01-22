package com.rbs.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;

//package com.testerstories.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage 
{
	public WebDriver driver;
	
		
	public BasePage (WebDriver driver, WebDriverWait wait)
	{
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }
	
//	public void LaunchBrowser()
//	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
//	}
//	public BasePage(WebDriver driver)
//	{
//		System.out.println("Browser Name ==>" + System.getProperty("browser"));
//		System.out.println("URL ==>" + System.getProperty("browser"));
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-64.exe");
//		driver = new FirefoxDriver();
//		driver.get("http://automationpractice.com/index.php");
//		
//		 //super(driver);
//		BasePage.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public static void waitForElementPresent(WebDriver driver, int seconds, WebElement elementTocheck, String msg) 
	{
        (new WebDriverWait(driver, seconds).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class, StaleElementReferenceException.class).withMessage(msg)).until(ExpectedConditions.visibilityOf(elementTocheck));

    }
	
	public static  void  waitForElement(WebDriver driver,int intSeconds,WebElement element)
	{
		new WebDriverWait(driver, intSeconds)
        .until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
