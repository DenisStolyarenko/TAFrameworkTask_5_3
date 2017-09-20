package com.epam.ta.framework.ui.core.utils.decorating.elements;

import com.epam.ta.framework.ui.core.utils.Service;
import org.openqa.selenium.WebElement;

public class TextInput extends Element{
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... keysToSend) {
        Service.HighlightOfElement(webElement);
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

}
