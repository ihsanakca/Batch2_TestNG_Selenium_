package com.krafttecnologies.test.day8_WebElements2;

import com.beust.ah.A;
import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
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
    public void test() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement radio1=driver.findElement(By.id("gridRadios1"));
        WebElement radio2=driver.findElement(By.id("gridRadios2"));

        System.out.println("radio1.isSelected() = " + radio1.isSelected());
        System.out.println("radio2.isSelected() = " + radio2.isSelected());

        Assert.assertTrue(radio1.isSelected(), "FAIL");
        Assert.assertFalse(radio2.isSelected(),"FAIL");

        Thread.sleep(3000);

        radio2.click();

        Assert.assertFalse(radio1.isSelected(),"FAIL");
        Assert.assertTrue(radio2.isSelected(),"FAIL");
    }
}
