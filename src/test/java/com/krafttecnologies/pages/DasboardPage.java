package com.krafttecnologies.pages;

import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DasboardPage extends BasePage{

    @FindBy(xpath = "//h1[.='Dashboard']")
    public WebElement dashboardPageTitle_loc;

    @FindBy(xpath = "(//span[.='</aFm>'])[1]")
    public WebElement aFMTitle_loc;

    @FindBy(xpath = "//span[@class='d-none d-md-block dropdown-toggle ps-2']")
    public WebElement userPopUp_loc;

    @FindBy(xpath = "(//span[.='My Profile'])[2]")
    public WebElement myProfile_loc;

    @FindBy(xpath = "//a[.='Home'")
    public WebElement homeLink_loc;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOut_loc;

    @FindBy (xpath = "//div[@class='copyright']")
    public WebElement copyright_loc;

    @FindBy(xpath = "//h3[.='isa akyuz']")
    public WebElement isaUser_loc;

    @FindBy(xpath = "//span[.='JavaScript']")
    public WebElement javaScript_loc;

    @FindBy(xpath = "//span[.='Modal']")
    public WebElement modal_loc;



    public String dashboardPageTitle(String title){
        String Title=dashboardPageTitle_loc.getText();
        return Title;
    }

    public String usersNames(String name){
        String userNameLocator="//h3[.='"+name+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(userNameLocator),5);

        WebElement UserName= Driver.get().findElement(By.xpath(userNameLocator));

        String actualName=UserName.getText();

        return actualName;
    }

}