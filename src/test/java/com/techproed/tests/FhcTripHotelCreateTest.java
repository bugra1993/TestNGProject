package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.pages.FhcTripLogInPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FhcTripHotelCreateTest extends TestBase {
    public void logIn() {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLogInPage fhcTripLogInPage = new FhcTripLogInPage(driver);
        fhcTripLogInPage.username.sendKeys("manager2" + Keys.TAB);
        fhcTripLogInPage.password.sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void createHotel() {
        logIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, 5);


        FhcTripHotelCreatePage test = new FhcTripHotelCreatePage(driver);
        wait.until(ExpectedConditions.visibilityOf(test.hotelManagement)).click();
        wait.until(ExpectedConditions.visibilityOf(test.hotelList)).click();
        wait.until(ExpectedConditions.visibilityOf(test.addHotel)).click();
        wait.until(ExpectedConditions.visibilityOf(test.code)).sendKeys("1234");
        wait.until(ExpectedConditions.visibilityOf(test.name)).sendKeys("enesbz");
        wait.until(ExpectedConditions.visibilityOf(test.address)).sendKeys("parkwood");
        wait.until(ExpectedConditions.visibilityOf(test.phone)).sendKeys("123457898765");
        wait.until(ExpectedConditions.visibilityOf(test.email)).sendKeys("nsbzkrt@gmail.com");
        Select select = new Select(test.idGroup);
        select.selectByVisibleText("Hotel Type1");
        wait.until(ExpectedConditions.visibilityOf(test.saveButton)).click();


    }
}
