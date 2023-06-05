package com.krafttecnologies.tests.day3_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KraftLogin {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("https://www.krafttechexlab.com/login");
        driver.manage().window().maximize();

        WebElement form= driver.findElement(By.xpath("//input[@type='text']/parent::div[@*='col-12']/parent::*"));
       // System.out.println("form.getText() = " + form.getText());
        System.out.println("form.getAttribute(\"outerHTML\") = " + form.getAttribute("outerHTML"));
        System.out.println("form.getAttribute(\"innerHTML\") = " + form.getAttribute("innerHTML"));

        driver.close();

    }
}
