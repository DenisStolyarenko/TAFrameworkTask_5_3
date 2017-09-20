package com.epam.ta.framework.ui.application.pages.businesstrip;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import com.epam.ta.framework.ui.core.utils.decorating.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BTDetailsBlock extends AbstractPage {

    @FindBy(xpath = "//span[@id='plannedDuration']")
    private WebElement plannedDurationLabel;

    @FindBy(xpath = "//input[@id='plannedStartDate_ui']")
    private TextInput plannedStartDateInput;

    @FindBy(xpath = "//input[@id='plannedEndDate_ui']")
    private TextInput plannedEndDateInput;

    @FindBy(xpath = ".//select[@name='destinationCountryId']")
    private WebElement destinationCountrySelect;

    @FindBy(xpath = ".//select[@name='fromLocationId']")
    private WebElement fromLocationSelect;

    @FindBy(xpath = "//input[@name='destinationCity']")
    private TextInput destinationCityInput;

    @FindBy(xpath = "//textarea[@name='destinationAddress']")
    private TextInput destinationAddressInput;

    @FindBy(xpath = "//textarea[@id='description']")
    private TextInput descriptionInput;

    @FindBy(xpath = "//input[@id='ticketsRequired']")
    private Button ticketRadioButton;

    @FindBy(xpath = "//input[@id='carRequired']")
    private Button carRadioButton;

    public void inputStartDate(String plannedStartDate){
        Waiters.waitForElementVisibleEnabled(plannedStartDateInput);
        plannedStartDateInput.click();
        plannedStartDateInput.clear();
        plannedStartDateInput.sendKeys(plannedStartDate);
    }

    public void inputEndDate(String plannedEndDate){
        Waiters.waitForElementVisibleEnabled(plannedEndDateInput);
        plannedEndDateInput.click();
        plannedEndDateInput.clear();
        plannedEndDateInput.sendKeys(plannedEndDate);
    }

    public void inputTripFromLocation(String locationFrom){
        Waiters.waitForElementVisibleEnabled(fromLocationSelect);
        Select locationFromSelect = new Select(fromLocationSelect);
        locationFromSelect.selectByVisibleText(locationFrom);
    }

    public void inputDestinationCountry(String country){
        Waiters.waitForElementVisibleEnabled(destinationCountrySelect);
        Select countrySelect = new Select(destinationCountrySelect);
        countrySelect.selectByVisibleText(country);
    }

    public void inputDestinationCity(String destinationCity){
        destinationCityInput.sendKeys(destinationCity);
    }

    public void inputDestinationAddress(String destinationAddress){
        destinationAddressInput.sendKeys(destinationAddress);
    }

    public void inputTripDescription(String description){
        descriptionInput.sendKeys(description);
    }

    public BTDetailsBlock selectTicket(){
        if (!ticketRadioButton.isSelected()) {
            ticketRadioButton.click();
        }
        return this;
    }

    public BTDetailsBlock selectCar(){
        if (!carRadioButton.isSelected()) {
            carRadioButton.click();
        }
        return this;
    }

    public String getPlannedDuration(){
        return plannedDurationLabel.getText();
    }

    public String getPlannedEndDate() {
        return plannedEndDateInput.getAttribute("value");
    }

    public String getPlannedStartDate() {
        return plannedStartDateInput.getAttribute("value");
    }
}
