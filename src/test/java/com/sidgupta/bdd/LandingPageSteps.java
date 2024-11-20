package com.sidgupta.bdd;

import com.sidgupta.pages.greenkart.LandingPage;
import com.sidgupta.util.Config;
import com.sidgupta.util.Constants;
import com.sidgupta.util.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LandingPageSteps {

    private TestContextSetup testContextSetup;
    private LandingPage landingPage;

    public LandingPageSteps(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenCart landing page")
    public void userIsOnGreenCartLandingPage() {
        landingPage.goTo(Config.getProperty(Constants.GREENKART_URL));
        Assert.assertTrue(landingPage.isAT());
    }

    @When("^user search with shortname (.+) and extract actual name of product$")
    public void userSearchProduct(String productName) {
        landingPage.searchProduct(productName);
        testContextSetup.landingPageProductName = landingPage.getProductName();
    }

    @When("^user adds (.+) items to the cart$")
    public void userAddsItemsToTheCart(int quantity) {
        landingPage.addProductToCart(quantity);
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        landingPage.proceedToCheckout();
    }
}
