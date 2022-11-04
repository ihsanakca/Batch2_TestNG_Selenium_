package com.krafttecnologies.test.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssParentToChildNthOfType {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("edge");
        driver.get("http://www.krafttechexlab.com/");

        WebElement text=driver.findElement(By.cssSelector("div[class='row'] :nth-of-type(1)"));
        String text1 = text.getText();
        System.out.println("text1 = " + text1);

        driver.close();
    }
}

