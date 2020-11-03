package com.techproed.smoketests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {
    @Test
    public void test() throws MalformedURLException {
        //1) Desired capabilities tanimlama
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);
        //2) chrome options

        ChromeOptions options = new ChromeOptions();
        options.merge(cap);

        //3) hub adresimizi girecegiz
        String hubUrl = "http://192.168.0.163:4444/wd/hub";

        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);

        driver.get("http://www.amazon.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
