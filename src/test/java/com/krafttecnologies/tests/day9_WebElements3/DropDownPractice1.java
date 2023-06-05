package com.krafttecnologies.tests.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice1 {
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

    driver.get(" http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement dropDown1=driver.findElement(By.id("dropdowm-menu-1"));

        Select dropDown1Select=new Select(dropDown1);

        dropDown1Select.selectByIndex(3);

        String expectedText1="SQL";
        String actualText1=dropDown1Select.getFirstSelectedOption().getText();
        System.out.println("actualText1 = " + actualText1);

        Assert.assertEquals(actualText1,expectedText1,"FAIL");
        Thread.sleep(2000);

        WebElement dropDown2=driver.findElement(By.id("dropdowm-menu-2"));
        Select dropDown2Select=new Select(dropDown2);

        dropDown2Select.selectByIndex(2);

        String expectedText2="TestNG";
        String actualText2=dropDown2Select.getFirstSelectedOption().getText();
        System.out.println("actualText2 = " + actualText2);

        Assert.assertEquals(actualText2,expectedText2,"FAIL");
        Thread.sleep(2000);

        WebElement dropDown3=driver.findElement(By.id("dropdowm-menu-3"));
        Select dropDown3Select=new Select(dropDown3);
        dropDown3Select.selectByIndex(1);

        String expectedText3="CSS";
        String actualText3=dropDown3Select.getFirstSelectedOption().getText();
        System.out.println("actualText3 = " + actualText3);

        Assert.assertEquals(actualText3,expectedText3,"FAIL");
        Thread.sleep(2000);

    }





}