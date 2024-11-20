package com.sidgupta.pages.greenkart;

import com.sidgupta.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LandingPage.class);
    @FindBy(css = "input.search-keyword")
    private WebElement searchInput;

    @FindBy(css = "h4.product-name")
    private WebElement product_Name;

    @FindBy(xpath = "//a[text()='Top Deals']")
    private WebElement topDealsLink;

    @FindBy(css = "a.increment")
    private WebElement incrementButton;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//img[@alt='Cart']")
    private WebElement cartImage;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    private WebElement checkoutButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAT() {
        wait.until(ExpectedConditions.visibilityOf(this.searchInput));
        return this.searchInput.isDisplayed();
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public void searchProduct(String productName) {
        this.searchInput.sendKeys(productName);
        try{
            Thread.sleep(1000);
        } catch(Exception e){
            log.info("Product not found");
        }
    }

    public String getProductName() {
        return this.product_Name.getText().split("-")[0].trim();
    }

    public void clickOnTopDealsLink() {
        this.topDealsLink.click();
    }

    public void addProductToCart(int quantity) {
        for (var i = 0; i < quantity; i++)
            incrementButton.click();
        addToCartButton.click();
    }

    public void proceedToCheckout() {
        cartImage.click();
        checkoutButton.click();
    }

}
