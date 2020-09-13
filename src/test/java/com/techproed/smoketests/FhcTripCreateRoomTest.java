package com.techproed.smoketests;

import com.techproed.pages.FhcTripCreateRoomPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripCreateRoomTest extends TestBase {


    public void createRoomLogIn() {
        driver.get(ConfigurationReader.getProperty("room_create_url"));
        driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
        driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);

    }

    @Test
    public void createRoom() {
        createRoomLogIn();
        FhcTripCreateRoomPage page = new FhcTripCreateRoomPage(driver);
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        Select select = new Select(page.dropBox);
        select.selectByVisibleText("SUNSET");
        wait1.until(ExpectedConditions.visibilityOf(page.code)).sendKeys(ConfigurationReader.getProperty("code"));
        wait1.until(ExpectedConditions.visibilityOf(page.name)).sendKeys(ConfigurationReader.getProperty("name"));
        wait1.until(ExpectedConditions.visibilityOf(page.location)).sendKeys(ConfigurationReader.getProperty("location"));
        wait1.until(ExpectedConditions.visibilityOf(page.description)).
                sendKeys(ConfigurationReader.getProperty("description"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(page.price, page.priceBox).perform();
        Select select1 = new Select(page.roomType);
        select1.selectByVisibleText("Quad");
        wait1.until(ExpectedConditions.visibilityOf(page.maxAdultCount)).
                sendKeys(ConfigurationReader.getProperty("max_adult_count"));
        wait1.until(ExpectedConditions.visibilityOf(page.maxChildCount)).
                sendKeys(ConfigurationReader.getProperty("max_child_count"));
        page.approveBox.click();
        wait1.until(ExpectedConditions.visibilityOf(page.save)).click();


        boolean isDisplayed = wait1.until(ExpectedConditions.visibilityOf(page.isSuccesed)).isDisplayed();
        Assert.assertTrue(isDisplayed);


    }
}
