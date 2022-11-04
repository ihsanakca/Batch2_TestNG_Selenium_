package com.krafttecnologies.test.day6_webElements;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * open the chrome browser
         * go to https://www.krafttechexlab.com/login
         * click on login button
         * verify that url did not changed
         */



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String expectedURL=driver.getCurrentUrl();
        Thread.sleep(1000);

        WebElement loginButton=driver.findElement(By.tagName("button"));
        loginButton.click();

       String currentURL=driver.getCurrentUrl();

       if (currentURL.equals(expectedURL)){
           System.out.println("PASS");
       }else {
           System.out.println("FAILED");
       }

       Thread.sleep(1000);
       driver.close();


    }
}
