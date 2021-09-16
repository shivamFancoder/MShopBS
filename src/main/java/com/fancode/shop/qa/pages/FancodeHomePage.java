package com.fancode.shop.qa.pages;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import com.fancode.shop.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FancodeHomePage extends BrowserStackTestNGTest {

    //Page Factory - Object Repo
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[3]/div[1]/div[1]")
    WebElement shopButton;

    WebDriver driver;


    public FancodeHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validateTitleOfFancodeHome() {
        return driver.getTitle();
    }

    public boolean validateShopImage() {
        return shopButton.isDisplayed();
    }

    public ShopHomePage clickShopButton() {
        shopButton.click();
        return new ShopHomePage(driver);
    }

}
