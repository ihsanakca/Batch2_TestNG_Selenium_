package com.krafttecnologies.test.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownPractice2 {
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
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement option3= driver.findElement(By.xpath("//input[@value='option-3']"));
        option3.click();
        Thread.sleep(3000);

        WebElement options1=driver.findElement(By.xpath("//input[@value='option-1']"));
        options1.click();
        Thread.sleep(3000);

        WebElement options4=driver.findElement(By.xpath("//input[@value='option-4']"));
        options4.click();
        Thread.sleep(3000);
    }
}
