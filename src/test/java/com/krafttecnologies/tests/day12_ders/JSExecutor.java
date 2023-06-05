package com.krafttecnologies.tests.day12_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSExecutor {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void jSExecutor() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/elements");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(3000);
        WebElement customRange1 = driver.findElement(By.id("customRange1"));
        actions.dragAndDropBy(customRange1, 200, 0).perform();
        Thread.sleep(3000);

        WebElement exampleColorInput = driver.findElement(By.id("exampleColorInput"));
        WebElement number = driver.findElement(By.xpath("//label[text()='File Upload']"));

        js.executeScript("arguments[0].scrollIntoView();", number);

        Thread.sleep(3000);

        //  js.executeScript("document.getElementByid('exampleColorInput').value='#FFEEXX'");
        //  js.executeScript("$('#exampleColorInput').value='#000000'");
        js.executeScript("arguments[0].setAttribute('value', '#FF0000')", exampleColorInput);

        Thread.sleep(3000);

        WebElement disableInput = driver.findElement(By.xpath("//input[@name='textDisabled']"));
        String text="AAAAAAA";
        js.executeScript("arguments[0].setAttribute('value', '"+text+"')", disableInput);

        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", submit);
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", number);
        Thread.sleep(3000);
      //  js.executeScript("arguments[0].click()", submit);

        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", submit);

        Thread.sleep(3000);

        System.out.println("title= "+js.executeScript("return document.title;").toString());
        System.out.println("url= "+js.executeScript("return document.URL;").toString());


    }
}