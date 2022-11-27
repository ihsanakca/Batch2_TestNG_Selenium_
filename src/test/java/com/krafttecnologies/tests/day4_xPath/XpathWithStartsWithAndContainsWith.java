package com.krafttecnologies.tests.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithStartsWithAndContainsWith {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("edge");
        driver.get("https://www.hepsiburada.com");

        WebElement searchBox=driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));

        searchBox.sendKeys("Selenium");

        WebElement searchButton=driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));

        searchButton.click();

        driver.manage().window().maximize();
    }
}
