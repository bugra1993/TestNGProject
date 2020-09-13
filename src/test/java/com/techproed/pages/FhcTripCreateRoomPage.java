package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripCreateRoomPage {
    WebDriver driver;

    public FhcTripCreateRoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "IDHotel")
    public WebElement dropBox;
    @FindBy(id = "Code")
    public WebElement code;
    @FindBy(id = "Name")
    public WebElement name;
    @FindBy(id = "Location")
    public WebElement location;
    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement description;
    @FindBy(id = "Price")
    public WebElement priceBox;
    @FindBy(partialLinkText = "500")
    public WebElement price;
    @FindBy(id = "IDGroupRoomType")
    public WebElement roomType;
    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;
    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;
    @FindBy(id = "IsAvailable")
    public WebElement approveBox;
    @FindBy(id = "btnSubmit")
    public WebElement save;
    @FindBy(xpath = "//*[.='HotelRoom was inserted successfully']")
    public WebElement isSuccesed;

}
