package com.techproed.smoketests;

import com.techproed.pages.FacebookLogInPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FacebookLogInTest extends TestBase {
    @Test
    public void logIn() {
        driver.get(ConfigurationReader.getProperty("fb_login"));
        FacebookLogInPage logInPage = new FacebookLogInPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logInPage.emailBox)).
                sendKeys(ConfigurationReader.getProperty("username"));
        wait.until(ExpectedConditions.visibilityOf(logInPage.passwordBox)).
                sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);


    }
}
