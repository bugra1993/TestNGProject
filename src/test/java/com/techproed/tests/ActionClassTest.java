package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class ActionClassTest extends TestBase {

    @Test

    public void rightClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

    }

    @Test

    public void hoverOVer() {
        driver.get("https://www.amazon.com/");
        WebElement shipping = driver.findElement(By.className("a-button-input"));
        shipping.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @Test
    public void keysUpDown() {
        driver.get("https://www.amazon.com/");
        WebElement shipping = driver.findElement(By.className("a-button-input"));
        shipping.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.END).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void shiftButton() {
        driver.get("https://www.google.com/");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.name("q"))).click()
                .keyDown(Keys.SHIFT).sendKeys("hello!")
                .keyUp(Keys.SHIFT).sendKeys("how are you today?").perform();


    }

    @Test
    public void dragElement() {
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement store = driver.findElement(By.partialLinkText("Store"));
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.dragAndDrop(store, searchBox).perform();

    }

}
