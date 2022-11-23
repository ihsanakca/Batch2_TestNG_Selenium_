package com.krafttecnologies.test.day10_WebElement4_popUps_multipleWindows_Iframe;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/iframe");

        WebElement iframe= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement closeButton=driver.findElement(By.xpath("(//button[@class='btn-close btn-close-white'])[1]"));
        closeButton.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement actualText=driver.findElement(By.xpath("//h1[.='Iframe']"));
        System.out.println("actualText.getText() = " + actualText.getText());

        String expectedText="Iframe";

        Assert.assertEquals(actualText.getText(),expectedText,"FAIL");
        Thread.sleep(2000);

    }
}
