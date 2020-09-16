package com.techproed.tests;

import com.techproed.pages.FhcTripLogInPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FhcTripLogInTest extends TestBase {
    @Test(groups = {"fhctrip", "login"})
    public void logIn() {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLogInPage fhcTripLogInPage = new FhcTripLogInPage(driver);
        fhcTripLogInPage.username.sendKeys("manager2" + Keys.TAB);
        fhcTripLogInPage.password.sendKeys("Man1ager2!" + Keys.ENTER);
    }

}
