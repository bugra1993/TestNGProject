package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    @BeforeMethod
    public void signIn() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void roomCreateTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("hidden-480"))).click();

        WebElement IDHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(IDHotel);
        select.selectByVisibleText("TechPro");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("Code"))).sendKeys("12345");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("Name"))).sendKeys("enes");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("Location"))).sendKeys("europe");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//textarea[@dir='ltr']"))).sendKeys("king rooms");
        WebElement price = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Price")));
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cost = driver.findElement(By.partialLinkText("400"));
        actions.dragAndDrop(cost, price).perform();

        WebElement roomType = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("IDGroupRoomType")));
        Select select1 = new Select(roomType);
        select1.selectByVisibleText("King");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("MaxAdultCount"))).sendKeys("2");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("MaxChildCount"))).sendKeys("0");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@data-val='true']"))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("btnSubmit"))).click();

        Assert.assertTrue(webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("bootbox-body"))).isDisplayed());

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@data-bb-handler='ok']"))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.partialLinkText("List Of Hotelrooms"))).click();

    }
}
