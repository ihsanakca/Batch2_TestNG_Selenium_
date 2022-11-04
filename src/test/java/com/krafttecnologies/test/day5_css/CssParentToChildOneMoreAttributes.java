package com.krafttecnologies.test.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssParentToChildOneMoreAttributes {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("edge");
        driver.get("http://www.krafttechexlab.com/");

        WebElement exercise1=driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']"));
        String str=driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']")).getText();
        System.out.println(str);

        driver.close();
    }
}
