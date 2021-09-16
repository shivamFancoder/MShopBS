package com.fancode.shop.qa.testcase;

import com.fancode.shop.qa.base.BrowserStackTestNGTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FancodeHomePageTest extends BrowserStackTestNGTest {

    boolean flag;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[3]/div[1]/div[1]")
    WebElement shopButton;


    public FancodeHomePageTest() {
        super();
    }

    @Test
    public void fancodeHomePageTitleTest() {
        flag = false;
        driver.get("https://www.fancode.com/");
        String title = driver.getTitle();
        if (title.equals("Cricket Live Streaming, Live Score, Match Predictions, Fantasy Tips, Stats & Videos | FanCode.com")) {
            flag = true;
        }
        Assert.assertTrue(flag);
        testResultReporting("collectionProductClickTest", flag, "");
    }

    @Test
    public void shopImageVisibilityTest() {
        driver.get("https://www.fancode.com/");
        boolean flag = shopButton.isDisplayed();
        Assert.assertTrue(flag);
        testResultReporting("shopImageVisibilityTest", flag, "");
    }

    @Test
    public void shopOnClickTest() {
        shopButton.click();
        String url = driver.getCurrentUrl();
        if (url.contains("/shop")) {
            flag = true;
        }
        Assert.assertTrue(flag);
        testResultReporting("shopOnClickTest", flag, "");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
