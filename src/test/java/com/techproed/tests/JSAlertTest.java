package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement firstAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstAlert.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsAlertTest2() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement secondAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        secondAlert.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void jsAlertTest3() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement thirdAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdAlert.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().sendKeys("who the hell are you?");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
