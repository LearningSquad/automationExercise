@Regression

Feature: User login functionality

  Background:
    Given User is on the home page
    When User clicks "Signup / Login" button on home page
    Then User is on the login page
    And User asserts login info title is "Login to your account"

  @smoke @login
  Scenario: User successfully logs in and out with valid credentials
    When User enters "email@myemailde7.com" email address and "password1234" password
    And User clicks "Login" button on login page
    Then User is on the home page
    And User asserts that they are logged in as "Firstname"
    When User clicks "Logout" button on home page
    Then User is on the login page

  @smoke @login
  Scenario Outline: User gets error message with incorrect credentials
    When User enters "<email>" email address and "<password>" password
    And User clicks "Login" button on login page
    Then User asserts incorrect credential message is "Your email or password is incorrect!"

    Examples:
      | email                | password        |
      | invalid@gmail.com    | invalidPassword |
      | invalid@example.com  | password1234    |
      | email@myemailde7.com | invalidPassword |

