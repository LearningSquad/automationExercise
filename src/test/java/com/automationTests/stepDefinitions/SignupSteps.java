package com.automationTests.stepDefinitions;

import com.automationTests.pages.SignupPage;
import com.automationTests.utilities.ConfigurationReader;
import com.automationTests.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SignupSteps {

    private final SignupPage signupPage = new SignupPage();

    @Then("User selects title {string}")
    public void userSelectsTitle(String title) {
        signupPage.signupRadioButtonSelectOption(title);
    }

    @Then("User enters {string} to {string} text-field")
    public void userEntersPassword(String title, String element) {
        signupPage.enterTextToTextField(title, element);
    }

    @Then("User clicks {string} button on signup page")
    public void userClicksCreateAccountButton(String button) {
        signupPage.clickButton(button);
    }

    @Then("User selects the date of birth {string}")
    public void userSelectsDateOfBirth(String date) {
        String[] words = date.split("-");
        signupPage.selectElement("days", words[0]);
        signupPage.selectElement("months", words[1]);
        signupPage.selectElement("years", words[2]);
    }

    @Then("User selects the country {string}")
    public void userSelectsCountry(String country) {
        signupPage.selectElement("country", country);
    }

    @Then("User checks the {string} checkbox")
    public void userSelectsCheckbox(String checkboxElement) {
        signupPage.clickCheckbox(checkboxElement);
    }

    //--------------------Assertions----------------------
    @Then("User is on the signup page")
    public void userIsOnTheSignUpPage() {
        Assert.assertEquals("User is not on the signup page", ConfigurationReader.get("url") + "signup", Driver.get().getCurrentUrl());
    }

    @Then("User asserts enter account info title is {string}")
    public void userAssertsSignupTitle(String title) {
        Assert.assertEquals("Account info title does not match", title, signupPage.getAccountInfoHeadingText());
    }

    @Then("User asserts radio area label is {string}")
    public void userAssertsRadioAreaTitle(String title) {
        Assert.assertEquals("Radio area label does not match", title, signupPage.getSignupRadioButtonLabel());
    }

    @Then("User asserts text field label for {string} is {string}")
    public void userAssertsTextFieldLabel(String inputFieldId, String label) {
        Assert.assertEquals("Text field label does not match for " + inputFieldId, label, signupPage.getLabel(inputFieldId));
    }

    @Then("User asserts text field value for {string} is {string}")
    public void userAssertsTextFieldValue(String inputFieldId, String value) {
        Assert.assertEquals("Text field value does not match for " + inputFieldId, value, signupPage.getTextFieldValue(inputFieldId));
    }

    @Then("User asserts the date of birth is {string}")
    public void userAssertsDateOfBirth(String inputFieldId, String value) {
        Assert.assertEquals("Text field value does not match for " + inputFieldId, value, signupPage.getTextFieldValue(inputFieldId));
    }

    @Then("User asserts that the label for {string} is {string}")
    public void userAssertsCheckboxLabel(String labelElement, String labelValue) {
        Assert.assertEquals("Checkbox labels does not match for " + labelElement, labelValue, signupPage.getCheckboxLabel(labelElement));
    }

}
