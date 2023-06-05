package com.krafttecnologies.pagesDers;

import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TrendyOlBasePage {
    public TrendyOlBasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    WebDriver driver=Driver.get();
    Actions actions=new Actions(driver);

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesBtn_loc;

    @FindBy(xpath = "//*[@class='main-nav']/li")
    public List<WebElement> tabElements_loc;



    public void navigateToTabAndModule(String tab,String module){
        if (module.length()!=0){
        actions.moveToElement(driver.findElement(xPathText(tab))).perform();
        click(xPathText(module));
        }else{
            click(xPathText(tab));
        }
    }
    By xPathText(String text){
        return By.xpath("//*[text()='"+text+"']");
    }
    void click(By locator){
        driver.findElement(locator).click();
    }
    void click(WebElement element){
        element.click();
    }
    public void clickCookies(){
        click(acceptCookiesBtn_loc);
    }

    public List<String> mainTabsNamesList(){
        List<String> tabsNames=new ArrayList<>();
        for (WebElement element : tabElements_loc) {
            tabsNames.add(element.getText());
        }
        return tabsNames;
    }
    public List<String> mainTabsNamesList2(){
        return BrowserUtils.getElementsText(tabElements_loc);
    }

}
