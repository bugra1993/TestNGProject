package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorTest {

    @Test
    public void amazonSearch() {
        Driver.getDriver().get("https://www.amazon.com/");
        String title = JSExecutor.getTitleByJS();
        System.out.println(title);

        AmazonNewPage page = new AmazonNewPage();
        page.searchBox.sendKeys("samsung");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSExecutor.clickElementByJS(page.findButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSExecutor.scrollDownByJS();

        WebElement color = Driver.getDriver().findElement(By.xpath("//span[.='Phone Color']"));
        JSExecutor.scrollInToViewJS(color);


        JSExecutor.flash(color);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement condition = Driver.getDriver().findElement(By.xpath("//*[.='Condition']"));
        JSExecutor.changeColor("rgb(255,0,0", condition);

        JSExecutor.generateAlert("Test has PASSED!!");
    }

}
