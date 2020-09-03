package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 0)
    public void dropDownTest() {
        driver.get("https://www.amazon.com/");
        WebElement shipping = driver.findElement(By.className("a-button-input"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shipping.click();
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
    }

    @Test(priority = 2)
    public void googleSearchTest() {
        driver.get("https://www.google.com/");
    }

    @Test(priority = 1)
    public void titleTest() {
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
