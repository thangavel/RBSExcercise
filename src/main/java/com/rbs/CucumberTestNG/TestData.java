package com.rbs.CucumberTestNG;

import org.openqa.selenium.WebDriver;

public class TestData 
{
	
	public static WebDriver driver;
		
	public static class ConfigDetails
	{
		public static final String Browser = "firefox";//"chrome";
		private static String strURL = "http://automationpractice.com/index.php"; // instance variable
		// method to retrieve the name from the object   
		public static String getURL()   {  return strURL; }   
		
	}
	public static class Login
	{
		private static String userName = "someone@example.com"; // instance variable
		// method to retrieve the name from the object   
		public static String getUserName()   {  return userName; }   
		
		private static String passWord = "Password123"; // instance variable
		// method to retrieve the name from the object   
		public static String getPassword()   {  return passWord; }   

	}
	
	public static class Product
	{
		private static String prodName = "Faded Short Sleeve T-shirts"; // instance variable
		// method to retrieve the name from the object   
		public static String getProductName()   {  return prodName; }   
		
		private static String quantity = "2" ; // instance variable
		public static void setQuantity(String quantity)   {  Product.quantity = quantity; }  
		// method to retrieve the name from the object   
		public static String getQuantity()   {  return quantity; }   
		
		private static String strSize = "L" ; // instance variable
		public void setSize(String strSize)   {  Product.strSize = strSize; }  
		// method to retrieve the name from the object   
		public static String getSize()   {  return strSize; }
		
		private static String strColour = "Blue" ; // instance variable
		public static void setColor(String strColour)   {  Product.strColour = strColour; }  
		// method to retrieve the name from the object   
		public static String getColor()   {  return strColour; }   

	}

	
	public static class Payment
	{
		
		private static String strPaymentType = "Cheque" ; // instance variable
		public static void setPaymentType(String strPaymentType)   {  Payment.strPaymentType = strPaymentType; }  
		// method to retrieve the name from the object   
		public static String getPaymentType()   {  return strPaymentType; }   
		
		private static String strOrderReference = "NULL" ; // instance variable
		public static void setOrderReference(String strOrderReference)   {  Payment.strOrderReference = strOrderReference; }  
		// method to retrieve the name from the object   
		public static String getOrderReference()   {  return strOrderReference; }
		
		
	}

	
	public static class AccountInfo
	{
		
		private static String strUpdatedFirstName = "someoneUpdated" ; // instance variable
		
		public static String getUpdatedFirstName()   {  return strUpdatedFirstName; }  
		
		private static String strRevertFirstName = "someone" ; // instance variable
		
		public static String getOriginalFirstName()   {  return strRevertFirstName; }  
		
		
	}

	
	
	
	
}
