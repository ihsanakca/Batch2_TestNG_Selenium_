package com.krafttecnologies.pagesDers;

import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageDers {
    public DashboardPageDers(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//h2[text()='Selim Gezer']")
    public WebElement userName_loc;
}
