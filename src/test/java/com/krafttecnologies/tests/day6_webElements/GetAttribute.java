package com.krafttecnologies.tests.day6_webElements;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        //two way to get text from web elements
        //1. getText() --> it will work 99 percent and will get the text...
        //2.getAttribute("attribute name")--> second way of getting text especially from input boxex...

        String email="mike@gmail.com";
        String password="12345";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String expectedURL=driver.getCurrentUrl();
        Thread.sleep(1000);

        WebElement emailBox=driver.findElement(By.id("email"));
//        emailBox.sendKeys(email);

        Thread.sleep(2000);

        String value=emailBox.getAttribute("class");
        System.out.println("value = " + value);

        Thread.sleep(2000);

        driver.close();


    }
}
