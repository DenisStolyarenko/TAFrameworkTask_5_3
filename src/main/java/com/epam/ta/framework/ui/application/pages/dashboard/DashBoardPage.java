package com.epam.ta.framework.ui.application.pages.dashboard;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends AbstractPage {

    @FindBy(xpath = "//td[@id='headerLogin']/div[@class='blInfoLogin']")
    private WebElement loggedLabel;

    @FindBy(xpath = "//td[@class='header1']/h1[text()='Dashboard']")
    private WebElement dashboardLabel;

    public String readLoggedinText(){
        Waiters.waitForElementPresent(dashboardLabel);
        return loggedLabel.getText();
    }
}
