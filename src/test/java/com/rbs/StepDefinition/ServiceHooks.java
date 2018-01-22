//package com.rbs.StepDefinition;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
//
//import com.rbs.CucumberTestNG.WebDriverFactory;
//import com.rbs.Pages.BasePage;
//import com.sun.javafx.runtime.SystemProperties;
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//
//public class ServiceHooks 
//{
//
//	String URL = "https://www.google.co.uk";
//	 private static WebDriver webDriver = null;
//
//	 	@Before
//	    public void initializeTest()
//	 	{
//	 		//initContext();
//	 		webDriver = new FirefoxDriver();
//	            webDriver.get(URL);
//	 		
//	    }
//	 	
//	 	public void initContext() 
//	 	{
//
// 	        String browser = System.getProperty("browser");
// 	        String URL = System.getProperty("website");
// 	        if (browser.equals("firefox")) 
// 	        {
// 	            webDriver = new FirefoxDriver();
// 	            webDriver.navigate().to(URL);
// 	        } 
// 	        if (browser.equals("chrome"))
//    		{
// 	        	webDriver = new ChromeDriver();
// 	            webDriver.navigate().to(URL);
//    		}
//	 	}
// 
//	    @After
//	    public void embedScreenshot(Scenario scenario) 
//	    {
//	        if (scenario.isFailed()) 
//	        {
//	            try {
//	                // Code to capture and embed images in test reports (if scenario fails)
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }
//	}
//}
