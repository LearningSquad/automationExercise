package com.automationTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailElement;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement passwordElement;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signUpNameElement;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signUpEmailElement;

    @FindBy(css = ".login-form h2")
    private WebElement loginHeading;

    @FindBy(css = ".signup-form h2")
    private WebElement signupHeading;

    @FindBy(css = ".login-form p")
    private WebElement errorMessage;


    public void enterUserInfo(String context, String name, String email, String password) {
        if ("signup".equalsIgnoreCase(context)) {
            if (name != null && !name.isEmpty()) {
                enterTextToTextField(name, signUpNameElement);
            }
            if (email != null && !email.isEmpty()) {
                enterTextToTextField(email, signUpEmailElement); // Use signup email element
            }
        } else if ("login".equalsIgnoreCase(context)) {
            if (email != null && !email.isEmpty()) {
                enterTextToTextField(email, loginEmailElement); // Use login email element
            }
            if (password != null && !password.isEmpty()) {
                enterTextToTextField(password, passwordElement);
            }
        } else {
            throw new IllegalArgumentException("Invalid context: " + context + ". Use 'signup' or 'login'.");
        }
    }


    public String getLoginHeadingText() {
        return getTextIfDisplayed(loginHeading);
    }

    public String getSignUpHeadingText() {
        return getTextIfDisplayed(signupHeading);
    }

    public String getErrorMessage() {
        return getTextIfDisplayed(errorMessage);
    }

}
