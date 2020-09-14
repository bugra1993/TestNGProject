package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {


    public GlbSignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailBox;
    @FindBy(name = "name")
    public WebElement name;
    @FindBy(id = "mobile")
    public WebElement phone;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "re_password")
    public WebElement re_password;
    @FindBy(name = "submit")
    public WebElement signUp;
    @FindBy(tagName = "strong")
    public WebElement success;

}
