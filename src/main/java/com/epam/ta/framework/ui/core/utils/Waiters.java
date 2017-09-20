package com.epam.ta.framework.ui.core.utils;


import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;

    public static void waitForElementPresent(final WebElement element){
        WebElement myDynamicElement = (new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return element;
                    }
                });
    }

    public static void waitForElementVisible(WebElement element) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementEnabled(WebElement element) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibleEnabled(WebElement element) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)));
    }

    protected static void waitForFillingField(final WebElement element, final String expectedResult) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!element.getText().toLowerCase().equals(expectedResult));
            }
        });
    }

    public static void waitForElementEnabled(Element userElement) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(userElement.getWebElement()));
    }

    public static void waitForElementVisible(Element userElement) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(userElement.getWebElement()));
    }

    public static void waitForElementVisibleEnabled(Element userElement) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(userElement.getWebElement()),
                        ExpectedConditions.elementToBeClickable(userElement.getWebElement())));
    }

    public static void waitForElementPresent(final Element userElement){
        WebElement myDynamicElement = (new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver driver) {
                        return userElement.getWebElement();
                    }
                });
    }
}
