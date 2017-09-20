package com.epam.ta.framework.ui.application.pages.general;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.driver.Driver;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import com.epam.ta.framework.ui.core.utils.decorating.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ChooseProjectBlock extends AbstractPage {
    private final String frameLookupDialogName = "frLookupDialog";

    @FindBy(xpath = "//select[@name='filter']")
    private TextInput filterSelect;

    @FindBy(xpath = "//input[@name='keywordSearch']")
    private TextInput searchInput;

    @FindBy(xpath = "//input[@value='Go']")
    private Button goButton;

    @FindBy(xpath = "//input[@value='OK']")
    private Button okButton;

    public ChooseProjectBlock changeFilter(){
        Driver.getDriverInstance().switchTo().frame(frameLookupDialogName);
        Waiters.waitForElementVisibleEnabled(filterSelect);
        filterSelect.sendKeys("My projects");
        return this;
    }

    public ChooseProjectBlock searchProjectOrCost(String projectName){
        Waiters.waitForElementVisibleEnabled(searchInput);
        searchInput.sendKeys(projectName);
        goButton.click();
        Driver.getDriverInstance().findElement(By.xpath("//input[@type='checkbox' and @projectcostobjectname='" + projectName + "']")).click();
        return this;
    }

    public void clickByOK (){
        Waiters.waitForElementVisibleEnabled(okButton);
        okButton.click();
    }

}
