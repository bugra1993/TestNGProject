package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase {


    @Test
    public void implicitlyWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement elementRemove = driver.findElement(By.xpath("//*[.='Remove']"));
        elementRemove.click();
        WebElement elementAdd = driver.findElement(By.xpath("//*[.='Add']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void explicitWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

        WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButton.click();

        WebElement message = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());


    }


}
