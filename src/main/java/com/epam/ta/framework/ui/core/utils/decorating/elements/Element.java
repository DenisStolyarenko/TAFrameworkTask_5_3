package com.epam.ta.framework.ui.core.utils.decorating.elements;

import org.openqa.selenium.WebElement;

public class Element implements IElement {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement(){
        return webElement;
    }

    public void click(){
        webElement.click();
    }

    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }
}
