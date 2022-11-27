package com.krafttecnologies.tests.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssStartWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.cssSelector("input[id^='two']"));
        searchBox.sendKeys("Cucumber");

        WebElement searchButton=driver.findElement(By.cssSelector("input[id^='na']"));
        searchButton.click();

        Thread.sleep(2000);

        driver.close();


    }
}
