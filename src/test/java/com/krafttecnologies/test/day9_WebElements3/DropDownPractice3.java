package com.krafttecnologies.test.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice3 {
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

        List<WebElement> options=driver.findElements(By.xpath("//input[@type='checkbox']"));

        if (!options.get(0).isSelected()){
            options.get(0).click();
        }
        Thread.sleep(3000);
        if (!options.get(3).isSelected()){
            options.get(3).click();
        }
        Thread.sleep(3000);
        if (options.get(2).isSelected()){
            options.get(2).click();
        }
        Thread.sleep(3000);

//        options.get(0).click();
//        options.get(3).click();
//        options.get(2).click();

        Thread.sleep(3000);
    }
}
