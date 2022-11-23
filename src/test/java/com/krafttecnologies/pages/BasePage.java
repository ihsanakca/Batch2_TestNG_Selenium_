package com.krafttecnologies.pages;

import com.krafttecnologies.test.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage  {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateToModule(String tab,String module){
        String tabLocator="//span[.='"+tab+"']";
        String moduleLocator="//span[.='"+module+"']";

        BrowserUtils.waitForClickablility(By.xpath(tabLocator),5);
        WebElement tabElement=Driver.get().findElement(By.xpath(tabLocator));
        tabElement.click();

        BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);
        Driver.get().findElement(By.xpath(moduleLocator)).click();
    }

    public String subTitle(String subtitle){
        String subTitleLocator="//h1[.='"+subtitle+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(subTitleLocator),5);

        WebElement subTitle=Driver.get().findElement(By.xpath(subTitleLocator));

        String actualSubTitle=subTitle.getText();
        return actualSubTitle;
    }
}
