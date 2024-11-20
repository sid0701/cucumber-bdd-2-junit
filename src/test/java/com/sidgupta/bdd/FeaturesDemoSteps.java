package com.sidgupta.bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class FeaturesDemoSteps {


    @Given("User is on Practice landing page")
    public void userIsOnPracticeLandingPage() {
    }

    @When("User Signup into application")
    public void userSignupIntoApplication(List<String> data) {

        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

    }

    @Then("Home Page is displayed")
    public void homePageIsDisplayed() {


    }

    @And("Cards are displayed")
    public void cardsAreDisplayed() {
    }

    @Given("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() {
    }

    @When("User login into application with {string} and password {string}")
    public void userLoginIntoApplicationWithAndPassword(String userName, String password) {
    }
}
