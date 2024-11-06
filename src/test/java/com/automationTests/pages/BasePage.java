package com.automationTests.pages;

import com.automationTests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public abstract class BasePage extends LoadingPageFactory {

    //-----------------------------------Button----------------------------------------------

    public void clickButton(String button) {
        WebElement element = getPageElement(button);
        if (element != null) {
            element.click();
            waitUntilPageLoadingIsFinished(5);
        } else {
            throw new NoSuchElementException("Button with text '" + button + "' not found.");
        }
    }

    public WebElement getPageElement(String button) {
        WebElement element = null;
        try {
            element = Driver.get().findElement(By.xpath("//button[text()='" + button + "']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        if (element == null) {
            element = Driver.get().findElement(By.xpath("//a[contains(text(), '" + button + "')]"));
        }
        return element;
    }

    //-----------------------------------Text-field------------------------------------------

    public void enterTextToTextField(String value, WebElement element) {
        if (element != null && value != null) {
            element.clear();
            element.sendKeys(value);
        } else {
            throw new IllegalArgumentException("Input value or element cannot be null.");
        }
    }

    protected String getTextIfDisplayed(WebElement element) {
        try {
            return element.isDisplayed() ? element.getText() : "";
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    protected String getLabel(List<WebElement> labels, String inputFieldId) {
        return labels.stream()
                .filter(label -> Objects.equals(label.getAttribute("for"), inputFieldId))
                .map(WebElement::getText)
                .findFirst()
                .orElse("Label not found");

    }

    protected WebElement findFieldValue(List<WebElement> inputs, String inputFieldId) {
        return inputs.stream()
                .filter(input -> Objects.equals(input.getAttribute("name"), inputFieldId))
                .findFirst()
                .orElse(null); // Return null if not found

    }

    protected String getTextFieldValue(List<WebElement> inputs, String inputFieldId) {
        WebElement inputField = findFieldValue(inputs, inputFieldId);
        if (inputField != null) {
            return inputField.getAttribute("value");
        } else {
            return "Input field not found"; // Default message if the field is not found
        }
    }

    //-----------------------------------Radio-Button------------------------------------------

    protected void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            action.moveToElement(element).click().perform();
        }
    }

    protected WebElement findRadioButton(String value, WebElement parentElement) {
        return parentElement.findElements(By.tagName("label")).stream()
                .filter(label -> label.getText().trim().equals(value))
                .findFirst()
                .map(label -> label.findElement(By.tagName("input")))
                .orElse(null);
    }

    //-----------------------------------Drop-down------------------------------------------

    protected WebElement findSelectField(List<WebElement> dropdowns, String selectFieldId) {
        return dropdowns.stream()
                .filter(select -> Objects.equals(select.getAttribute("name"), selectFieldId))
                .findFirst()
                .orElse(null); // Return null if not found
    }

    public void selectDropDownListElement(String option, String field, List<WebElement> dropdowns) {
        WebElement dropdown = findSelectField(dropdowns, field);
        System.out.println("dropdown " + dropdown);
        if (dropdown != null) {
            Select select = new Select(dropdown);
            select.selectByValue(option);
        } else {
            throw new NoSuchElementException("Dropdown for '" + field + "' not found.");
        }
    }

    //-----------------------------------Check-box------------------------------------------
    public void clickCheckbox(String checkbox) {
        WebElement checkboxElement = Driver.get().findElement(By.id(checkbox));

        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
            System.out.println("Checkbox was not selected, now it is checked.");
        } else {
            System.out.println("Checkbox is already selected.");
        }

    }
}