package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    @Test
    public void searchAmazon() {
        driver.get("https://www.amazon.com/");

        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.searchBox.sendKeys("macbook");
        amazonPage.searchBox.submit();
    }
}
