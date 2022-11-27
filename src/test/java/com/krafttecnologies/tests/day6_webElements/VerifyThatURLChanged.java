package com.krafttecnologies.tests.day6_webElements;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {

        /**
         *         open chrome browser
         *          go to https://www.krafttechexlab.com/login
         *         enter email as mike@gmail.com
         *         enter password as 12345
         *         click login btn
         *         verify that Url has changed
         */

        String email="mike@gmail.com";
        String password="12345";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String expectedURL=driver.getCurrentUrl();
        Thread.sleep(1000);

        WebElement emailBox=driver.findElement(By.id("email"));
        emailBox.sendKeys(email);

        WebElement passwordBox=driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(password);

        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();

        String currentURL=driver.getCurrentUrl();

        if (currentURL.equals(expectedURL)){
            System.out.println("FAILED");
        }else {
            System.out.println("PASS");
        }

        Thread.sleep(1000);
        driver.close();
    }
}
