package com.krafttecnologies.tests.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice4 {
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

        List<WebElement> radioButtons=driver.findElements(By.xpath("//input[@name='color']"));
        System.out.println("radioButtons.size() = " + radioButtons.size());

        radioButtons.get(2).click();
        Thread.sleep(3000);

        for (WebElement radio:radioButtons) {
            System.out.println("radio.getText() = " + radio.getAttribute("value"));
        }

        WebElement blue=driver.findElement(By.xpath("//input[@value='blue']"));//bunu indexle yapabiliriz de..
        blue.click();
        Thread.sleep(3000);

    }
}
