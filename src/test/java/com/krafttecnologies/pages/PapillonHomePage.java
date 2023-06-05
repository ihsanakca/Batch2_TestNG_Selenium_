package com.krafttecnologies.pages;

import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PapillonHomePage extends BasePage{

    public void navigateToTabsOrModules(String tabNameOrModuleName) throws InterruptedException {
        String tabOrModuleName="//header//a[text()='"+tabNameOrModuleName+"']";
        WebElement element = Driver.get().findElement(By.xpath(tabOrModuleName));
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", element);
    }
    public void hoverTabs(String tabName){
        String tabNameToHover="//header//a[text()='"+tabName+"']";
        WebElement elementToHover = Driver.get().findElement(By.xpath(tabNameToHover));
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(elementToHover).perform();
    }
}
