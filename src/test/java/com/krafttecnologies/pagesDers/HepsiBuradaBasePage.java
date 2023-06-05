package com.krafttecnologies.pagesDers;

import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HepsiBuradaBasePage {
    public HepsiBuradaBasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    Actions actions=new Actions(Driver.get());
    WebDriver driver=Driver.get();

    public void hepsiBuradaTabModule(String tab, String module) {
        WebElement tabElement = driver.findElement(By.xpath("//*[text()='" + tab + "']"));
       // WebElement tabElement = driver.findElement(By.xpath("//*[text()='" + tab + "']/parent::span"));
        actions.moveToElement(tabElement).perform();
        //  tabElement.click();
        WebElement moduleElement = driver.findElement(By.xpath("//*[text()='" + module + "']"));
//        WebElement moduleElement = driver.findElement(By.
//                xpath("//*[text()='" + module + "']/ancestor::ul[@class='sf-MenuItems-MXhuaBP08HFYcFicDzFl']"));
        moduleElement.click();
    }

    public void hepsiBuradaTabModule2(String tab, String module) {

        actions.moveToElement(driver.findElement(xPathText(tab))).perform();
        click(xPathText(module));
    }
    By xPathText(String text){
        return By.xpath("//*[text()='" + text + "']");
    }

    void click(By locator){
        driver.findElement(locator).click();
    }

    public void elektronikTabModule(String module,String subModule){
        actions.moveToElement(driver.findElement(xPathText("Elektronik"))).perform();
        actions.moveToElement(driver.findElement(xPathText(module))).perform();
        click(xPathText(subModule));
    }
}
