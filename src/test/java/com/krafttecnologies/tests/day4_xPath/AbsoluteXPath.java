package com.krafttecnologies.tests.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbsoluteXPath {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.krafttechexlab.com/");
        driver.manage().window().maximize();

        String actualText=driver.findElement(By.xpath("/html/body/main/div/h1")).getText();
        System.out.println(actualText);
    }
}
