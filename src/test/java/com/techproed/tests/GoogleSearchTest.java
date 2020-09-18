package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBaseFinal {

    @Test
    public void searchTest() {

        extentTest = extentReports.createTest("google search", "search techproed in google");

        extentTest.info("go to url address");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_url"));
        extentTest.info("create object for using web elements from google page");
        GooglePage googlePage = new GooglePage();
        extentTest.info("search 'techproed' in google ");
        googlePage.searchBox.sendKeys("techproeducation" + Keys.ENTER);
        extentTest.info("test if there is a result stats");
        Assert.assertTrue(googlePage.resultStats.isDisplayed());
        extentTest.info("wait 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        extentTest.info("compare all links");
        boolean isThereLink = false;

        for (WebElement w : googlePage.links) {
            if (w.getText().contains("techproeducation12345.com")) {
                isThereLink = true;
                break;
            }
        }
        extentTest.info("do assert transaction");
        Assert.assertTrue(isThereLink);
        extentTest.pass("test passed");
    }


}
