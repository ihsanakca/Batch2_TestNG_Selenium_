package com.krafttecnologies.tests.day8_WebElements2;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isDisplayed {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement firstNameBox=driver.findElement(By.id("firstName"));

        System.out.println("firstNameBox.isDisplayed() = " + firstNameBox.isDisplayed());

        //verify firstNameBox is displayed or not

        Assert.assertTrue(firstNameBox.isDisplayed(),"verify is FAILED...");
    }

}
