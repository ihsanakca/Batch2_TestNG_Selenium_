package com.krafttecnologies.tests.day11_Waits;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleep {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        Thread.sleep(5000);

        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println("hello.getText() = " + hello.getText());
    }
}
