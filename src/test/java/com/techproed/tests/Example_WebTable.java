package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Example_WebTable extends TestBase {
    @Test
    public void test() {
        signIn();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> thirdRow = driver.findElements(By.xpath("//tbody/tr[3]"));
        for (WebElement w : thirdRow) {
            System.out.println(w.getText());
        }

    }

    public void signIn() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
