package com.epam.ta.framework.ui.application.pages.businesstrip;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.application.pages.general.ChooseProjectBlock;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import com.epam.ta.framework.ui.core.utils.decorating.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BTGeneralInfoBlock extends AbstractPage {

    @FindBy(xpath = "//input[@name='itemName']")
    private TextInput summaryInput;

    @FindBy(xpath = "//input[@class='textfield textfieldDigit textfieldAmount' and @name='estimatedBudget']")
    private TextInput estimateBudgetInput;

    @FindBy(xpath = "//input[@id='baseCurrencyStr']")
    private TextInput currencyInput;

    @FindBy(xpath = "//input[@name='baseCurrencyId']")
    private WebElement currencyIdLabel;

    @FindBy(xpath = "//img[contains(@onclick,'chooseprojectcostobject')]")
    private Button chooseProjectButton;

    @FindBy(xpath = "//a/img[@title='Clear']")
    private Button clearProjectButton;

    @FindBy(xpath = "//span[@class='item' and contains(text(), 'Business Trip ID: #')]/a")
    private WebElement btIdLabel;


    public ChooseProjectBlock chooseProject(){
        Waiters.waitForElementEnabled(chooseProjectButton);
        chooseProjectButton.click();
        return new ChooseProjectBlock();
    }

    public void clearProject(){
        Waiters.waitForElementEnabled(clearProjectButton);
        clearProjectButton.click();
    }

    public void inputSummary(String summary){
        Waiters.waitForElementEnabled(summaryInput);
        summaryInput.sendKeys(summary);
    }

    public void clearSummary(){
        Waiters.waitForElementEnabled(summaryInput);
        summaryInput.clear();
    }

    public void inputCurrency(String currency){
        Waiters.waitForElementEnabled(currencyInput);
        currencyInput.sendKeys(currency);
    }

    public void clearCurrency(){
        Waiters.waitForElementEnabled(currencyInput);
        currencyInput.clear();
    }

    public void inputEstimatedBudget(Integer estimatedBudget){
        Waiters.waitForElementEnabled(estimateBudgetInput);
        estimateBudgetInput.sendKeys(estimatedBudget.toString());
    }

    public String getBTid(){
        Waiters.waitForElementVisibleEnabled(btIdLabel);
        return btIdLabel.getText();
    }

}