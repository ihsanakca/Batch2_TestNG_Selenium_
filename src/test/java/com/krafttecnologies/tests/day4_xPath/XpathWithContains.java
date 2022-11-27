package com.krafttecnologies.tests.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithContains {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("edge");
        driver.get("http://www.krafttechexlab.com/index");

        String text=driver.findElement(By.xpath("//li[contains(text(),'Users')]")).getText();
        System.out.println("text = " + text);
    }
}
