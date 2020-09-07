package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {


    @Test
    public void implicitlyWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement elementRemove = driver.findElement(By.xpath("//*[.='Remove']"));
        elementRemove.click();
        WebElement elementAdd = driver.findElement(By.xpath("//*[.='Add']"));
    }

}
