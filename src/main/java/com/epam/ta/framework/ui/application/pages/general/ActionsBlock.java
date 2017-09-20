package com.epam.ta.framework.ui.application.pages.general;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.DateUtil;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import com.epam.ta.framework.ui.core.utils.decorating.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionsBlock extends AbstractPage {

    @FindBy(xpath = "//input[@value='Submit']")
    private Button submitButton;

    @FindBy(xpath = "//input[@value='Cancel']")
    private Button cancelButton;

    @FindBy(xpath = "//iframe[@id='frLookupDialog']")
    private WebElement actionFrame;

    @FindBy(xpath = "//textarea[@id='actionNote']")
    private TextInput actionNoteInput;

    @FindBy(xpath = "//td[@class='captionTitle']/h1")
    private WebElement workflowTitle;

    @FindBy(xpath = "//input[contains(@value,'Submit')]")
    private Button submitButtonInFrame;


    public void clickSubmit() {
        Waiters.waitForElementPresent(submitButton);
        submitButton.click();
        Driver.getDriverInstance().switchTo().frame(actionFrame);
    }

    public void clickCancel() {
        Waiters.waitForElementPresent(cancelButton);
        cancelButton.click();
        Driver.getDriverInstance().switchTo().frame(actionFrame);
    }

    public void fillActionNote(){
        Waiters.waitForElementVisibleEnabled(actionNoteInput);
        actionNoteInput
                .sendKeys(workflowTitle.getText() + " performed " + DateUtil.getCurrentDate());
    }

    public void submitConfirmation(){
        Waiters.waitForElementVisibleEnabled(submitButtonInFrame);
        submitButtonInFrame.click();
    }
}
