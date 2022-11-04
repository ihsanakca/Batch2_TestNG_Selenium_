package com.krafttecnologies.test.day6_webElements;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {
    public static void main(String[] args) {
        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */
        String product = "java";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr");

        WebElement cookiesButton=driver.findElement(By.id("sp-cc-accept"));
        cookiesButton.click();

        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys(product);

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        String actualText=driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]/..")).getText();
        System.out.println("actualText = " + actualText);


        if (actualText.contains(product)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }


        driver.close();

    }
}
