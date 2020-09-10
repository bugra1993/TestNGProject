package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FhcTripHotelCreatePage {
    WebDriver driver;


    public FhcTripHotelCreatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Hotel Management")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Address")
    public WebElement address;

    @FindBy(id = "Phone")
    public WebElement phone;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "IDGroup")
    public WebElement idGroup;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;


}
