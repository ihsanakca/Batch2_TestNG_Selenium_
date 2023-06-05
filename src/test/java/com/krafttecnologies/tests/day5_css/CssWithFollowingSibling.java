package com.krafttecnologies.tests.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithFollowingSibling {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("edge");
        driver.get("http://www.krafttechexlab.com/");

        driver.manage().window().maximize();

        WebElement modul=driver.findElement(By.cssSelector("li[class='nav-item']~li[class='nav-item']"));
        modul.click();
    }

}
