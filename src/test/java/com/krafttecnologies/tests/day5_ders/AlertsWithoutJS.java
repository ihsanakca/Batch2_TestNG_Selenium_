package com.krafttecnologies.tests.day5_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsWithoutJS {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        String username="sgezer@gmail.com";
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        String actualUsername = driver.findElement(By.id("nameofuser")).getText();

        Assert.assertTrue(actualUsername.contains(username));
    }

    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        WebElement alertExamples1 = driver.findElement(By.id("alertexamples"));
        alertExamples1.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);

        WebElement alertExamples2 = driver.findElement(By.id("confirmexample"));
        alertExamples2.click();
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(2000);

        String actualText=driver.findElement(By.id("confirmreturn")).getText();
        String expectedText="false";

        Assert.assertEquals(actualText,expectedText);

        alertExamples2.click();
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
        Thread.sleep(2000);

        String actualText1=driver.findElement(By.id("confirmreturn")).getText();
        String expectedText1="true";
        Assert.assertEquals(actualText1,expectedText1);
        Thread.sleep(2000);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement alertExamples3 = driver.findElement(By.id("promptexample"));
        alertExamples3.click();
        Thread.sleep(2000);
        String expectedText2="Ahmet";
        Thread.sleep(2000);
        alert.sendKeys(expectedText2);
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();
        Thread.sleep(5000);

        String actualText2=driver.findElement(By.id("promptreturn")).getText();

        Assert.assertEquals(actualText2,expectedText2);


    }


}
