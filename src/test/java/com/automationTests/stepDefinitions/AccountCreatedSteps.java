package com.automationTests.stepDefinitions;

import com.automationTests.pages.AccountCreatedPage;
import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountCreatedSteps {
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();


    @When("User clicks {string} button on account created page")
    public void userClicksButton(String button) {
        accountCreatedPage.clickButton(button);
    }

    @Then("User is on account created page")
    public void accountCreatedPage() {
        Assert.assertEquals("User is not on the account created page", ConfigurationReader.get("url") + "account_created", Driver.get().getCurrentUrl());
    }

    @Then("User assert that the heading on account created page is {string}")
    public void assertHeading(String heading) {
        Assert.assertEquals("Account created heading does not match", heading, accountCreatedPage.heading());
    }

    @Then("User assert that the first paragraph on account created page is {string}")
    public void assertParagraph1(String paragraph) {
        Assert.assertEquals("Account created heading does not match", paragraph, accountCreatedPage.paragraphText1());
    }

    @Then("User assert that the second paragraph on account created page is {string}")
    public void assertParagraph2(String paragraph) {
        Assert.assertEquals("Account created heading does not match", paragraph, accountCreatedPage.paragraphText2());
    }
}
