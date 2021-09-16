package com.fancode.shop.qa.pages;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopHomePage extends BrowserStackTestNGTest {

    //Page Factory - Object Repo
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement shopHamburgerMenuBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]")
    WebElement shopHamburgerMenuDrawer;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]")
    WebElement shopHamburgerMenuCloseBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/img[1]")
    WebElement shopCartOpenBtn;

    @FindBy(xpath = "//div[contains(text(),'CLOSE')]")
    WebElement shopCartCloseBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]")
    WebElement shopCartDrawer;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]")
    WebElement shopCarouselBanner;

    WebDriver driver;


    public ShopHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickShopHamburgerMenu() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopHamburgerMenuBtn = driver.findElement(By.name("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        if (shopHamburgerMenuBtn.isDisplayed()) {
            shopHamburgerMenuBtn.click();
        }
    }

    public boolean validateShopHamburgerMenuIsOpen() {
        driver.get("https://www.fancode.com/shop");
        clickShopHamburgerMenu();
        return shopHamburgerMenuDrawer.isDisplayed();
    }

    public void clickShopHamburgerMenuClose() {
        shopHamburgerMenuCloseBtn.click();
    }

    public boolean validateShopHamburgerMenuIsClosed() {
        clickShopHamburgerMenuClose();
        return shopHamburgerMenuBtn.isDisplayed();
    }

    public void clickShopCartBtn() {
        driver.get("https://www.fancode.com/shop");
        if (shopCartOpenBtn.isDisplayed()) {
            shopCartOpenBtn.click();
        }
    }

    public boolean validateShopCartIsOpen() {
        //driver.get("https://www.fancode.com/shop");
        clickShopCartBtn();
        return shopCartDrawer.isDisplayed();
    }

    public void clickShopCartClose() {
        shopCartCloseBtn.click();
    }

    public boolean validateShopCartIsClosed() {
        clickShopCartClose();
        return shopCartOpenBtn.isDisplayed();
    }

    public CollectionPage clickCarouselBanner() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopCarouselBanner = driver.findElement(By.name("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]"));
        shopCarouselBanner.click();
        return new CollectionPage(driver);
    }

}
