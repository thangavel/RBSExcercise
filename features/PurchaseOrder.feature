@tag
Feature: Online Shopping
  In order to test this application
  As a registered user I want to purchase a TShirt and update my first name in my account details

   @PurchaceOrder
  Scenario: Order T-Shirt and Verify in Order History
    Given The user logged into the application
    When navigate to the TShirts tab, select a TShirt
    And He enter quantiy, size, proceed checkout
    And he select billing address
    And he select the Payment Type
    And proceed to checkout
    When he confirm the order
    Then the order should get succeed
    And the user can find the latest order listed in the Order History

  @Account
  Scenario: Update Personal Information (First Name) in My Account
    Given The user logged into the application
    And he has navigated to My account page
    When edit the first name and save details
    Then he should see the account info has changed
    And he should revert the firstname again
