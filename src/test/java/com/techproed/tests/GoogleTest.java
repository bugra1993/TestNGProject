package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void searchTest() {
        driver.get("https://www.google.com");
        GooglePage googlePage = new GooglePage(driver);
        googlePage.searchBox.sendKeys("kindle");
        googlePage.searchBox.submit();


    }
}
