package com.krafttecnologies.test.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssMoreThanOneAtrribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("edge");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b'][type='text']"));
        searchBox.sendKeys("Database");

        WebElement searchButton = driver.findElement(By.cssSelector("div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']"));
        searchButton.click();

        Thread.sleep(2000);

        driver.close();
    }
}
