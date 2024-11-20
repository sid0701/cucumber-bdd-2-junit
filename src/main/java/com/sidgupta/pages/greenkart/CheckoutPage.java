package com.sidgupta.pages.greenkart;

import com.sidgupta.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    @FindBy(css = "button.promoBtn")
    private WebElement applyButton;

    @FindBy(css = "p.product-name")
    private WebElement productName;

    @FindBy(css = "input.promoCode")
    private WebElement promoCodeInput;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAT() {
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        return applyButton.isDisplayed();
    }

    public String getProductName() {
        return productName.getText().split("-")[0].trim();
    }

    public void applyPromoCode(String promocode) {
        promoCodeInput.sendKeys(promocode);
        applyButton.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

}
