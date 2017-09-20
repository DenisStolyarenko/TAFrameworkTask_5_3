package com.epam.ta.framework.ui.application.pages.businesstrip;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBTPage extends AbstractPage {
    private BTDetailsBlock btDetailsBlock = new BTDetailsBlock();
    private BTGeneralInfoBlock btGeneralInfoBlock = new BTGeneralInfoBlock();

    @FindBy(xpath = "//button[text()[contains(.,'Save Changes')]]")
    private Button saveButton;

    @FindBy(xpath = "//span[@class='wdStatus']")
    private WebElement statusLabel;

    public void inputSummary(String summary){
        btGeneralInfoBlock.clearSummary();
        btGeneralInfoBlock.inputSummary(summary);
    }

    public void chooseProject(String projectName) {
        btGeneralInfoBlock.clearProject();
        btGeneralInfoBlock.chooseProject().changeFilter().searchProjectOrCost(projectName).clickByOK();
    }

    public void inputCurrency(String currency){
        btGeneralInfoBlock.clearCurrency();
        btGeneralInfoBlock.inputCurrency(currency);
    }

    public void inputEstimatedBudget(Integer estimatedBudget){
        btGeneralInfoBlock.inputEstimatedBudget(estimatedBudget);
    }

    public void inputTripFromLocation(String locationFrom){
        btDetailsBlock.inputTripFromLocation(locationFrom);
    }

    public void inputDestinationCountry(String country){
        btDetailsBlock.inputDestinationCountry(country);
    }

    public void inputDestinationCity(String destinationCity){
        btDetailsBlock.inputDestinationCity(destinationCity);
    }

    public void inputDestinationAddress(String destinationAddress){
        btDetailsBlock.inputDestinationAddress(destinationAddress);
    }

    public void inputTripDescription(String description){
        btDetailsBlock.inputTripDescription(description);
    }

    public void inputStartDate(String plannedStartDate){
        btDetailsBlock.inputStartDate(plannedStartDate);
    }

    public void inputEndDate(String plannedEndDate){
        btDetailsBlock.inputEndDate(plannedEndDate);
    }

    public void saveItem(){
        Waiters.waitForElementVisibleEnabled(saveButton);
        String executeString = saveButton.getAttribute("onclick");
        ((JavascriptExecutor) Driver.getDriverInstance()).executeScript(executeString);
    }

    public Integer countBTid(){
        return btGeneralInfoBlock.getBTid().length();
    }

    public String getDuration() {
        String startDate = btDetailsBlock.getPlannedStartDate();
        String endDate = btDetailsBlock.getPlannedEndDate();
        return startDate + " - " + endDate;
    }

    public String getStatus(){
        return statusLabel.getText();
    }
}
