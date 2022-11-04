package com.krafttecnologies.test.day5_css;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssId {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Css Selector");

        WebElement searchButton=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(2000);

        driver.close();

    }
}
