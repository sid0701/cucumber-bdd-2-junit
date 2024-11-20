package com.sidgupta.bdd;

import com.sidgupta.util.ScreenshotService;
import com.sidgupta.util.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

public class CucumberHooks {

    private TestContextSetup testContextSetup;

    public CucumberHooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void quitBrowser() throws MalformedURLException {
        this.testContextSetup.baseTest.getDriver().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws MalformedURLException {
        if (scenario.isFailed())
            scenario.attach(ScreenshotService.getScreenshotAsBytes(testContextSetup.baseTest.getDriver()), "image/png", scenario.getName());
    }

}
