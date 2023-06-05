package com.krafttecnologies.pagesDers;

import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDers {
    public LoginPageDers(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "email")
    public WebElement userEmail_loc;

    @FindBy (id = "yourPassword")
    public WebElement userPassword_loc;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement submitBtn_loc;
}
