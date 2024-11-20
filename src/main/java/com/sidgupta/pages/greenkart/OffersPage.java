package com.sidgupta.pages.greenkart;

import com.sidgupta.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OffersPage extends BasePage {

    @FindBy(id = "search-field")
    private WebElement searchFieldInput;

    @FindBy(xpath = "//td[1]")
    private WebElement productName;

    public OffersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAT() {
        wait.until(ExpectedConditions.visibilityOf(this.searchFieldInput));
        return this.searchFieldInput.isDisplayed();
    }

    public void searchProduct(String productName) {
        this.searchFieldInput.sendKeys(productName);
    }

    public String getProductName() {
        return this.productName.getText();
    }
}
