package com.automationTests.pages;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']//h2")
    private WebElement headingElement;

    // Using XPath to locate the paragraph (p)
    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']//p[1]")
    private WebElement paragraphElement1;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']//p[2]")
    private WebElement paragraphElement2;

    public String heading() {
       return getTextIfDisplayed(headingElement);
   }

    public String paragraphText1() {
        return getTextIfDisplayed(paragraphElement1);
    }

    public String paragraphText2() {
        return getTextIfDisplayed(paragraphElement2);
    }
}
