package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {

    @Test
    public void signUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_trader_url"));
        GlbSignUpPage page = new GlbSignUpPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(page.emailBox)).sendKeys(ConfigurationReader.getProperty("glb_email"));
        wait.until(ExpectedConditions.visibilityOf(page.name)).sendKeys(ConfigurationReader.getProperty("glb_name"));
        wait.until(ExpectedConditions.visibilityOf(page.phone)).sendKeys(ConfigurationReader.getProperty("glb_phone"));
        wait.until(ExpectedConditions.visibilityOf(page.password)).sendKeys(ConfigurationReader.getProperty("glb_passcode"));
        wait.until(ExpectedConditions.visibilityOf(page.re_password)).sendKeys(ConfigurationReader.getProperty("glb_passcode"));
        wait.until(ExpectedConditions.visibilityOf(page.signUp)).click();

        boolean doesSuccess = wait.until(ExpectedConditions.visibilityOf(page.success)).isDisplayed();
        Assert.assertTrue(doesSuccess);

        Driver.closeDriver();


    }
}
