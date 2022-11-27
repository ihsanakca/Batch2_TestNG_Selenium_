package com.krafttecnologies.tests.day3_basic_locators;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement emailInputBox= driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@gmail.com");

        Thread.sleep(2000);
        //1.yol
        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("12345");



        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
        Thread.sleep(2000);

        //verify that you are on the dashboard page-doğrulamak...

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        System.out.println(driver.findElement(By.className("col-md-4")).getText());

//        driver.close();


    }
}
