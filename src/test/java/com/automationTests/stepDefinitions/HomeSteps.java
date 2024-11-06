package com.automationTests.stepDefinitions;

import com.automationTests.pages.HomePage;
import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private final HomePage homePage = new HomePage();

    @When("User clicks {string} button on home page")
    public void userClicksButton(String button) {
        homePage.clickButton(button);
    }

    //--------------------Assertions----------------------

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.get("url"));
    }

    @When("User asserts that they are logged in as {string}")
    public void userAssertsLoggedInAs(String expectedFirstName) {
        String actualText = homePage.getLoggedInAs();
        Assert.assertEquals(expectedFirstName, actualText);
    }
}
