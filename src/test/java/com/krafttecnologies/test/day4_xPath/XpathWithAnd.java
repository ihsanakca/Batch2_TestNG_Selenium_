package com.krafttecnologies.test.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithAnd {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.hepsiburada.com/");

        WebElement seachBox=driver.findElement(By.xpath("//input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        seachBox.sendKeys("java");

        WebElement seachBox2=driver.findElement(By.xpath("//input[@type='fghfhfgh' or @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        seachBox2.sendKeys(" kitap");
        WebElement searchButton=driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));

        searchButton.click();

        driver.manage().window().maximize();
    }
}
