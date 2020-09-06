package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Example_AmazonSignUpPage extends TestBase {

    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("a-button-input")).click();
        WebElement account = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.partialLinkText("Start here.")).click();
        String title = driver.getTitle();
        boolean isTitle = driver.getTitle().equals(title);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isTitle);
        softAssert.assertAll();


        driver.findElement(By.name("customerName")).sendKeys("bugra camlidag");
        driver.findElement(By.id("ap_email")).sendKeys("bgrcmldg@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Izmir35*");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("ap_password_check")).sendKeys("Izmir35*");
        driver.findElement(By.id("continue")).click();

    }


}
