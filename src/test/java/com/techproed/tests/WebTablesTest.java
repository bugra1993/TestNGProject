package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {


    public void signIn() {
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void table() {
        signIn();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());

        List<WebElement> heads = driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement w : heads) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void allRows() {
        signIn();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));


        for (WebElement w : allRows) {

            System.out.println(w.getText());


        }

    }

    @Test
    public void allData() {
        signIn();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<WebElement> allData = driver.findElements(By.xpath("//tbody/tr/td"));


        for (WebElement q : allData) {
            System.out.println(q.getText());
        }
    }

    @Test
    public void oneRowData() {
        signIn();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> nameData = driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for (WebElement w : nameData) {
            System.out.println(w.getText());
        }

    }

    @Test
    public void compile() {
        signIn();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Hotel Rooms"))).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printData(3, 5);
        printData(6, 5);
        printData(10, 2);
        printData(7, 1);
        printData(1, 3);
    }

    public void printData(int line, int column) {
        String xpathValue = "//tbody/tr[" + line + "]/td[" + column + "]";
        WebElement data = driver.findElement(By.xpath(xpathValue));
        System.out.println(data.getText());

    }

}
