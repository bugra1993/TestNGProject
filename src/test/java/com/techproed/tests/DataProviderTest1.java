package com.techproed.tests;

import com.techproed.pages.FhcTripNewLogInPage;
import com.techproed.utilities.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
    @Test(dataProvider = "information")
    public void logInTest(String username, String password) {
        Driver.getDriver().get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripNewLogInPage page = new FhcTripNewLogInPage();
        page.username.sendKeys(username);
        page.password.sendKeys(password);
        page.login.click();
    }

    @DataProvider(name = "information")
    public Object[][] getInformation() {
        Object[][] information = new Object[3][2];
        information[0][0] = "manage";
        information[0][1] = "sifre";

        information[1][0] = "manager2";
        information[1][1] = "sifre";

        information[2][0] = "manager2";
        information[2][1] = "Man1ager2!";

        return information;

    }
}
