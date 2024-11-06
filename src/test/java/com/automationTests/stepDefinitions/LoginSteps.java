package com.automationTests.stepDefinitions;

import com.automationTests.pages.LoginPage;
import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Then("User enters {string} email address and {string} password")
    public void userEntersEmailAndPassword(String email, String password) {
        loginPage.enterUserInfo("login", null, email, password);
    }

    @Then("User enters {string} name {string} email address")
    public void userEntersNameAndEmail(String name, String email) {
        loginPage.enterUserInfo("signup", name, email, null);
    }

    @When("User clicks {string} button on login page")
    public void userClicksButton(String button) {
        loginPage.clickButton(button);
    }

    //--------------------Assertions----------------------

    @Then("User is on the login page")
    public void userIsOnTheLoginPage() {
        Assert.assertEquals("User is not on the expected login page URL", ConfigurationReader.get("url") + "login", Driver.get().getCurrentUrl());
    }

    @Then("User asserts login info title is {string}")
    public void userAssertsLoginInfoTitle(String title) {
        Assert.assertEquals("Login info title does not match", title, loginPage.getLoginHeadingText());
    }

    @Then("User asserts signup info title is {string}")
    public void userAssertsSignUpInfoTitle(String title) {
        Assert.assertEquals("Sign up info title does not match", title, loginPage.getSignUpHeadingText());
    }

    @Then("User asserts incorrect credential message is {string}")
    public void userAssertsIncorrectCredentialMessage(String expectedMessage) {
        Assert.assertEquals("Incorrect credential message does not match", expectedMessage, loginPage.getErrorMessage());
    }

}
