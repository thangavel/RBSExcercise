$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PurchaseOrder.feature");
formatter.feature({
  "line": 2,
  "name": "Online Shopping",
  "description": "In order to test this application\nAs a registered user I want to purchase a TShirt and update my first name in my account details",
  "id": "online-shopping",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 9163826745,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Order T-Shirt and Verify in Order History",
  "description": "",
  "id": "online-shopping;order-t-shirt-and-verify-in-order-history",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@Order"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "The user logged into the application",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "navigate to the TShirts tab, select a TShirt",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "He enter quantiy, size, proceed checkout",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "he select billing address",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "he select the Payment Type",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "proceed to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "he confirm the order",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the order should get succeed",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "the user can find the latest order listed in the Order History",
  "keyword": "And "
});
formatter.match({
  "location": "PurchaseOrderStepdefs.The_user_logged_into_the_application()"
});
formatter.result({
  "duration": 3733943126,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.navigate_to_the_TShirts_tab_select_a_TShirt()"
});
formatter.result({
  "duration": 2279497238,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.he_enter_quantiy_size_proceed_checkout()"
});
formatter.result({
  "duration": 11028982681,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.he_select_billing_address()"
});
formatter.result({
  "duration": 3068330198,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.he_select_the_Cheque()"
});
formatter.result({
  "duration": 2826315483,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.proceed_to_checkout()"
});
formatter.result({
  "duration": 26094,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.he_confirm_the_order()"
});
formatter.result({
  "duration": 1892613900,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.the_order_should_get_succeed()"
});
formatter.result({
  "duration": 79799784,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseOrderStepdefs.the_user_can_find_the_latest_order_listed_in_the_Order_History()"
});
formatter.result({
  "duration": 3864104784,
  "status": "passed"
});
formatter.after({
  "duration": 324034930,
  "status": "passed"
});
formatter.before({
  "duration": 9130050935,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Update Personal Information (First Name) in My Account",
  "description": "",
  "id": "online-shopping;update-personal-information-(first-name)-in-my-account",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@Account"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "The user logged into the application",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "he has navigated to My account page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "edit the first name and save details",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "he should see the account info has changed",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "he should revert the firstname again",
  "keyword": "And "
});
formatter.match({
  "location": "PurchaseOrderStepdefs.The_user_logged_into_the_application()"
});
formatter.result({
  "duration": 3809572856,
  "status": "passed"
});
formatter.match({
  "location": "AccountInfoStepdefs.he_has_navigated_to_My_account_page()"
});
formatter.result({
  "duration": 1158455324,
  "status": "passed"
});
formatter.match({
  "location": "AccountInfoStepdefs.edit_the_first_name_and_save_details()"
});
formatter.result({
  "duration": 1474627944,
  "status": "passed"
});
formatter.match({
  "location": "AccountInfoStepdefs.he_should_see_the_account_info_has_changed()"
});
formatter.result({
  "duration": 77437953,
  "status": "passed"
});
formatter.match({
  "location": "AccountInfoStepdefs.he_should_revert_the_firstname_again()"
});
formatter.result({
  "duration": 3630509162,
  "status": "passed"
});
formatter.after({
  "duration": 279741250,
  "status": "passed"
});
});