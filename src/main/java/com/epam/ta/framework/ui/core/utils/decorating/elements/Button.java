package com.epam.ta.framework.ui.core.utils.decorating.elements;

import com.epam.ta.framework.ui.core.utils.Service;
import org.openqa.selenium.WebElement;

public class Button extends Element{
    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click(){
        Service.HighlightOfElement(webElement);
        webElement.click();
    }

}
