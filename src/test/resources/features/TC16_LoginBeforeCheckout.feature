@TC16
Feature: User should be able to login, finish the purchase by checkout and delete account.

  @pre
  Scenario Outline: User Register before Test Case 16
    When The user opens browser and navigates to web site
    And The user clicks on "Signup / Login" page text
    And The user enters name as "<name>" email as "<email>" and clicks Signup button
    And The user enters "<password>" "<firstname>" "<lastname>" "<address>" "<country>" "<state>" "<city>" "<zipcode>" "<mobileNumber>" as required data and clicks create account button for sign up process on signup page
    And The user clicks on "Continue" page text
    Then The user verifies that logged in as "Ali" successfully
    And The user clicks on "Logout" page text
    Examples:
      | name | email              | password   | firstname | lastname | address            | country       | state | city        | zipcode | mobileNumber |
      | Ali  | ali@moneytolia.com | TestCase16 | Ali       | Tester   | All Street, PO1234 | United States | LA    | Los Angeles | PO1234  | +1234567890  |

  @TC16
  Scenario Outline: Test Case 16 - Place Order: Login Before Checkout
    When The user opens browser and navigates to web site
    Then The user verifies that land on "Home" page
    When The user clicks on "Signup / Login" page text
    And The user fills email and password input areas with "ali@moneytolia.com" and "TestCase16" and clicks login button
    Then The user verifies that logged in as "Ali" successfully
    When The user adds listed products
      | Sleeveless Dress |
      | Summer White Top |
      | Fancy Green Top  |
    And The user clicks on "Cart" page text
    Then The user verifies that land on "Cart" page
    When The user clicks on "Proceed To Checkout" page text
    Then The user verifies Address Details
    And The user reviews order and verifies Total Amount is "Rs. 2100"
    When The user enters "Thank you for your cooperation" comment to text area
    And The user clicks on "Place Order" page text
    And The user enters payment details as "<nameOnCard>" "<cardNumber>" "<cvc>" "<expiryMonth>" "<expiryYear>" and clicks pay and confirm order button
    Then The user verifies "Your order has been placed successfully!" message is shown on payment page
    Then The user verifies "Congratulations! Your order has been confirmed!" message is shown on payment done page
    And The user clicks on "Delete Account" page text
    Then The user verifies "ACCOUNT DELETED!" message
    And The user clicks on "Continue" page text
    Examples:
      | nameOnCard | cardNumber               | cvc | expiryMonth | expiryYear |
      | Ali Tester | 4455 0001 0001 0067 5237 | 311 | 12          | 2029       |