package com.epam.ta.framework.ui.application.pages;

import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.CustomFieldDecorator;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    @FindBy(xpath = "//a[@href='logout.do']")
    private Button logoutButton;

    protected AbstractPage(){
        PageFactory.initElements(new CustomFieldDecorator(Driver.getDriverInstance()), this);
    }

    public void open(String baseUrl){
        String ADDITIONAL_URL = "/login.do?logout=true&tz=GMT%2B06:00";
        Driver.getDriverInstance().get(baseUrl + ADDITIONAL_URL);
    }

    public void logout(){
        Waiters.waitForElementEnabled(logoutButton);
        logoutButton.click();
    }

    public void confirmation(){
        Driver.getDriverInstance().switchTo().alert().accept();
    }


}
