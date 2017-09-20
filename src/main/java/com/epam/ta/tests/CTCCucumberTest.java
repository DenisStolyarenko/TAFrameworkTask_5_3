package com.epam.ta.tests;

import com.epam.ta.framework.ui.application.steps.businesstrip.BusinessTripStep;
import com.epam.ta.framework.ui.core.driver.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/scenarios/business_trip_base.feature", glue = {
        "com.epam.ta.framework.ui.application.steps" })

public class CTCCucumberTest extends AbstractTestNGCucumberTests {
    private BusinessTripStep businessTripStep = new BusinessTripStep();
    private String baseUrl = "https://tst2.epm-ctc.projects.epam.com/";

    @BeforeClass(description = "Log in")
    public void loginToCTC(){
        businessTripStep.login(baseUrl);
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser(){
        Driver.closeBrowser();
    }
}
