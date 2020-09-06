package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.Set;


public class WindowHandleTest extends TestBase {

    @Test
    public void windowsHandleTest() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickTo = driver.findElement(By.partialLinkText("Click Here"));
        clickTo.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> allWindows = driver.getWindowHandles();
        for (String w : allWindows) {
            System.out.println(w);
        }

        String secondPageHandle = (String) ((allWindows.toArray())[allWindows.size() - 1]);
        System.out.println(secondPageHandle);

    }


}
