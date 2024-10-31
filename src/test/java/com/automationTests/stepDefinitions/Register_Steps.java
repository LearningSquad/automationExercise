package com.automationTests.stepDefinitions;

import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register_Steps {

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.get("url"));
    }

    @When("User clicks {string} menu button")
    public void userClicksMenuButton() {
        Driver.get().get(ConfigurationReader.get("url"));
        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.get("url"));
    }
}
