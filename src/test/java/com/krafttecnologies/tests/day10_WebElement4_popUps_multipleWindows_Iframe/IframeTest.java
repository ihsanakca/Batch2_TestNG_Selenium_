package com.krafttecnologies.tests.day10_WebElement4_popUps_multipleWindows_Iframe;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.close();  //current windowu kapatır...
        driver.quit(); //açılan tüm penceleri kapatır...
    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Batch 2 was here...");

        //how to switch the frame
        //first way: using NAME or ID
        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        Thread.sleep(2000);
        textArea.clear();
        Thread.sleep(2000);
        textArea.sendKeys("Batch 2 was here...");

        //second way: using INDEX
        driver.switchTo().parentFrame();//first we should go back to parent
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        textArea.clear();
        Thread.sleep(2000);
        textArea.sendKeys("Batch 2 was here two times...");

       driver.switchTo().parentFrame();
        Thread.sleep(2000);
        //third way: using WEB ELEMENT
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        Thread.sleep(2000);
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("Batch 2 was here three times...");
        Thread.sleep(2000);

    }

    @Test
    public void nestedFrame(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switch to middle and get MIDDLE text

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String middleText = driver.findElement(By.cssSelector("#content")).getText();
        System.out.println("middleText = " + middleText);

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();//en üste çıkacak.. selenium switch to top
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame(2);
        String rightText = driver.findElement(By.tagName("Body")).getText();
        System.out.println("rightText = " + rightText);

        //go to bottom frame and get text

        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame().switchTo().parentFrame();  //another way...
        driver.switchTo().frame(1);

        String bottomText = driver.findElement(By.tagName("Body")).getText();
        System.out.println("bottomText = " + bottomText);


    }
}
