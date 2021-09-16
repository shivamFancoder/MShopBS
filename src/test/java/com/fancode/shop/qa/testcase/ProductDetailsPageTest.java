package com.fancode.shop.qa.testcase;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProductDetailsPageTest extends BrowserStackTestNGTest {


    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]")
    WebElement shopCarouselBanner;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]")
    WebElement firstProductInCollection;


    @Test
    public void collectionProductClickTest() {
        boolean flag = true;
        try {
            driver.get("https://www.fancode.com/shop");
            shopCarouselBanner.click();
            firstProductInCollection.click();
        } catch (Exception e) {
            flag = false;
        }
        testResultReporting("collectionProductClickTest", flag, "");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
