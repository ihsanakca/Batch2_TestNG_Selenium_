package com.krafttecnologies.tests.day2_webDriveBasic;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.google.com");
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.close();


        WebDriver driver1=WebDriverFactory.getDriver("Chrome");

        driver1.get("https://www.krafttechexlab.com");
        driver1.manage().window().setPosition(new Point(-1000,0));
        driver1.manage().window().maximize();
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";

        String actualTitle=driver1.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("titles are equal...");
        }else {
            System.out.println("titles are not EQUAL...");
        }
        Thread.sleep(2000);
        driver1.quit();


    }
}
