package com.rbs.StepDefinition;

import org.openqa.selenium.WebDriver;
import com.rbs.CucumberTestNG.TestData;
import com.rbs.Pages.AccountDetailsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountInfoStepdefs 
{
	WebDriver driver;
	String strURL = "http://automationpractice.com/index.php";
	//BasePage basePage;
	//HomePage homePage ;
	//LoginPage loginPage ;
	AccountDetailsPage 	accountDetailsPage ;
	
	
	@Given("^he has navigated to My account page$")
	public void he_has_navigated_to_My_account_page()
	{
		accountDetailsPage = new AccountDetailsPage(TestData.driver);
		accountDetailsPage.navigateToMyAccountInformation();
	}

	@When("^edit the first name and save details$")
	public void edit_the_first_name_and_save_details()
	{
		accountDetailsPage.updateFirstNameAndSave(TestData.AccountInfo.getUpdatedFirstName());
	   
	}	

	@Then("^he should see the account info has changed$")
	public void he_should_see_the_account_info_has_changed()
	{
	    accountDetailsPage.verifyAccountInfoUpdated();
	}

	@Then("^he should revert the firstname again$")
	public void he_should_revert_the_firstname_again()
	{
		accountDetailsPage.navigateBackToMyAccount();
		accountDetailsPage.navigateToMyAccountInformation();
		accountDetailsPage.updateFirstNameAndSave(TestData.AccountInfo.getOriginalFirstName());
	}
}
