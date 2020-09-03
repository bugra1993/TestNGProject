package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    @Ignore
    public void test01() {
        driver.get("https://www.amazon.com/");
        String title = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(title.contains("Amazon"));
        softAssert.assertTrue(title.contains("Car"));
        softAssert.assertEquals(title, "Online");

        softAssert.assertAll();


    }

    @Test
    @Ignore
    public void test02() {
        driver.get("http://a.testaddressbook.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SoftAssert softAssert = new SoftAssert();
        WebElement signInButton = driver.findElement(By.id("sign-in"));
        signInButton.click();
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(emailBox.getText());
        softAssert.assertTrue(driver.getTitle().equals("Deneme"));


        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");


        WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement singOut = driver.findElement(By.partialLinkText("Sign out"));
        boolean isDisplayed = singOut.isDisplayed();


        softAssert.assertTrue(isDisplayed);

        softAssert.assertAll();

    }

    @Test
    @Ignore
    public void test03() {
        driver.get("http://a.testaddressbook.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement signInButton = driver.findElement(By.id("sign-in"));
        signInButton.click();
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        System.out.println(emailBox.getText());

    }

 
}
