package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class InstagramTest extends TestBase {
    @Test
    public void instagramTest() {
        driver.get("https://www.instagram.com/?hl=en");
        driver.findElement(By.name("username")).sendKeys(".......");
        driver.findElement(By.name("password")).sendKeys("......");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("xWeGp")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.partialLinkText("bangbro's")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("focus-visible")).sendKeys("DENEME 1 2 3", Keys.ENTER);


    }
}
