package com.epam.ta.framework.ui.application.steps;

import com.epam.ta.framework.ui.application.business_objects.BusinessTrip;
import com.epam.ta.framework.ui.application.business_objects.BusinessTripFactory;
import com.epam.ta.framework.ui.application.pages.businesstrip.BTListPage;
import com.epam.ta.framework.ui.application.pages.businesstrip.CreateBTPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CucumberBTStep {
    private CreateBTPage createBTPage = new CreateBTPage();
    private BTListPage btListPage = new BTListPage();

    @Given("^user navigate to Business Trip list page \"([^\"]*)\"$")
    public void user_navigate_to_Business_Trip_list_page(String baseUrl){
        btListPage.openBTlist(baseUrl);
    }

    @When("^click New Business Trip$")
    public void click_New_Business_Trip(){
        btListPage.newBtClick();
    }

    @And("^fill mandatory fields \"([^\"]*)\"$")
    public void fill_mandatory_fields(String EstimatedBudget){
        BusinessTrip businessTrip = BusinessTripFactory.createBusinessTripForApproveByDifferentLevel(Integer.parseInt(EstimatedBudget));
        createBTPage.chooseProject(businessTrip.getProjectName());
        createBTPage.inputEstimatedBudget(businessTrip.getEstimatedBudget());
        createBTPage.inputTripFromLocation(businessTrip.getLocationFrom());
        createBTPage.inputDestinationCountry(businessTrip.getCountry());
        createBTPage.inputDestinationCity(businessTrip.getDestinationCity());
        createBTPage.inputDestinationAddress(businessTrip.getDestinationAddress());
        createBTPage.inputTripDescription(businessTrip.getDescription());
        createBTPage.inputStartDate(businessTrip.getPlannedStartDate());
        createBTPage.inputEndDate(businessTrip.getPlannedEndDate());
        createBTPage.inputSummary(businessTrip.getSummary());
    }

    @And("^click save button$")
    public void click_save_button(){
        createBTPage.saveItem();
    }

    @Then("^Business Trip is saved$")
    public void Business_Trip_is_saved(){
        Assert.assertTrue(createBTPage.countBTid() == 19, "Business Trip is not created");
    }
}
