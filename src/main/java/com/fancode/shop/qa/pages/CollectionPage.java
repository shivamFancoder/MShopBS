package com.fancode.shop.qa.pages;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import com.fancode.shop.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionPage extends BrowserStackTestNGTest {


    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement firstProductInCollection;

    WebDriver driver;

    public CollectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage clickProductOnCollectionPage() {
        firstProductInCollection.click();
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage validateProductPageOpened() {
        return clickProductOnCollectionPage();
    }
}
