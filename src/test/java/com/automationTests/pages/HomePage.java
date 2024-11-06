package com.automationTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAs;

    public String getLoggedInAs() {
        return getTextIfDisplayed(loggedInAs);
    }

}
