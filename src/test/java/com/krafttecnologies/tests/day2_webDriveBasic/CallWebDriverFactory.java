package com.krafttecnologies.tests.day2_webDriveBasic;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("Firefox");

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        driver.close();


        WebDriver driver1=WebDriverFactory.getDriver("Firefox");

        driver1.get("https://www.krafttechexlab.com");
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";

        String actualTitle=driver1.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("titles are equal...");
        }else {
            System.out.println("titles are not EQUAL...");
        }

    }
}
