package com.techproed.tests;

import com.techproed.pages.AmazonNewPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    AmazonNewPage page = new AmazonNewPage();


    @Test(dataProvider = "products")
    public void amazonSearchTest(String product) {
        Driver.getDriver().get("https://www.amazon.com/");
        page.searchBox.sendKeys(product + Keys.ENTER);
    }

    @DataProvider(name = "products")
    public Object[] getProducts() {
        Object[] products = new Object[4];
        products[0] = "java";
        products[1] = "selenium";
        products[2] = "mouse";
        products[3] = "keyboard";

        return products;
    }
}
