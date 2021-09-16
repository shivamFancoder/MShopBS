package com.fancode.shop.qa.testcase;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShopHomePageTest extends BrowserStackTestNGTest {


    @Test
    public void hamburgerMenuOnClickTest() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopHamburgerMenuBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        shopHamburgerMenuBtn.click();
        WebElement shopHamburgerMenuCloseBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"));
        boolean flag = shopHamburgerMenuCloseBtn.isDisplayed();
        testResultReporting("hamburgerMenuOnClickTest", flag, "");
        Assert.assertTrue(flag);
    }

    @Test
    public void hamburgerMenuOnCloseClickTest() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopHamburgerMenuBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        shopHamburgerMenuBtn.click();
        WebElement shopHamburgerMenuCloseBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"));
        boolean flag = shopHamburgerMenuCloseBtn.isDisplayed();
        testResultReporting("hamburgerMenuOnCloseClickTest", flag, "");
        Assert.assertTrue(flag);
    }

    @Test
    public void shopCartOnClickTest() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopCartOpenBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/img[1]"));
        if (shopCartOpenBtn.isDisplayed()) {
            shopCartOpenBtn.click();
        }
        WebElement shopCartDrawer = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[3]"));
        boolean flag = shopCartDrawer.isDisplayed();
        testResultReporting("shopCartOnClickTest", flag, "");
        Assert.assertTrue(flag);
    }

    @Test
    public void shopCartOnCloseClickTest() {
        driver.get("https://www.fancode.com/shop");
        WebElement shopCartOpenBtn = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/img[1]"));
        if (shopCartOpenBtn.isDisplayed()) {
            shopCartOpenBtn.click();
        }
        WebElement shopCartCloseBtn = driver.findElement(By.xpath("//div[contains(text(),'CLOSE')]"));
        shopCartCloseBtn.click();
        boolean flag = shopCartOpenBtn.isDisplayed();
        testResultReporting("shopCartOnCloseClickTest", flag, "");
        Assert.assertTrue(flag);
    }


    @Test
    public void clickCarouselBannerTest() {
        boolean flag = true;
        try {
            driver.get("https://www.fancode.com/shop");
            WebElement shopCarouselBanner = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]"));
            while (!shopCarouselBanner.isDisplayed()) {
            }
            shopCarouselBanner.click();
        } catch (Exception e) {
            flag = false;
        }
        testResultReporting("clickCarouselBannerTest", flag, "");
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {

    }
}
