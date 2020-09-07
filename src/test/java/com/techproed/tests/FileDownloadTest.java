package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void isThereFile() {

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String userFilePath = System.getProperty("user.dir");
        String pomXmlFilePath = userFilePath + "/pom.xml";

        boolean isThere = Files.exists(Paths.get(pomXmlFilePath));
        Assert.assertTrue(isThere);

    }

    @Test
    public void uploadFile() {
        driver.get("http://the-internet.herokuapp.com/upload");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("file-upload")).sendKeys("/Users/bugracamlidag/Desktop/logo.png");
        driver.findElement(By.id("file-submit")).click();
        WebElement upload = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(upload.isDisplayed());


    }

    @Test
    public void downloadFile() {
        driver.get("http://the-internet.herokuapp.com/download");


        driver.findElement(By.partialLinkText("jabami.jpg")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String filePath = "/Users/bugracamlidag/Downloads/jabami.jpg";

        boolean isThere = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isThere);

    }




}
