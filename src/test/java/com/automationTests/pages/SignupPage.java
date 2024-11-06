package com.automationTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignupPage extends BasePage {

    @FindBy(css = ".login-form h2")
    private WebElement accountInfoTitle;

    @FindBy(className = "clearfix")
    private WebElement parentElement;

    @FindBy(css = "div.form-group select, p.form-group select")
    private List<WebElement> dropdowns;

    @FindBy(css = ".form-group label")
    private List<WebElement> labels;

    @FindBy(css = ".form-group input")
    private List<WebElement> inputs;

    @FindBy(css = ".checkbox input")
    private List<WebElement> checkbox;

    @FindBy(css = ".checkbox label")
    private List<WebElement> checkboxLabels;

    public String getAccountInfoHeadingText() {
        return getTextIfDisplayed(accountInfoTitle);
    }

    public String getSignupRadioButtonLabel() {
        return parentElement.findElement(By.tagName("label")).getText();
    }

    public void signupRadioButtonSelectOption(String value) {
        WebElement radioButton = findRadioButton(value, parentElement);
        if (radioButton != null) {
            clickElement(radioButton);
        } else {
            throw new RuntimeException("Radio button for " + value + " not found.");
        }
    }

    public String getLabel(String labelElement) {
        return getLabel(labels, labelElement);
    }

    public String getTextFieldValue(String inputFieldId) {
        return getTextFieldValue(inputs, inputFieldId);
    }

    public void enterTextToTextField(String value, String element) {
        WebElement textField = findFieldValue(inputs, element);
        if (textField.isDisplayed() && textField.isEnabled()) {
            enterTextToTextField(value, textField);
        } else {
            throw new RuntimeException("Text field is not visible or not interactable.");
        }
    }

    public void selectElement(String field, String option) {
        selectDropDownListElement(option, field, dropdowns);
    }

    public String getCheckboxLabel(String labelElement) {
        return getLabel(checkboxLabels, labelElement);
    }

}
