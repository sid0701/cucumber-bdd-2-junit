package com.sidgupta.util;

import com.sidgupta.pages.greenkart.CheckoutPage;
import com.sidgupta.pages.greenkart.LandingPage;
import com.sidgupta.pages.greenkart.OffersPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        return new LandingPage(driver);
    }

    public OffersPage getOffersPage(){
        return new OffersPage(driver);
    }

    public CheckoutPage getCheckoutPage(){
        return new CheckoutPage(driver);
    }

}
