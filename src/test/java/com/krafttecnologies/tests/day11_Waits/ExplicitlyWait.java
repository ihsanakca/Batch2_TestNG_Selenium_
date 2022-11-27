package com.krafttecnologies.tests.day11_Waits;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWait {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        //**** how to wait explicitly wait...
        //create an explicitly wait object..

        WebDriverWait wait=new WebDriverWait(driver,15);

        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        //it will wait up to 15 seconds until hello element is visible..

        wait.until(ExpectedConditions.visibilityOf(hello));

        System.out.println("hello.getText() = " + hello.getText());

        Assert.assertEquals(hello.getText(),"Hello World!");
    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebDriverWait wait=new WebDriverWait(driver,10);

//        driver.findElement(By.xpath("//input[@type=text]")).sendKeys("Batch 2 was here..."); //hata verir bekleme olmadığından

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Batch 2 was here...");

        WebElement message=driver.findElement(By.xpath("//p[@id='message']"));

        System.out.println("message.getText() = " + message.getText());

        Assert.assertEquals(message.getText(),"It's enabled!","FAIL");

    }
}
