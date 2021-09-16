package com.fancode.shop.qa.pages;

import com.fancode.shop.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends TestBase {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
