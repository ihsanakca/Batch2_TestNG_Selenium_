package com.krafttecnologies.tests.day3_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZeroBank {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("http://zero.webappsecurity.com/index.html");
        driver.manage().window().maximize();

        driver.findElement(By.id("signin_button")).click();

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();
        driver.findElement(By.id("account_activity_link")).click();
        driver.findElement(By.xpath("//a[text()='Transfer Funds']")).click();


        WebElement amount = driver.findElement(By.id("tf_amount"));
        String required = amount.getAttribute("required");
        System.out.println(required);
        String validationMessage = amount.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);
       // Thread.sleep(2000);
        driver.findElement(By.linkText("Account Summary")).click();
       // Thread.sleep(2000);
        driver.findElement(By.linkText("Account Activity")).click();
       // Thread.sleep(2000);
        driver.findElement(By.linkText("Transfer Funds")).click();
       // Thread.sleep(2000);
        driver.findElement(By.linkText("Pay Bills")).click();
     //   Thread.sleep(2000);
        driver.findElement(By.linkText("My Money Map")).click();
      //  Thread.sleep(2000);
        driver.findElement(By.linkText("Online Statements")).click();
       // Thread.sleep(2000);



        driver.quit();


    }
}
