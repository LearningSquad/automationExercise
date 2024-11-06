package com.automationTests.stepDefinitions;

import com.automationTests.pages.DeleteAccountPage;
import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteAccountSteps {

    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    @When("User clicks {string} button on delete account page")
    public void userClicksButton(String button) {
        deleteAccountPage.clickButton(button);
    }

    @Then("User is on delete account page")
    public void accountCreatedPage() {
        Assert.assertEquals("User is not on the account created page", ConfigurationReader.get("url") + "delete_account", Driver.get().getCurrentUrl());
    }

    @Then("User assert that the heading on delete account page is {string}")
    public void assertHeading(String heading) {
        Assert.assertEquals("Account created heading does not match", heading, deleteAccountPage.heading());
    }

    @Then("User assert that the first paragraph on delete account page is {string}")
    public void assertParagraph1(String paragraph) {
        Assert.assertEquals("Account created heading does not match", paragraph, deleteAccountPage.paragraphText1());
    }

    @Then("User assert that the second paragraph on delete account page is {string}")
    public void assertParagraph2(String paragraph) {
        Assert.assertEquals("Account created heading does not match", paragraph, deleteAccountPage.paragraphText2());
    }
}
