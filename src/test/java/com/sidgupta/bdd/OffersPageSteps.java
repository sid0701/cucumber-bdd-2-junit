package com.sidgupta.bdd;

import com.sidgupta.pages.greenkart.OffersPage;
import com.sidgupta.util.TestContextSetup;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class OffersPageSteps {

    private TestContextSetup testContextSetup;
    private OffersPage offersPage;

    public OffersPageSteps(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        offersPage = testContextSetup.pageObjectManager.getOffersPage();
    }

    @Then("^user search for (.+) in Offers page to check if product exist$")
    public void userSearchesSameProduct(String productName) {

        testContextSetup.pageObjectManager.getLandingPage().clickOnTopDealsLink();
        testContextSetup.switchWindowService.switchToChildWindow();
        Assert.assertTrue(offersPage.isAT());
        offersPage.searchProduct(productName);
        Assert.assertEquals(offersPage.getProductName(), testContextSetup.landingPageProductName);

    }
}
