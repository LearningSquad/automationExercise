@Regression

Feature: User register functionality

  Background:
    Given User is on the home page
    When User clicks "Signup / Login" button on home page
    Then User is on the login page

  @smoke @register
  Scenario: User registers successfully with valid credentials
     # Sign Up Information
    And User asserts signup info title is "New User Signup!"
    And User enters "testUser" name "validEmail@example.com" email address
    When User clicks "Signup" button on login page
    Then User is on the signup page

    # Account Information
    And User asserts enter account info title is "ENTER ACCOUNT INFORMATION"
    And User asserts radio area label is "Title"
    When User selects title "Mr."
    And User asserts text field label for "name" is "Name *"
    And User asserts text field value for "name" is "testUser"
    And User asserts text field label for "email" is "Email *"
    And User asserts text field value for "email" is "validEmail@example.com"
    And User asserts text field label for "password" is "Password *"
    And User enters "test1234" to "password" text-field

    When User selects the date of birth "15-6-1990"

    And User asserts that the label for "newsletter" is "Sign up for our newsletter!"
    When User checks the "newsletter" checkbox
    And User asserts that the label for "optin" is "Receive special offers from our partners!"
    When User checks the "optin" checkbox

     # Personal Details
    And User asserts text field label for "first_name" is "First name *"
    And User enters "George" to "first_name" text-field
    And User asserts text field label for "last_name" is "Last name *"
    And User enters "Williams" to "last_name" text-field
    And User asserts text field label for "company" is "Company"
    And User enters "MicroMax" to "company" text-field

    And User asserts text field label for "address1" is "Address * (Street address, P.O. Box, Company name, etc.)"
    And User enters "123 Home" to "address1" text-field
    And User asserts text field label for "address2" is "Address 2"
    And User enters "Land" to "address2" text-field
    When User selects the country "Singapore"
    And User asserts text field label for "state" is "State *"
    And User enters "West Region" to "state" text-field
    And User asserts text field label for "city" is "City *"
    And User enters "Singapore" to "city" text-field
    And User enters "134546" to "zipcode" text-field

    And User asserts text field label for "mobile_number" is "Mobile Number *"
    And User enters "1345462345" to "mobile_number" text-field
    When User clicks "Create Account" button on signup page
    Then User is on account created page
    Then User assert that the heading on account created page is "ACCOUNT CREATED!"
    Then User assert that the first paragraph on account created page is "Congratulations! Your new account has been successfully created!"
    Then User assert that the second paragraph on account created page is "You can now take advantage of member privileges to enhance your online shopping experience with us."
    When User clicks "Continue" button on account created page
    Then User is on the home page

    #Post-condition steps
    When User clicks "Delete Account" button on home page
    Then User is on delete account page
    Then User assert that the heading on delete account page is "ACCOUNT DELETED!"
    Then User assert that the first paragraph on delete account page is "Your account has been permanently deleted!"
    Then User assert that the second paragraph on delete account page is "You can create new account to take advantage of member privileges to enhance your online shopping experience with us."
    When User clicks "Continue" button on delete account page
    Then User is on the home page