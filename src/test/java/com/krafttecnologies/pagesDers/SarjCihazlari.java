package com.krafttecnologies.pagesDers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SarjCihazlari extends TrendyOlBasePage{

    @FindBy(xpath = "//span[text()='Şarj Cihazları']")
    public WebElement searchingSarjCihaz_loc;
}
