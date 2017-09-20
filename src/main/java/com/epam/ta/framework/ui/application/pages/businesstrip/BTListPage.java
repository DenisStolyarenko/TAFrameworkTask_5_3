package com.epam.ta.framework.ui.application.pages.businesstrip;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BTListPage extends AbstractPage {
    private final String BUSINESS_TRIP_LOCATION = "/businesstrip/list.do";

    @FindBy(xpath = "//input[@title='Create New Business Trip Request']")
    private Button createButton;

    @FindBy(xpath = "//td[@class='header1']/h1")
    private WebElement btListName;

    public void openBTlist(String baseUrl){
        Driver.getDriverInstance().get(baseUrl + BUSINESS_TRIP_LOCATION);
    }

    public void newBtClick(){
        Waiters.waitForElementEnabled(createButton);
        createButton.click();
    }

    public String readListName(){
        Waiters.waitForElementPresent(btListName);
        return btListName.getText();
    }
}
