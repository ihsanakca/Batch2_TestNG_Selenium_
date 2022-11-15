package com.krafttecnologies.test.day10_WebElement4_popUps_multipleWindows_Iframe;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void popUp() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5eaec");
//click to button
       driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();

//click to popUp Yes Button
       driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

       Thread.sleep(2000);

       //verify that confirm is accepted.

        String expectedText="You have accepted";
        WebElement actualtext = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualtext.getText(),expectedText,"FAIL");
    }

    @Test
    public void jSAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(1000);

        //click for JS Alert Button

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //e.g.1. switch to JS alert to popup
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK
        alert.accept();

       // e.g.2 -Click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //click to CANCEL
        alert.dismiss();

        //e.g.3 Click For JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        // içerisine yazı yazmak için /send keys to prompt
        alert.sendKeys("KraftTech Batch 2 was here");
        Thread.sleep(4000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();


    }

}
