package com.krafttecnologies.pages;

import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver=Driver.get();
    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToModule(String tab, String module) {
        String tabLocator = "//ul[@class='d-flex align-items-center']//span[.='"+tab+"']";

        String moduleLocator = "//span[.='" + module + "']";

        BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
        WebElement tabElement = driver.findElement(By.xpath(tabLocator));
        tabElement.click();
        if (!module.isEmpty()) {
            BrowserUtils.waitForClickablility(By.xpath(moduleLocator), 5);
            driver.findElement(By.xpath(moduleLocator)).click();
        }

    }

    public String subTitle(String subtitle) {
        String subTitleLocator = "(//li[.='"+subtitle+"'])[2]";


        BrowserUtils.waitForPresenceOfElement(By.xpath(subTitleLocator), 5);

        WebElement subTitle = Driver.get().findElement(By.xpath(subTitleLocator));

        String actualSubTitle = subTitle.getText();
        return actualSubTitle;
    }

    public String getAccountName_mtd(String accountName) {
        return Driver.get().findElement(By.xpath("//span[.='" + accountName + "']")).getText();
    }
}
