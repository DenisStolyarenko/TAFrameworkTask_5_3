package com.epam.ta.tests;

import com.epam.ta.framework.ui.application.business_objects.BusinessTrip;
import com.epam.ta.framework.ui.application.business_objects.BusinessTripFactory;
import com.epam.ta.framework.ui.application.enums.ItemType;
import com.epam.ta.framework.ui.application.steps.businesstrip.BusinessTripStep;
import com.epam.ta.framework.ui.core.driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CTCTest {
    private BusinessTripStep businessTripStep = new BusinessTripStep();


    @Test(description = "Log in")
    @Parameters({"baseUrl"})
    public void loginTest(String baseUrl){
        Assert.assertTrue(businessTripStep.login(baseUrl), "Impossible to login to CTC");
    }

    @Test(dependsOnMethods = "loginTest", description = "check opening the list of Business Trips")
    @Parameters({"baseUrl"})
    public void openListOfBT(String baseUrl) {
        Assert.assertEquals(businessTripStep.checkingNameOfOpenedItemList(baseUrl), ItemType.BT.getItemName(), "The section did not found");
    }

    @Test(dependsOnMethods = "openListOfBT", description = "create new BT")
    @Parameters({"EstimatedBudget"})
    public void createNewBt(String EstimatedBudget){
        BusinessTrip item = BusinessTripFactory.createBusinessTripForApproveByDifferentLevel(Integer.parseInt(EstimatedBudget));
        businessTripStep.createBT(item);
        Assert.assertTrue(businessTripStep.checkingIDOfBusinessTrip(), "Business Trip is not created");
    }

    @Test(dependsOnMethods = "createNewBt", description = "submit BT")
    public void submitBT(){
        businessTripStep.submitWithActionNote();
        Assert.assertTrue(businessTripStep.isSubmitted(), "Business Trip is not submited");
    }

    @Test(dependsOnMethods = "submitBT", description = "Log out")
    public void logOut() {
        Assert.assertTrue(businessTripStep.logout(),"Logout is not performed");
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser(){
        Driver.closeBrowser();
    }
}
