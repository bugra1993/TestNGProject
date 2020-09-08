package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateHotel extends TestBase {

    @BeforeMethod
    public void singIn() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void createHotel() {
        driver.findElement(By.id("Code")).sendKeys("199335");
        driver.findElement(By.id("Name")).sendKeys("enes bozkurt");
        driver.findElement(By.id("Address")).sendKeys("25 Myrna Way Parkwood");
        driver.findElement(By.id("Phone")).sendKeys("0376998435");
        driver.findElement(By.id("Email")).sendKeys("ensbzkrt@gmail.com");

        WebElement idGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(idGroup);
        select.selectByVisibleText("Hotel Type2");

        WebDriverWait wait = new WebDriverWait(driver, 5);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSubmit"))).click();


        WebElement saveText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(saveText.isDisplayed());


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='ok']"))).click();


    }
}
