@Regression

Feature: Login
  @smoke @login1
  Scenario: Login User with correct email and password
    Given User is on the home page
    When User clicks "Signup / Login" menu button
