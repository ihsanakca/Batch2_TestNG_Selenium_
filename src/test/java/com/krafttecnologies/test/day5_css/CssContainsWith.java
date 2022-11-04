package com.krafttecnologies.test.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssContainsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("edge");
        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.cssSelector("input[id*='search']"));
        searchBox.sendKeys("Postman");

        WebElement searchButton=driver.findElement(By.cssSelector("input[id*='submit-']"));
        searchButton.click();

        Thread.sleep(2000);

        driver.close();
    }
}
