package com.techproed.smoketests;

import com.techproed.pages.FhcTripLogInPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void logIn() {
        driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLogInPage logInPage = new FhcTripLogInPage(driver);
        logInPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        logInPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        logInPage.login.click();
    }
}
